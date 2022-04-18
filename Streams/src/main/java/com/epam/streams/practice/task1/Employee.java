package com.epam.streams.practice.task1;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private int id;
    private String name;
    private int age;

    private transient String password;
    private transient String bankAccount;

    public Employee(int id, String name, int age, String password, String bankAccount) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Objects.equals(name, employee.name) && Objects.equals(password, employee.password) && Objects.equals(bankAccount, employee.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, password, bankAccount);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }
}
