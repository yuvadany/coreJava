package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MapSorting {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        System.out.println("\n Streams Map Sorting  Sample Program " + formatter.format(LocalDateTime.now()));
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("Mike", 78));
        personList.add(new Person("Schmacher", 28));
        personList.add(new Person("Hellmann", 37));
        personList.add(new Person("Anwar", 18));

        personList.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .map(p -> p.getName())
                .forEach(System.out::println);

        ArrayList<Person2> personList2 = new ArrayList<>();
        personList2.add(new Person2("Mengel", 78));
        personList2.add(new Person2("sobald", 28));
        personList2.add(new Person2("Angst", 37));
        personList2.add(new Person2("Adler", 18));

// Comparable implemented in Person2 Class
        personList2.stream()
                .sorted()
                .map(p -> p.getName())
                .forEach(System.out::println);


        // Assigning to a List
        System.out.println("\n  Assigning to a List... \n");
        List<String> nameList = personList2.stream()
                .sorted()
                .map(person2 -> person2.getName()).toList();

        nameList.stream().forEach(System.out::println);

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


    static class Person2 implements Comparable {
        private String name;

        private int age;

        public Person2(String name, int age) {
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

        @Override
        public int compareTo(Object o) {
            return getName().compareTo(((Person2) o).getName());
        }
    }

}
