package com.epam.classloader.myclassloader;

import java.io.File;

public class ModuleEngine {
    public static void main(String[] args) {
        String modulePath = "C:\\projects\\course\\ClassLoader\\target\\classes\\com\\epam\\classloader\\myclassloader";
        ModuleLoader loader = new ModuleLoader(ClassLoader.getSystemClassLoader(), modulePath);

        File dir = new File(modulePath);
        String[] modules = dir.list();

        for (String module: modules) {
            String moduleName = module.split(".class")[0];
            try {
                Class clazz = loader.loadClass(moduleName);
                Module execute = (Module) clazz.newInstance();

                execute.load();
                execute.run();
                execute.unload();

            } catch (ClassNotFoundException e) {
                System.out.println(moduleName + " not found");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
