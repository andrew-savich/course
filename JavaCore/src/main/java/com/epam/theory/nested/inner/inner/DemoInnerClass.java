package com.epam.theory.nested.inner.inner;

import com.epam.theory.nested.staticnested.Developer;

public class DemoInnerClass {
    public static void main(String[] args) {
        Lock firstLock = new Lock();

        Lock.Key firstKey = firstLock.new Key(1);
        Lock.Key secondKey = firstLock.new Key(2);

        firstKey.open();
        firstKey.open();
        firstKey.close();
        firstKey.close();

        secondKey.open();
        secondKey.open();
        secondKey.close();
        secondKey.close();
    }
}
