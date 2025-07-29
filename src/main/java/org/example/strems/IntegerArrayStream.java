package org.example.strems;

import java.util.Arrays;

public class IntegerArrayStream {

    public static  void main (String[] args){
        System.out.println(" \n IntegerArrayStream Sample Program.. \n ");
        int[] numberArray =  {1,2,3,4,5,6,7,8,9,10,11};

        Arrays.stream(numberArray).filter(n-> n > 7).limit(4).forEach(System.out::println);

        System.out.println(" \n IntList after assigned with data.. \n ");
        int[] intList = Arrays.stream(numberArray).limit(4).toArray();
        Arrays.stream(intList).forEach(System.out::println);

    }
}
