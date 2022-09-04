package com.epam.classloader.customclassloaderv2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException, IOException {
        //Получаем доступ ко всем Properties
        Properties p = System.getProperties();
        //Получаем разделитель, используемый в операционной системе
        String sep = p.getProperty("file.separator");
        //Получаем путь к папке JRE
        String jrePath = p.getProperty("java.home");
        //String jrePath = "C:/Program Files/Java/jdk1.8.0_261/";
        //Выполняем необходимые манипуляции для получения пути к файла javac (в моем случае javac.exe)
        int lastIndex = jrePath.lastIndexOf(sep);
        String javac = jrePath.substring(0, lastIndex) + sep + "bin" + sep + "javac";
        //if (p.getProperty("sun.desktop").equals("windows"))
        javac += ".exe";
        //else javac += ".sh";
        //Проверяем, существует ли такой файл (javac.exe)
        File file = new File(javac);
        if (!file.isFile())
            throw new FileNotFoundException("Компилятор по адресу " + file.getAbsolutePath() + " недоступен ");
        System.out.println("Компилируем " + file.getAbsolutePath() + " " + file.getAbsolutePath());
        //Запускаем компилятор javac, чтобы получить байт код внешнего класса
        Process p1 = Runtime.getRuntime().exec(javac + " " + file.getAbsolutePath());
        //Если javac завершился с ошибкой, выбрасываем Exception (здесь он самописный)
        //т.к. мне необходимо было проверять синтаксис класса, который подключался.
        //Таким образом, если возникала ошибка компиляции, то процесс p1 мог вернуть текст
        //ошибки (поток байт) с помощью функции getErrorStream()
//        if (p1.waitFor() != 0)
//            try {
//                throw new MyClassCompilationException("Ошибка компиляции", p1);
//            } catch (MyClassCompilationException e) {
//                e.printStackTrace();
//                return;
//            }
        //Здесь мы уже имеем созданный файл с байт-кодом
        System.out.println("Компиляция завершена");
        //Формируем абсолютный путь к файлу с байт-кодом
        int pointIndex = file.getAbsolutePath().lastIndexOf(".");
        String absulutePatch = file.getAbsolutePath().substring(0, pointIndex);
        //Объявляем MyClassLoader. Класс ClassLoader является абстрактным
        //поэтому необходимо его переопределить (каким образом, будет показано ниже)
        MyClassLoader loader = new MyClassLoader();
        //Объявляем переменную типа Class.
        Class cl = loader.findClass(absulutePatch);
        System.out.println(cl);
        //Получаем метод m1 из загруженного класса
        Method method = cl.getMethod("m1", new Class[]{String.class, int.class});
        System.out.println(method);
        //Выполняем метод m1. Нельзя забывать про метод newInstance(), если метод динамический.
        method.invoke(cl.newInstance(), new Object[]{"Test", 8});
        //Выполняем метод m2. Он статический, поэтому newInstance() в методе invoke писать не надо
        Method method2 = cl.getMethod("m2", new Class[]{String.class});
        method2.invoke(cl, "QWERRTY");
    }
}
