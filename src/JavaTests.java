import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class JavaTests {
    public static void main(String[] args) {
        new Worker().main();
    }
}

class Worker{
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    Random r = new Random();

    //выделяем 2 объекта, на которые будем синхронизироваться.
    // Если занят один - можем взять второй
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void addToList1(){
        synchronized (lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(r.nextInt(100));
        }
    }

    public void addToList2(){
        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(r.nextInt(100));
        }
    }

    public void work(){
        for (int i = 0; i <1000; i++){
            addToList1();
            addToList2();
        }
    }

    public void main(){
        long before = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();
        System.out.println("Program took " + (after-before) + " ms to run");

        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }
}
