package org.example;

import org.example.db.EmployeeDataBase;
import org.example.model.Employee;

import java.util.List;

public class Streams {

    public static void main(String[] args) {
        System.out.println("Streams Sample!");
        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        // forEach
        employees.forEach(e-> System.out.println(e.getName()+" : "+e.getSalary()));
    }
}
