import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.*;

public class JavaTests {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread started...");
            //вызывается на контексте (в данном случае на объекте this)
            //на этом же объекте должен быть вызван потом notify
            //либо надо указать конкретно, на каком объекте вызывать
            wait();     //1. отдаем intrinsic lock, 2. ждем вызова notify
            System.out.println("Producer thread resumed...");
        }
    }
    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            notify();       //разбудить один поток  //не освободит intrinsic lock пока не закончится блок кода
//          notifyAll();    //разбудить все потоки
            Thread.sleep(5000);
        }
    }
}