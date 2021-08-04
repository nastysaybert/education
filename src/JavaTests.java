import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class JavaTests {
    public static void main(String[] args) {
        Map<Person,String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        Person person1 = new Person(1,"Mike");
        Person person2 = new Person(1,"Mike");

        map.put(person1, "123");
        map.put(person2, "123");

        set.add(person1);
        set.add(person2);

        System.out.println(map);
        System.out.println(set);

    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "Person{" + id + ", name =" + name + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                name.equals(person.name);
    }
    // преобразование объекта произвольной длины в строку/число фиксированной длины
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    /* Контракт Hashcode-equals:
    Сравнили 2 объекта через хэш:
    1. хэши разные = объекты точно разные (быстрая операция)
    2. хеши совпадают ->
        либо однаковые, либо только их хэши (коллизия хеширования):
        2.1. вызываем equals (медленная операция) -> получаем однозначный результат
     */
}
