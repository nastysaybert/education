import com.sun.source.tree.WhileLoopTree;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Executable{
    int execute( int x, int y);
}

class Runner{
    public void run (Executable e){
        System.out.println(e.execute(10, 5));
    }
}

public class JavaTests {
    public static void main(String[] args)  {
        Runner runner = new Runner();

        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                System.out.println("Hello2");
                return x + y;
            }
        });
//        runner.run(() -> {
//            System.out.println("Hello3");
//            System.out.println("Bye");
//            return 2;
//        });

        runner.run((x, y) -> x + y);
    }
}
