import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class JavaTests {
    public static void main(String[] args) {

        Map<Integer, String> hashMap = new HashMap<>();                     //не гарантирует порядок значений
        Map<Integer,String>  linkedHashMap = new LinkedHashMap<>();         //гарантируется порядок по добавлению
        Map<Integer,String> treeMap = new TreeMap<>();                      //сотритует по значению ключа

        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map){
        map.put(39,"Bob");
        map.put(12,"Mike");
        map.put(78,"Tom");
        map.put(0,"Tim");
        map.put(1500,"Lewis");
        map.put(7,"Bob");

        for (Map.Entry<Integer,String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
