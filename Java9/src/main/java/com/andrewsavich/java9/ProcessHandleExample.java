package com.andrewsavich.java9;

public class ProcessHandleExample {
    public static void main(String[] args) {
        ProcessHandle processHandle = ProcessHandle.current();

        System.out.println(processHandle.isAlive());
    }
}
