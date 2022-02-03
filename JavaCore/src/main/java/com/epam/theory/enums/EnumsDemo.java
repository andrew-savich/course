package com.epam.theory.enums;

 class EnumsDemo {
    public static void main(String[] args) {
        Colors unknownColor = Colors.RED;
        System.out.println("unknownColor is " + unknownColor.name() + ", and his hex is: " + unknownColor.getHex());

        //How to iterate each item in the Enum< and to get name and index of item
        System.out.println("Colors include:");
        for (Colors color : Colors.values()) {
            System.out.println(color.ordinal() + ": " + color.name());
        }
    }
}
