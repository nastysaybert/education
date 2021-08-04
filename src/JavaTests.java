import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class JavaTests {
    public static void main(String[] args) {
        //Queue - FIFO
        //Stack - LIFO
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(1);


//        System.out.println(stack.peek());   //посмотрели
//        System.out.println(stack.pop());    //посмотрели и удалили

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}

