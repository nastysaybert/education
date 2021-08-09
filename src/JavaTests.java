import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Locale;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JavaTests {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        try {
            semaphore.acquire();        //занимает одно из permits (разрешений),
            semaphore.acquire();        //если нет свободных, будет ждать освобождения
            semaphore.acquire();
            System.out.println("All permits have been acquired");

            semaphore.acquire();

            System.out.println("Cant reach here...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();            //отпускает одно из permits
        semaphore.availablePermits();   //кол-во доступных permits
        System.out.println(semaphore.availablePermits());
    }
}