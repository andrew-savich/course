package com.epam.theory.nested.inner.inner;

public class Lock {
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
