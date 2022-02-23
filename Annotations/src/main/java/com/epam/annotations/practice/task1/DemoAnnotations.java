package com.epam.annotations.practice.task1;

import java.lang.annotation.Annotation;

public class DemoAnnotations {
    public static void main(String[] args) {
        AnnotationService annotationService = new AnnotationService();
        Class clazz = MyClass.class;

        annotationService.annotationProcessor(clazz.getDeclaredMethods());
    }
}
