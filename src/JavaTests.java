import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class JavaTests {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Set<Person> peopleSet = new TreeSet<>();

        addElements(people);
        /*
        При попытке добавить в TreeSet два элемента, которые, согласно
        нашему компоратору, равны (здесь - длина имени одинакова),
        добавится только один элемент, тот, который добавляли раньше
         */
        addElements(peopleSet);

        Collections.sort(people);
        System.out.println(people);
        System.out.println(peopleSet);
    }

    private static void addElements(Collection collection){
        collection.add(new Person(4, "Mike"));
        collection.add(new Person(2, "Bo"));
        collection.add(new Person(3, "Kathy"));
        collection.add(new Person(1, "Thomas"));
    }
}

class Person implements Comparable<Person>{
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.length() > o.getName().length()){
            return 1;
        }else if (this.name.length() < o.getName().length()){
            return -1;
        } else {
            return 0;
        }
    }
}
