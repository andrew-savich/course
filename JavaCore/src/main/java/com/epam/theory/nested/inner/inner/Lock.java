package com.epam.theory.nested.inner.inner;

/*
 Inner class has access to fields from outer class (private, static)
 Outer class hasn't access to fields from inner class without instance of inner class
 */
public class Lock {
    private int outerField1;
    //private int outerField2 innerField2; - doesn't work
    private int outerField2 = new Key(4).innerField2;
    private static int outerField3;

    private boolean opened;

    private void open(int keyNumber) {
        opened = true;
        System.out.println("The lock already has been opened by key# " + keyNumber);
    }

    private void close(int keyNumber) {
        opened = false;
        System.out.println("The lock already has been closed by key# " + keyNumber);
    }

    public class Key {
        private int innerField1 = outerField1;
        public int innerField2;
        //static int innerField3; - doesn't support inner static fields
        public int innerField4 = outerField3;


        private int numberKey;

        public Key(int numberKey) {
            this.numberKey = numberKey;
        }

        public void open() {
            if (!opened) {
                Lock.this.open(numberKey);
            } else {
                System.out.println("The lock is opened");
            }
        }

        public void close() {
            if (opened) {
                Lock.this.close(numberKey);
            } else {
                System.out.println("The lock is closed");
            }
        }

        public int getNumberKey() {
            return numberKey;
        }

        public void setNumberKey(int numberKey) {
            this.numberKey = numberKey;
        }
    }
}
