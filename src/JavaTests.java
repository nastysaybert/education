import com.sun.source.tree.WhileLoopTree;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaTests {
    public static void main(String[] args)  {
       String text = "Текст – это несколько предложений, " +
               "связанных a@yandex.ru между собой по смыслу и грамматически. " +
               "Есть и более «сложная» tom@mail.com формулировка данного определения. " +
               "Текст – это john@gmail.com последовательное объединение предложений, " +
               "которое представляет собой смысловую, содержательную и структурную целостность.";

        Pattern email = Pattern.compile("(\\w+)@(gmail|mail|yandex)\\.(com|ru)");
        Matcher matcher = email.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group(2));
        }
    }
}
