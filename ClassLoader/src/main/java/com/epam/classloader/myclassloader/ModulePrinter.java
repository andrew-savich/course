package com.epam.classloader.myclassloader;

public class ModulePrinter implements Module {
    @Override
    public void load() {
        System.out.println("Module " + this.getClass() + " loading ...");
    }

    @Override
    public void run() {
        System.out.println("Module " + this.getClass() + " running ...");
    }

    @Override
    public void unload() {
        System.out.println("Module " + this.getClass() + " inloading ...");
    }
}
