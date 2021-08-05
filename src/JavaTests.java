import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class JavaTests {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        //хотим по нажатию на enter в консоли завершать поток


        Scanner scanner= new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();
    }
}

class MyThread extends Thread{

    //помечаем переменную ключевым словом volatile, чтобы она не кешировалась
    // каждым исполняющим потоком компьютера отдельно,
    //чтобы не возникало проблемы когерентности кэшей

    //использовать всегда для данных, которые могут делить между собой несколько потоков
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running){
            System.out.println("Hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        this.running = false;
    }
}