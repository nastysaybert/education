import javax.crypto.spec.PSource;

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

        String a = "-1234";
        String b = "1235";
        String c = "+12345672";
        String regex = "[a-zA-Z31]*(-|\\+)?\\d*";
        System.out.println(a.matches(regex));
        System.out.println(b.matches(regex));
        System.out.println(c.matches(regex));

        String d = "afg3311ihjk145678";
        System.out.println(d.matches(regex));
        String e = "hello";
        System.out.println(e.matches("[^abc]*"));

        String url = "http://www.google.com";
        String url2 = "http://www.yandex.ru";
        System.out.println(url.matches("http://www\\..+\\.(com|ru|biz|de)"));

        System.out.println(b.matches("\\d{2,}"));
    }
}
