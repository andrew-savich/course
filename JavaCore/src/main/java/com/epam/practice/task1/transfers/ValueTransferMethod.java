package com.epam.practice.task1.transfers;

public class ValueTransferMethod {
    public void increment (ValueTransferObject valueTransferObject, Integer refValue, int primitiveValue){
        ++valueTransferObject.someInteger;
        ++valueTransferObject.someInt;
        ++refValue;
        ++primitiveValue;
    }
}
