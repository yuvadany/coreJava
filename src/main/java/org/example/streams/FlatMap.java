package org.example.streams;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        System.out.println("\n FlatMap Program " + formatter.format(LocalDateTime.now()));
        List<Business> business = new ArrayList<>();
        ArrayList<Person> personList1 = new ArrayList<>();
        personList1.add(new Person("MikeGoogle", 78));
        personList1.add(new Person("SchmacherGoogle", 28));
        personList1.add(new Person("HellmannGoogle", 37));
        personList1.add(new Person("OvidioGoogle", 18));
        business.add(new Business("Google", personList1));

        ArrayList<Person> personList2 = new ArrayList<>();
        personList2.add(new Person("MikeAmazon", 78));
        personList2.add(new Person("SchmacherAmazon", 28));
        personList2.add(new Person("HellmannAmazon", 37));
        personList2.add(new Person("OvidioAmazon", 18));
        business.add(new Business("Amazon", personList2));

        ArrayList<Person> personList3 = new ArrayList<>();
        personList3.add(new Person("MikeTesla", 78));
        personList3.add(new Person("SchmacherTesla", 28));
        personList3.add(new Person("HellmannTesla", 37));
        personList3.add(new Person("OvidioTesla", 18));
        business.add(new Business("Tesla", personList3));
// Printing Company Names
        business.stream().sorted((b1, b2) -> b1.getFirmaName().compareTo(b2.getFirmaName()))
                .map(Business::getFirmaName)
                .forEach(System.out::println);
// Flatmap to get Employee Names
        System.out.println("\n");
        business.stream().flatMap(business1 -> business1.getPerson().stream())
                .map(Person::getName).forEach(System.out::println);
        System.out.println("\n Employees of Particular Company >Tesla \n");
        business.stream().filter(business1 -> business1.getFirmaName().equalsIgnoreCase("Tesla"))
                .flatMap(business1 -> business1.getPerson().stream())
                .map(Person::getName)
                .forEach(System.out::println);

        System.out.println("\n Employees of Particular Company >Google \n");
        business.stream().filter(business1 -> business1.getFirmaName().equalsIgnoreCase("google"))
                .flatMap(business1 -> business1.getPerson().stream())
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).map(Person::getName)
                .limit(3)
                .forEach(System.out::println);


        System.out.println("\n Employees of Particular Company >Amazon - starts with A \n");
        business.stream()
                .filter(business1 -> business1.getFirmaName().startsWith("A"))
                .flatMap(business1 -> business1.getPerson().stream())
                .limit(2)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).map(Person::getName)
                .forEach(System.out::println);


        System.out.println("\n Collect in Collectors - Employees of Particular Company >Amazon/Tesla/Google - starts with A or G or T \n");
        String names = business.stream()
                .filter(business1 -> business1.getFirmaName().startsWith("A"))
                .flatMap(business1 -> business1.getPerson().stream())
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).map(Person::getName)
                .limit(1)
                .collect(Collectors.joining(" , "));


        System.out.println(names);

    }



    static class Business {
        private String FirmaName;
        private ArrayList<Person> person;

        public Business(String firmaName, ArrayList<Person> person) {
            FirmaName = firmaName;
            this.person = person;
        }

        public String getFirmaName() {
            return FirmaName;
        }

        public void setFirmaName(String firmaName) {
            FirmaName = firmaName;
        }

        public ArrayList<Person> getPerson() {
            return person;
        }

        public void setPerson(ArrayList<Person> person) {
            this.person = person;
        }
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
