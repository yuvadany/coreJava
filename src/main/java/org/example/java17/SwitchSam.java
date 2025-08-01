package org.example.java17;

import java.time.LocalDate;

public class SwitchSam {
    public static void main(String[] args) {
        System.out.println("*********** Java 17 Switch case with new changes *************");
        int day = 6;
        System.out.println("Old Switch with break statement");
        switch (day) {
            case 1:
                System.out.println(" Monday");
                break;
            case 2:
                System.out.println(" Tuesday");
                break;
            case 3:
                System.out.println(" Wednesday");
                break;
            case 4:
                System.out.println(" Thursday");
                break;
            case 5:
                System.out.println(" Fridday");
                break;
            case 6:
                System.out.println(" Saturday");
                break;
            case 7:
                System.out.println(" Sunday");
                break;
            default:
                System.out.println(LocalDate.now());
        }


        //Day based Alarm - with String as input and break
        System.out.println(" ************ with String as input and break ********  ");
        String dayOfWeek = "Wednesday";
        switch (dayOfWeek) {
            case "Monday", "Wednesday":
                System.out.println("wake up at 7:30 ");
                break;
            case "Tuesday", "Friday":
                System.out.println("wake up at 8:30 ");
                break;
            default:
                System.out.println("wake up at 6:30 ");
        }


        //Day based Alarm - with Arrow key and without break

        System.out.println(" ************ with Arrow key and without break ********  ");
        switch (dayOfWeek) {
            case "Monday", "Wednesday" ->
                System.out.println("wake up at 7:30 ");
            case "Tuesday", "Friday" ->
                System.out.println("wake up at 8:30 ");
            default ->
                System.out.println("wake up at 6:30 ");
        }


        //Getting a result from Switch
        System.out.println(" ************ switch returns value ********  ");

        var alarmTime = switch (dayOfWeek) {
            case "Monday", "Wednesday" ->"wake up at 7:30 ";
            case "Tuesday", "Friday" ->"wake up at 8:30 ";
            default ->"wake up at 8:30 ";
        };

        System.out.println("******************************** Alarm Time is at " +alarmTime +" ************************");


        //Getting a result from Switch with yield key
        System.out.println(" ************ yield instead -> (Arrowkey)  ********  ");

        var alarmTimeYield = switch (dayOfWeek) {
            case "Monday", "Wednesday": yield "wake up at 7:30 ";
            case "Tuesday", "Friday": yield "wake up at 8:30 ";
            default: yield "wake up at 8:30 ";
        };

        System.out.println("******************************** Yield - Alarm Time is at " +alarmTimeYield +" ************************");
    }
}
