package com.epam.exceptions.practice.task1;

import com.epam.exceptions.practice.task1.exception.MyCheckedException;

//    - Create a text file, fill the first line with any sentence.
//    - Write your own exception in unchecked format
//    - Write a test class that will contain two methods.
//    - One method will read the first line from the file (the implementation should be as optimal as possible in terms of catching errors).
//    - The second method will parse the received string and, if the supplied character is found, it will throw the exception written in the second step
//    - Run the program without catching an exception, see what error is generated, draw conclusions
//    - Change your own error from unchecked format to checked and see how the IDE (compiler) reacted to this change (draw a conclusion)
//    - Catching an exception using catch blocks so that no matter if an error is caught, any message is displayed on the screen.

public class DemoTask1 {
    public static void main(String[] args) {
        String pathToFile = "c:\\someFile.txt";
        char existingSymbol = 'a';

        FileMethods fileMethods = new FileMethods();

        //Case with unchecked exception:
        //We can write programm-code, which can call unchecked exception, without try-catch block
        //But when we got this exception, application was interrupted
        fileMethods.findSymbolInFileUnchecked(pathToFile, existingSymbol);


        //Case with checked exception:
        //When method can generate unchecked exception, and doesn't handle this exception (has throw signature)
        //Compiler tells us that we have to handle this exception with try-catch block or add 'throw' signature
        try {
            fileMethods.findSymbolInFileChecked(pathToFile, existingSymbol);
        } catch (MyCheckedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Catching an exception using catch blocks so that no matter if an error is caught, any message is displayed on the screen.");
        }

    }
}
