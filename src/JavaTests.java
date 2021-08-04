import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class JavaTests {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("dog");
        animals.add("z");
        animals.add("ab");
        animals.add("bird");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

        Collections.sort(animals,new StringLengthComparator());
        System.out.println(animals);

        System.out.println(numbers);
        //Collections.sort(numbers,new BackwardsIntsComparator());

        //то же самое.
        //если надо вызвать 1 раз, можно реализовать через анонимный класс, как показано ниже

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return -1;
                } else if (o1<o2){
                    return 1;
                } else return 0;
            }
        });

        //или так, через лямбда
        Collections.sort(numbers, (o1, o2) -> {
            if(o1>o2){
                return -1;
            } else if (o1<o2){
                return 1;
            } else return 0;
        });
        System.out.println(numbers);

        List<Person> people = new ArrayList<>();
        people.add(new Person(3,"Katy"));
        people.add(new Person(1,"Mike"));
        people.add(new Person(2,"Bob"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId()>o2.getId()){
                    return 1;
                } else if (o1.getId()<o2.getId()){
                    return -1;
                } else return 0;
            }
        });
        System.out.println(people);

    }
}

class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        /*
        Если    о1 > o2 -> 1
                о1 < o2 -> -1
                о1 = o2 -> 0
         */
        if(o1.length()>o2.length()){
            return 1;
        } else if (o1.length()<o2.length()){
            return -1;
        } else return 0;
    }
}

class BackwardsIntsComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        /*
        Если    о1 > o2 -> 1
                о1 < o2 -> -1
                о1 = o2 -> 0
         */
        if(o1>o2){
            return -1;
        } else if (o1<o2){
            return 1;
        } else return 0;
    }
}


class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
