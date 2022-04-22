package com.epam.streams.practice.task2;

import java.util.ArrayList;
import java.util.List;


//Модифицировать программу таким образом, чтобы при дессериализации частная информация
//заполнялась дефолтными значениями (изменив правила дессериализации)
public class DemoRunTask2 {
    public static void main(String[] args) {
        String filePathname = "Streams/employee.txt";
        EmployeeService employeeService = new EmployeeService();

        Employee employee1 = new Employee(1, "Andrew", 31, "qwerty", "00000");
        Employee employee2 = new Employee(2, "Ivan", 28, "asdfg", "11111");
        Employee employee3 = new Employee(3, "Anna", 25, "zxcvb", "22222");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        List<Employee> restoredEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            employeeService.simpleSerializeObjectToFile(employee, filePathname);

            restoredEmployees.add(employeeService.deserializeObjectFromFile(filePathname));
        }

        System.out.println("Employees after serialization and deserialization:");

        for (Employee employee : restoredEmployees) {
            System.out.println(employee);
        }
        //Conclusion:

    }
}
