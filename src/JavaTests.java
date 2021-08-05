import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class JavaTests {
    public static void main(String[] args) throws InterruptedException {
        //потоки не синхронизированы, борятся за процессорное время
//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        Thread.sleep(1000);
//        MyThread myThread2 = new MyThread();
//        myThread2.start();

//        System.out.println("I'm going to sleep");
//        Thread.sleep(3000);
//        System.out.println("I am awake");

        Thread thread = new Thread(new Runner());
        thread.start();
        System.out.println("Hello from main thread");

    }
}

//лучше делать так
class Runner implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread " + i);
        }
    }
}

class MyThread extends Thread{
    public void run(){
        //Здесь будет выполняться код, исполняемый в текущем потоке
        for (int i = 0; i<10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread " + i);
        }
    }
}