package com.epam.collections3.practice;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        //Create HashMap by different constructors
        HashMap<Integer, String> hashMap1 = new HashMap<>(); //simple empty
        HashMap<Integer, String> hashMap2 = new HashMap<>(32, 0.5f); //with initialCapacity and loadFactory
        HashMap<Integer, String> hashMap3 = new HashMap<>(64); //only with initialCapacity


        //Try to add null to HashMap as key and value
        hashMap1.put(null, null);
        hashMap1.put(null, "some value");

        System.out.println(hashMap1); //output {null=some value} - override value by key 'null'


        //Create LinkedHashMap by different constructors
        LinkedHashMap<Integer, String> linkedHashMap1 = new LinkedHashMap<>(); //simple
        LinkedHashMap<Integer, String> linkedHashMap2 = new LinkedHashMap<>(32, 0.5f); ////with initialCapacity and loadFactory
        LinkedHashMap<Integer, String> linkedHashMap3 = new LinkedHashMap<>(64); //only with initialCapacity
        LinkedHashMap<Integer, String> linkedHashMap4 = new LinkedHashMap<>(hashMap1); //from another HashMap


        //Create TreeMap by different constructors
        TreeMap<Integer, String> treeMap1 = new TreeMap<>(); //simple

        class Person {
            int age;
        }

        TreeMap<Person, Integer> personNumberMap = new TreeMap<>(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        }); //with anonymous comparator


        //Use Collections methods: emptyMap, singletonMap, unmodifiableMap
        Map<Integer, String> emptyMap = Collections.emptyMap(); // - empty unmodified map
        //emptyMap.put(1, "one"); - UnsupportedOperationException
        System.out.println("emptyMap: " + emptyMap);

        Map<Integer, String> singletonMap = Collections.singletonMap(1, "one");
        //singletonMap.put(2, "two"); - UnsupportedOperationException
        System.out.println("singletonMap: " + singletonMap);

        Map<Integer, String> unmodifiableMap = Collections.unmodifiableMap(hashMap1);
        //unmodifiableMap.put(2, "two"); UnsupportedOperationException
        System.out.println("unmodifiableMap: " + unmodifiableMap);


        //Use Map methods on HashMap object
        System.out.println("isEmpty(): " + hashMap1.isEmpty());
        System.out.println("size(): : " + hashMap1.size());
        hashMap1.put(2, "two");
        System.out.println("containsKey(): " + hashMap1.containsKey(2));
        System.out.println("containsValue(): " + hashMap1.containsValue("two"));
        System.out.println("get(): " + hashMap1.get(null));
        hashMap1.remove(null);


        //Use non-inherited Queue methods on LinkedList object
        Queue<String> queue1 = new LinkedList<>();
        queue1.offer("first str");
        queue1.offer("second str");
        queue1.offer("third str");

        System.out.println("removing element from queue1: " + queue1.poll()); //first str
        System.out.println("removing element from queue1: " + queue1.poll()); //second str
        System.out.println("removing element from queue1: " + queue1.poll()); //third str
        System.out.println("removing element from queue1: " + queue1.poll()); //null, because queue is empty

        //queue1.element(); - Throws NoSuchElementException
        System.out.println("peek(): " + queue1.peek()); // null


        //Use non-inherited Deque methods on ArrayDeque object
        Deque<String> deque1 = new ArrayDeque<>();
        deque1.addFirst("Add First str");
        deque1.addLast("Add Last str");

        deque1.offerFirst("Offer First");
        deque1.offerLast("Offer Last");

        System.out.println("After add and offer: " + deque1);

        deque1.removeFirst();
        deque1.removeLast();
        deque1.pollFirst();
        deque1.pollLast();


        //Положить в мапу по 1 ключу 2 одинаковых объекта, но с разным полем, посмотреть что будет содержаться по ключу
        class Car {
            int speed;

            @Override
            public int hashCode() {
                return 1;
            }

            @Override
            public String toString() {
                return "Car{" +
                        "speed=" + speed +
                        '}';
            }
        }

        Map<String, Car> carsMap = new HashMap<>();
        Car commonCar = new Car();
        Car sameCar1 = commonCar;
        Car sameCar2 = commonCar;

        sameCar1.speed = 120;
        sameCar2.speed = 220;

        carsMap.put("same car", sameCar1);
        carsMap.put("same car", sameCar2);

        System.out.println("Cars in carsMap:");
        for (Map.Entry<String, Car> entry : carsMap.entrySet()) {
            System.out.println(carsMap.get(entry.getKey()));
        }

        //Попробовать изменить ключ уже положенного элемента (после этого попытаться найти значение) (можно ли его достать?)
        class Key {
            private String name;

            public Key(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Key key = (Key) o;
                return Objects.equals(name, key.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name);
            }
        }

        Map<Key, String> map1 = new HashMap<>();
        Key myKey = new Key("my key");

        map1.put(myKey, "Some string value");

        System.out.println("getting value from mpa by myKey: " + map1.get(myKey)); //Some string value

        myKey.setName(myKey.getName() + " edited");

        System.out.println("getting value from mpa by edited myKey: " + map1.get(myKey)); // null


    }
}

