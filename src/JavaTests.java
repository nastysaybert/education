import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.*;

public class JavaTests {
    public static void main(String[] args) throws InterruptedException {
        //пул потоков
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++)
            //передали 5 заданий
            executorService.submit(new Work(i));
        //приступаем к выполнению заданий
        executorService.shutdown();
        System.out.println("All tasks are submited");
        //сколько ждать времени до конца исполнения потоков
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Work implements Runnable{
    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " is completed");
    }
}