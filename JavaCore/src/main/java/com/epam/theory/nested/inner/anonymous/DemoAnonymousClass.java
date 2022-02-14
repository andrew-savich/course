package com.epam.theory.nested.inner.anonymous;

public class DemoAnonymousClass {
    private static String message = "to do one-time work like anonymous";

    public static void main(String[] args) {
        Worker firstContractWorker = new ContractWorker();
        Worker secondContractWorker = new ContractWorker();

        //Case without anonymous class
        Worker oneTimeWorker = new OneTimeWorker();

        firstContractWorker.doWork();
        secondContractWorker.doWork();
        oneTimeWorker.doWork();


        //Case with anonymous class
        Worker anonymousOneTimeWorker = new Worker() {
            int someField = 1;

            @Override
            public void doWork() {
                System.out.println(message); //access to outer class field
            }
        };

        //System.out.println(someField); - no access to field from anonymous class

        anonymousOneTimeWorker.doWork();
    }
}
