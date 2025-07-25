package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class StringArrayStream {

    public static void main(String[] args) {
        System.out.println(" \n IntegerArrayStream Sample Program.. \n ");
        String[] nameArray = {"Germany", "USA", "poland", "Newzeland", "Austia", "Switzerland"};

        Arrays.stream(nameArray)
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        System.out.println(" \n With Filter.. \n ");
        Arrays.stream(nameArray)
                .sorted()
                .filter(name -> name.length() <= 8)
                .map(n -> n.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);

        System.out.println(" \n stringList after assigned with data.. \n ");
        List<String> stringList = Arrays.stream(nameArray)
                .limit(4).map(name->name.toUpperCase(Locale.ROOT))
                .toList();
        stringList.stream().forEach(System.out::println);

        System.out.println(" \n stringList after assigned with data.. \n ");



    }
}
