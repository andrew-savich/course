package com.epam.annotations.practice.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class AnnotationService {

    void annotationProcessor(Method[] methods) {

        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(Greeting.class);

            if (Objects.nonNull(annotation)) {
                Object instance = null;
                try {
                    instance = method.getDeclaringClass().getDeclaredConstructor().newInstance();
                    method.invoke(instance);
                } catch (InstantiationException e) {
                    System.out.println("Problem with getting instance:" + e);
                } catch (IllegalAccessException e) {
                    System.out.println("Problem with getting access to method:" + e);
                } catch (InvocationTargetException e) {
                    System.out.println("Problem with invocation method:" + e);
                } catch (NoSuchMethodException e) {
                    System.out.println("Problem: method not found: " + e);
                }

            }
        }
    }
}