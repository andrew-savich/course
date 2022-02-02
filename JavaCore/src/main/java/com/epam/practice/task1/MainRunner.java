package com.epam.practice.task1;

import com.epam.practice.task1.transfers.ValueTransferMethod;
import com.epam.practice.task1.transfers.ValueTransferObject;

public class MainRunner {
    public static void main(String[] args) {
        ValueTransferMethod valueTransferMethod = new ValueTransferMethod();
        ValueTransferObject valueTransferObject = new ValueTransferObject();

        Integer someLocalInteger = 0;
        int someLocalInt = 0;

        valueTransferMethod.increment(valueTransferObject, someLocalInteger, someLocalInt);

        System.out.println("valueTransferObject.someInteger: " + valueTransferObject.someInteger +
                "\nvalueTransferObject.someInt: " + valueTransferObject.someInt +
                "\nsomeLocalInteger: " + someLocalInteger +
                "\nsomeLocalInt: " + someLocalInt);

//        Output:
//        valueTransferObject.someInteger: 1
//        valueTransferObject.someInt: 1
//        someLocalInteger: 0
//        someLocalInt: 0
    }
}
