package com.epam.classloader.myclassloader;

public interface Module {
    int EXIT_SUCCESS = 0;
    int EXIT_FAILURE = 1;

    void load();
    void run();
    void unload();
}
