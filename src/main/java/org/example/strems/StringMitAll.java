package org.example.strems;

import java.util.*;

public class StringMitAll {

    public static void main(String[] args) {
        System.out.println(" List<List<String>> Streams - Filter , Flatmap , map,  distinct, sorted, peek und collect  ,  ");
       List<List<String>>  stringListOfList = Arrays.asList(
               Arrays.asList("ich","du","er","es"),
               Arrays.asList("sie","Sie","ihr"),
               Arrays.asList("wir","mein","dein"),
               Arrays.asList("ihr","Ihr","unser"),
               Arrays.asList("unsere","eure","wie")
       );
        Set<String> stringSet  = new HashSet<>() ;

        stringListOfList.stream()
                .flatMap(List::stream)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .peek(data-> stringSet.add(data))
                .forEach(System.out::println);

        System.out.println(" Peek - intermediate Data in set  - ohne sorting kommt");
        // Peek function
        stringSet.forEach(System.out::println);
    }




}
