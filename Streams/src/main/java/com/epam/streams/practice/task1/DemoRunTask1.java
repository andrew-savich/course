package com.epam.streams.practice.task1;

import java.util.ArrayList;
import java.util.List;


//Написать программу которая будет сериализовывать и десериализовывать исходный файл
//(Частная информация не должна храниться в файле, сериализованные и дессериализованные объекты кладуться в list)\
public class DemoRunTask1 {
    public static void main(String[] args) {
        String filePathname = "Streams\\employee.txt";
        EmployeeService employeeService = new EmployeeService();

        Employee employee1 = new Employee(1, "Andrew", 31, "qwerty", "00000");
        Employee employee2 = new Employee(2, "Ivan", 28, "asdfg", "11111");
        Employee employee3 = new Employee(3, "Anna", 25, "zxcvb", "22222");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        List<Employee> restoredEmployees = new ArrayList<>();

        //Task1
        for (Employee employee : employees) {
            employeeService.simpleSerializeObjectToFile(employee, filePathname);

            restoredEmployees.add(employeeService.deserializeObjectFromFile(filePathname));
        }

        System.out.println("Employees after serialization and deserialization:");

        for (Employee employee : restoredEmployees) {
            System.out.println(employee);
        }
        //Conclusion: fields with 'transient' modificator fills 'null' values after deserialization

        //Task2

    }
}
