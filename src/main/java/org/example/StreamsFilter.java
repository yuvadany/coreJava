package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StreamsFilter {

    public static void main(String[] args) {
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm:ss a");
        System.out.println("\n Streams Filer Sample Program "+ formatter.format(LocalDateTime.now()));
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Mike", 78));
        personList.add(new Person("Schmacher", 28));
        personList.add(new Person("Hellmann", 37));
        personList.add(new Person("Ovidio", 18));

        List<Person> majorList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge() > 18)
                majorList.add(person);
        }

        List<Person> majorsStreamList = personList.stream()
                .filter(p -> p.getAge() > 18)
                .toList();

        System.out.println("\n Both the major lists are equal...");
        System.out.println(majorList.equals(majorsStreamList));
    }

    static class Person {
        private String name;

        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
