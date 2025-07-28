package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperations {

    public static void main(String[] args) {
        System.out.println(" **** TerminalOperations ****/n");

        List<String> terminalOps = Arrays.asList("* foreach() ", "* reduce()", "* count()", "* firstFirst() ", "* allMatch()", "* anyMatch()");

        terminalOps.stream()
                //.map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println(" \n Result ");

        List<String> countriesArray = Arrays.asList("USA", "Germany", "Franch", " Myanmar", "Beigium", "Holland", "England", "Srilanka");
        System.out.println("  Collect ");

        List<String> collectString = countriesArray.stream().collect(Collectors.toList());
        collectString.forEach(System.out::println);

        System.out.println("  Reduce ");
        String concatenatedCountries = countriesArray.stream().reduce("", (name, name2) -> name + " " + name2);
        System.out.println("\nreduce (concatenated names):");
        System.out.println(concatenatedCountries.trim());


        System.out.println("  joining ");
        String joiningCountries = countriesArray.stream().collect(Collectors.joining(" * "));
        System.out.println("\ncollect  (joining names):");
        System.out.println(joiningCountries.trim());

        System.out.println(" \n count " + countriesArray.stream().count());

        System.out.println(" \n findAny" + countriesArray.stream().sorted().findAny());

        System.out.println(" \n findFirst" + countriesArray.stream().sorted().findFirst());

        System.out.println(" \n anyMatch  - ma " + countriesArray.stream().anyMatch(name -> name.contains("ma")));

        countriesArray.stream().filter(name -> name.contains("ma")).forEach(System.out::println);

        System.out.println(" \n allMatch  - z " + countriesArray.stream().allMatch(name -> name.contains("z")));

        System.out.println(" \n allMatch  - a " + countriesArray.stream().allMatch(name -> name.contains("a")));

    }
}
