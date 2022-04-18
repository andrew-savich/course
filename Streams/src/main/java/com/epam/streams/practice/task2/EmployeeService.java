package com.epam.streams.practice.task2;

import java.io.*;

public class EmployeeService {
    public void simpleSerializeObjectToFile(Employee employee, String filePathName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePathName))) {
                objectOutputStream.writeObject(employee);
        } catch (FileNotFoundException e) {
            System.out.println("File or path doesn't exist: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Employee deserializeObjectFromFile(String filePathName){
        Employee employee = null;

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePathName))) {
            employee = (Employee) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File or path doesn't exist: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problems with stream: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Can't cast deserialized object to Employee: " + e.getMessage());
        }

        return employee;
    }

}
