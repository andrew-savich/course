package com.epam.collections2.practice;

import org.apache.logging.log4j.core.util.JsonUtils;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        //Try to add null into ArrayList
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add(null);
        arrayList1.add(null);

        System.out.println(arrayList1); //output: [null, null]


        //Show that LinkedList implements List, Queue, Deque
        List<String> list2 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Deque<String> deque = new LinkedList<>();


        //Используйте методы коллекций: emptyList, singletonList, немодифицируемый список
        List emptyList = Collections.emptyList();
        System.out.println("emptyList: " + emptyList);

        List<String> singletonList = Collections.singletonList(new String("some string"));
        //singletonList.add("Some str"); - UnsupportedOperationException extends RuntimeException {

        List<String> unmodifiableList = Collections.unmodifiableList(arrayList1);
        //unmodifiableList.add("Some str"); - UnsupportedOperationException
        //unmodifiableList.set(0, "New str"); - UnsupportedOperationException
        System.out.println(unmodifiableList);


        //Use non-inherited List methods on ArrayList object
        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("first");
        arrayList4.add("second");
        arrayList4.add("third");
        arrayList4.add("fourth");

        arrayList4.set(2, "the third");
        System.out.println("indexOf: " + arrayList4.indexOf("the third"));

        arrayList4.replaceAll(x -> x.equals("the third") ? "third" : x);
        List<String> oneTwo = arrayList4.subList(0, 2);
        System.out.println("arrayList4.subList(0, 2): " + oneTwo);
        System.out.println(arrayList4);


        //Try to add null to HashSet
        Set<String> stringSet = new HashSet<>();
        stringSet.add(null);
        stringSet.add(null);

        System.out.println(stringSet); //output - [null]


        //Show that LinkedHashSet iterates elements in insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("third");
        linkedHashSet.add("first");
        linkedHashSet.add("fourth");
        linkedHashSet.add("second");

        System.out.println("Order linkedhasgset:");
        for (String item : linkedHashSet) {
            System.out.println(item);
        }

        //Create TreeSet by different constructors
        //simple:
        Set<String> someTreeSet1 = new TreeSet<>();

        //with Comparator:
        class Person {
            private int age;

            public Person(int age) {
                this.age = age;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{" + "age=" + age + '}';
            }
        }

        Set<Person> someTreeSet2 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge(); //case to discussion
            }
        });

        //from other collection
        Set<String> someTreeSet3 = new TreeSet<>(arrayList4); //will be sorted by natural string sort
        System.out.println("someTreeSet3: " + someTreeSet3);


        //Try to add an object that not implements Comparable into TreeSet
        TreeSet<Person> personTreeSet = new TreeSet<>();
        //personTreeSet.add(new Person(21)); - we can not add objects without implementation Comparable


        //Show that TreeSet iterates elements in sorted order
        someTreeSet2.add(new Person(29));
        someTreeSet2.add(new Person(18));
        someTreeSet2.add(new Person(22));
        someTreeSet2.add(new Person(16));

        System.out.println("Iterate sorted TreeSet:");
        for (Person person : someTreeSet2) {
            System.out.println(person);
        }


        //Implement a class, override equals, hashCode methods, use it with HashSet (Важно, переопределить неправильно, например hash всегда возвращает 1)
        class Employee {
            private String name;
            private int age;

            public Employee(String name, int age) {
                this.name = name;
                this.age = age;
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

            @Override
            public String toString() {
                return "Employee{" + "name='" + name + '\'' + ", age=" + age + '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Employee employee = (Employee) o;
                return age == employee.age && Objects.equals(name, employee.name);
            }

            @Override
            public int hashCode() {
                return 1;
            }
        }

        HashSet<Employee> employees = new HashSet<>();
        Employee ivan = new Employee("Ivan", 19);
        Employee petr = new Employee("Petr", 22);
        Employee vasya = new Employee("Vasya", 18);

        employees.add(ivan);
        employees.add(ivan);
        employees.add(petr);

        System.out.println("employees: " + employees.contains(vasya));


        //Implement a class, override equals, hashCode, compareTo methods, use it with TreeSet (Важно, переопределить неправильно, например hash всегда возвращает 1)
        class Car implements Comparable<Car> {
            private String name;
            private int price;

            public Car(String name, int price) {
                this.name = name;
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            @Override
            public String toString() {
                return "Car{" + "name='" + name + '\'' + ", price=" + price + '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Car car = (Car) o;
                return price == car.price && Objects.equals(name, car.name);
            }

            @Override
            public int hashCode() {
                return 666;
            }

            @Override
            public int compareTo(Car o) {
                return this.getPrice() - o.getPrice();
            }
        }

        TreeSet<Car> cars = new TreeSet<>();
        Car audi = new Car("Audi", 26_000);
        Car honda = new Car("Honda", 15_500);
        Car tesla = new Car("Tesla", 100_000);

        cars.add(audi);
        cars.add(audi);
        cars.add(honda);
        cars.add(tesla);

        System.out.println(cars);


        //Use Collections methods: emptySet, singleton, unmodifiableSet
        Set<String> someEmptySet = Collections.emptySet();
        System.out.println("someEmptySet: " + someEmptySet);

        Set<String> someStringSet = Collections.singleton("SomeString");
        //someStringSet.add("Second string"); - UnsupportedOperationException

        Set<Employee> unmodifSet = Collections.unmodifiableSet(employees);
        //unmodifSet.add(new Employee("Fedor", 27));  - UnsupportedOperationException
        for(Employee employee : unmodifSet) {
            employee.setName(employee.getName() + " edited");
        }
        System.out.println("unmodifSet: " + unmodifSet);

    }

}
