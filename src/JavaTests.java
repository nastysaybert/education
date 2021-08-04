import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class JavaTests {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        //Queue <Person> people = new LinkedList<>();

        Queue <Person> people = new ArrayBlockingQueue<Person>(3);


        //add выдаст ошибку, offer вернет спец.значение (false)
        System.out.println(people.offer(person3));
        System.out.println(people.offer(person2));
        System.out.println(people.offer(person4));
        System.out.println(people.offer(person1));

//        people.add(person3);
//        people.add(person2);
//        people.add(person4);
//        people.add(person1);
//
//        System.out.println(people.remove());        //посмотрели и удалили
//        System.out.println(people.peek());          //только посмотрели
//        System.out.println(people);
    }
}

class Person{
    private int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
