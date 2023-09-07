package com.andrewsavich;

public class TextBlockExample {
    public static void main(String[] args) {
        String oldJsonCase = "{\n" +
                "   \"name\":\"fatih\",\n" +
                "   \"surname\":\"iver\",\n" +
                "   \"birthYear\":1996\n" +
                "}";

        System.out.println(oldJsonCase);

        String java17Json = """
                {
                   "name":"fatih",
                   "surname":"iver",
                   "birthYear":1996
                }
                """;

        System.out.println(java17Json);


    }

}
