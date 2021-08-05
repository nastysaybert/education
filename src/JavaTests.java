import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class JavaTests {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        JavaTests javaTests = new JavaTests();
        javaTests.doWork();
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<1000; i++){
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<1000; i++){
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }


    //синхронизированными могут быть только методы
    //такая пометка говорит о том, что тело метода может быть
    //исполнено только одним потоком в единый момент времени
    public void increment(){
        //synchronized block
        synchronized (this){
            counter++;
        }

    }
}

