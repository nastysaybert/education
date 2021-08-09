import java.util.Locale;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JavaTests {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}

class Runner{
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();


    private void takeLocks (Lock lock1, Lock lock2){
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;
        while (true){
            try{
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken){
                    return;
                }
                if (firstLockTaken){
                    lock1.unlock();
                }
                if (secondLockTaken){
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread(){
        Random random = new Random();

//         Большая вложенность - плохо
//        for (int i = 0; i<10000; i++){
//            //Account.transfer(account1,account2,random.nextInt(100));
//            synchronized (account1){
//                synchronized (account2){
//                    Account.transfer(account1,account2,random.nextInt(100));
//                }
//            }
//        }

        for (int i = 0; i<10000; i++){
            takeLocks(lock1,lock2);
            try{
                Account.transfer(account1,account2,random.nextInt(100));
            } finally {         //обязательно unlock в finally-блоке
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread(){
        Random random = new Random();
        for (int i = 0; i<10000; i++){
            takeLocks(lock1,lock2);
            try{
                Account.transfer(account2,account1,random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished(){
        System.out.println(account1.getBallance());
        System.out.println(account2.getBallance());
        System.out.println("Total ballance: " + (account1.getBallance()+account2.getBallance()));
    }
}

class Account{
    private int ballance = 10000;

    public void deposit (int amount){
        ballance +=amount;
    }

    public void withdraw (int amount){
        ballance-=amount;
    }

    public int getBallance() {
        return ballance;
    }

    public static void transfer(Account account1, Account account2, int amount){
        account1.withdraw(amount);
        account2.deposit(amount);
    }
}
