package org.example.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class PartitioningByGroupBy {

    record Car(String type, String make, String model, Integer egineCapacity) {
    }

    public static void main(String[] args) {
        System.out.println("----All Streams Operarions----");
        List<Car> carsList = List.of(
                new Car("seden", "BMW", "530", 1998),
                new Car("suv", "Audi", "Q7", 2200),
                new Car("seden", "Mercedes", "E-Class", 2500),
                new Car("seden", "skoda", "Octavia", 1450),
                new Car("suv", "Toyoto", "Innova", 2500)
        );
// All Cars

        System.out.println("----All Cars----");
        carsList.stream().forEach(System.out::println);

        // Only SUV - make
        System.out.println("----Only SUV----");
        carsList.stream().filter(car -> car.type.equalsIgnoreCase("suv"))
                .map(car -> car.make).forEach(System.out::println);

        // Only SUV - make  and Model as  BMW - 530
        System.out.println("----Only SUV----");
        List<String> makeModel = carsList.stream().filter(car -> car.type.equalsIgnoreCase("seden"))
                .map(car -> car.make + " - " + car.model).toList();

        makeModel.stream().forEach(System.out::println);


        // Integer Stream
        Stream<Integer> integerStream = Stream.of(11, 12, 4, 6, 57, 99, 10, 20);
        Stream<Integer> filteredIntegerStream = integerStream.filter(
                intValue -> {
                    System.out.println("Filtering Integer " + intValue);
                    return intValue % 2 == 0;
                }
        );
        System.out.println(" Count = " + filteredIntegerStream.count());
        System.out.println(" MAP - PartitioningBy Car Type ");
        System.out.println("************** PartitioningBy ****************");

        Map<Boolean, List<Car>> partionedCars = carsList.stream()
                .collect(
                        partitioningBy(car -> car.type.equalsIgnoreCase("suv"))
                );
        System.out.println(partionedCars);


        // Map - (Type , Map(make,engineCapacity))

        System.out.println("Map - (Type , Map(make,engineCapacity))");
        System.out.println("************** groupingBy ****************");

        Map<String,Map<String,Integer>>  groupedCars = carsList.stream()
                .collect(
                        groupingBy(
                                Car::type,
                                toMap(Car::make,Car::egineCapacity)
                        )
                );

        System.out.println(groupedCars);

    }
}
