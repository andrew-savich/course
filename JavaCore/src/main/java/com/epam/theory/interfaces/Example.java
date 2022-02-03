package com.epam.theory.interfaces;

//может наследоваться более чем от одного интерфейса, в отличаи от классов
public interface Example extends FirstSome, SecondSome, ThirdSome {
    //неявно является с модификаторами public, static и final
    int SOME_FIELD = 666;

    //статическое поле
    static int staticField = 333;

    //закрытый метод, может использоваться внутри интерфейса в методах по умолчанию
    private void privateMethod() {
        //some code
    }

    //Метод по умолчанию
    default void defaultMethod() {
        //some code
    }

    //Можем получить доступ: Example.staticMethod()
    static void staticMethod() {
        //some code
    }

    //Метод, который мы должнеы реализовать в классе, который будет implements этот метод
    void methodForImplements(String[] someArguments);
}
