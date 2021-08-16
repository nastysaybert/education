import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaTests {
    public static void main(String[] args)  {
        /*
        \\d - одна цифра
        \\w - одна англ буква
        +   - один или более
        *   - 0 или более
        ?   - 0 или 1 символов до..
        (x|y|z)  - или x, или y, или z. Вариант из множества
        [a-zA-Z] - все буквы англ алфавита, строчные и прописные
        [1-9]    - аналогично \\d
        [^]      - символы, кроме множества
        .        - абсолютно любой символ
        {2}      - 2 символа до..
        {2, }    - от 2х символов до..
        {2, 7}   - от 2 до 7 символов до..
         */
        String a = "Hello there hey";
        //String[] words = a.split("[1-9]+");

        a = a.replaceAll(" ", ".");
        String[] words = a.split("\\.");
        System.out.println(Arrays.toString(words));
    }
}
