package com.epam.streams.practice.task3;

import com.epam.streams.practice.task1.Employee;
import com.epam.streams.practice.task1.EmployeeService;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

//Модифицировать программу таким образом чтобы она смотрела только на _empl.txt файлы (FilenameFilter)
//в каталоге и при нахождении нескольких файлов дессериализовывала их в один list
public class DemoTask3 {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        String dirPath = "Streams\\Task3";

        Employee employee1 = new Employee(1, "Andrew", 31, "qwerty", "00000");
        Employee employee2 = new Employee(2, "Ivan", 28, "asdfg", "11111");
        Employee employee3 = new Employee(3, "Anna", 25, "zxcvb", "22222");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        for (int i = 0; i < employees.size(); i++) {
            employeeService.simpleSerializeObjectToFile(employees.get(i), dirPath + "\\" + i + "empl.txt");
        }

        File dirToFiles = new File(dirPath);
        FilenameFilter myFileFilter1 = new MyFileFilter("empl.txt");

        File[] files = dirToFiles.listFiles(myFileFilter1);

        List<Employee> restoredEmployees = new ArrayList<>();

        for (File file : files) {
            System.out.println(employeeService.deserializeObjectFromFile(file.getAbsolutePath()));
        }

    }
}
