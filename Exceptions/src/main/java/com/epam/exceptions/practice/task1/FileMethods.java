package com.epam.exceptions.practice.task1;

import com.epam.exceptions.practice.task1.exception.MyCheckedException;
import com.epam.exceptions.practice.task1.exception.MyUncheckedException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileMethods {

    private String getFirstLineFromFile(String pathToFile) {
        String firstLine = "";

        try {
            FileReader file = new FileReader(pathToFile);
            BufferedReader reader = new BufferedReader(file);
            firstLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("firstLine: " + firstLine);
        return firstLine;
    }

    public void findSymbolInFileUnchecked(String pathToFile, char symbol) {

        String strLine = getFirstLineFromFile(pathToFile);

        if (strLine.indexOf(symbol) == -1) {
            System.out.println("Symbol '" + symbol + "' doesn't exist in the first line in the file");
        } else {
            throw new MyUncheckedException("Symbol '" + symbol + "' exists in the first line in the file");
        }
    }

    public void findSymbolInFileChecked(String pathToFile, char symbol) throws MyCheckedException {

        String strLine = getFirstLineFromFile(pathToFile);

        if (strLine.indexOf(symbol) == -1) {
            System.out.println("Symbol '" + symbol + "' doesn't exist in the first line in the file");
        } else {
            throw new MyCheckedException("Symbol '" + symbol + "' exists in the first line in the file");
        }
    }
}
