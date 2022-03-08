package com.epam.generics.practice;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        //Create an object of parameterized type List<Integer>, add Integer to it and get Integer from it
        List<Integer> ints = new ArrayList<>();
        ints.add(333);
        ints.add(666);
        System.out.println("ints: " + ints.get(0) + "; " + ints.get(1));

        //Create an object of raw type List, add Integer to it and get Integer from it
        List raws = new ArrayList();
        raws.add(333);
        raws.add(666);
        System.out.println("raws: " + raws.get(0) + "; " + raws.get(1));

        //Create an object of generic type ArrayList<T> with actual type parameter Integer without and with the diamond operator
        ArrayList<Integer> arrayList1 = new ArrayList();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        //Use the generic method Collections.emptyList without and with type inference
        List emptyList1 = Collections.emptyList();
        List<Integer> emptyList2 = Collections.emptyList();

        //Implement a generic class (with or without generic constructors and methods) and create an object from it
        GenericClassWithGenericConstructor<Integer> genericClassWithGenericConstructor = new GenericClassWithGenericConstructor<>("666"); //!!!


        //Implement a generic method in the non-generic class and create an object from it
        NonGenericClass nonGenericClass = new NonGenericClass();
        nonGenericClass.genericMethod("XXX");

        //Implement a generic constructor in non-generic class and create an object from it
        NonGenericClassWithGenericConstructor nonGenericClassWithGenericConstructor = new NonGenericClassWithGenericConstructor("xXx");

        //Implement a generic method with bounded type parameter <T extends Number>, with a method parameter
        //of generic type parameter List<T>, that uses the method Number.longValue to find the sum of the
        //list elements to an accumulator of type long;
        //call the method with arguments of parameterized types List<Integer>, List<Long>
        NonGenericClass objNonGenericClass = new NonGenericClass();
        List<Integer> integers = Arrays.asList(1, 3, 4, 5, 6, 7, 8, 9);
        List<Long> longs = Arrays.asList(1L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);

        System.out.println("sum of integers: " + objNonGenericClass.sumOfList(integers));
        System.out.println("sum of longs: " + objNonGenericClass.sumOfList(longs));


        //Assign object of type ArrayList<Integer> to reference of type List<Integer>
        List<Integer> list1 = new ArrayList<Integer>();

        //Assign object of type ArrayList<Integer> to reference of type Collection<Integer>
        Collection<Integer> collection1 = new ArrayList<Integer>();

        //Assign objects of types ArrayList<Integer>, ArrayList<Double>, ArrayList<String> to reference of unbounded wildcard type List<?>
        List<?> list2 = new ArrayList<Integer>();
        List<?> list3 = new ArrayList<Double>();
        List<?> list4 = new ArrayList<String>();

        //Assign objects of types ArrayList<Integer>, ArrayList<Double> to reference of upper bounded wildcard type List<? extends Number> (pay attention to which list turned out)
        List<? extends Number> list5 = new ArrayList<Integer>();
        List<? extends Number> list6 = new ArrayList<Double>();

        //Assign objects of types ArrayList<Integer>, ArrayList<Number>, ArrayList<Object> to reference of lower bounded wildcard type List<? super Integer> (pay attention to which list turned out)
        List<? super Integer> list7 = new ArrayList<Integer>();
        List<? super Integer> list8 = new ArrayList<Number>();
        List<? super Integer> list9 = new ArrayList<Object>();

        //Implement a generic method with a method parameter of parameterized type List<Object>,
        //that uses the method System.out.println to print list elements;
        //call the method with an argument of parameterized type List<Object>
        List<Object> objects = Arrays.asList(new Object(), new Object(), new Object());
        objNonGenericClass.printObjectElements(objects);

        //Implement a generic method with a method parameter of unbounded wildcard type List<?>,
        //that uses the method System.out.println to print list elements;
        //call the method with arguments of parameterized types List<Object>, List<Integer>, List<Double>
        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

        objNonGenericClass.printUnknownElements(objects);
        objNonGenericClass.printUnknownElements(integers);
        objNonGenericClass.printUnknownElements(doubles);

        //Implement a generic method with a method parameter of upper bounded wildcard type List<? extends Number>,
        //that uses the method Number.longValue to find the sum of the list elements to an accumulator of type long;
        //call the method with arguments of parameterized types List<Integer>, List<Long> (PEcs: producer - extends)
        System.out.println("ints: " + nonGenericClass.accumLongs(integers));
        System.out.println("longs: " + nonGenericClass.accumLongs(longs));

        //Implement a generic method with a method parameter of lower bounded wildcard type List<? super Integer>
        //that uses the method List.add to insert int elements to list;
        //call the method with arguments of parameterized types List<Integer>, List<Number>, List<Object> (peCS: consumer - super)
        List<Integer> integers2 = new ArrayList<>();
        List<Number> numbers2 = new ArrayList<>();
        List<Objects> objects2 = new ArrayList<>();

        objNonGenericClass.insertFixedValuesToList(integers2);
        objNonGenericClass.insertFixedValuesToList(numbers2);
        //objNonGenericClass.insertFixedValuesToList(objects2); - cannot be converted to java.util.List<? super java.lang.Integer>

        System.out.println(integers2);
        System.out.println(numbers2);

    }

    //Show that impossible to use the instanceof operator with parameterized types
    public <T> void impossibleinstanceof(T someObject) {
//        if(someObject instanceof T){ - java: illegal generic type for instanceof
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
    }


    //Show that impossible to overload a method where the formal parameter types of each overload erase to the same raw type
    // public void display(List<String> list) {} -have the same erasure
    public void display(List<Integer> list) {}

}
