package com.epam.generics.theory.pecs;

import java.util.List;

public class DemoPECS {
    public void producer(List<? extends Class1> list) {
        Class0 obj0 = list.get(0);
        Class1 obj1 = list.get(0);
//        Class2 obj2 = list.get(0); //не скомпилируется так как мы пытаемся сделать: Class2 obj1 = new Class1();
//        Class3 obj3 = list.get(0); //не скомпилируется так как мы пытаемся сделать: Class3 obj1 = new Class1();
//
//        list.add(new Class0());
//        list.add(new Class1());
//        list.add(new Class2());
//        list.add(new Class3()); //не скомпилируется из-за ограничения PECS (Producer extends)
        //потому что в момент компиляции JVM не знает, что будет потом во время выполнения программы по факту
        //вместо List<? extends Class1>. Может это будет List<Class2> или List<Class3>
        //И если будет List<Class2> или List<Class3>, и мы будем пытаться добавлять туда элемент, имеющий тип Class1,
        //это будет равносильно тому, что добавляете элемент с типом Number в List<Integer>
    }

    public void consumer(List<? super Class2> list) {
//        list.add(new Class0());
//        list.add(new Class1());
        list.add(new Class2());
        list.add(new Class3());

        list.get(0); //компилируется, но на выходе мы получаем объект типа Object

//        Class0 obj0 = list.get(0);
//        Class1 obj1 = list.get(0);
//        Class2 obj2 = list.get(0);
//        Class3 obj3 = list.get(0);
        //не компилируется, тк мы пытаемся проинициализировать объект потомка (типа Class3, Class2, Class1, Class0)
        //объектом предка (типа Object)


    }


}
