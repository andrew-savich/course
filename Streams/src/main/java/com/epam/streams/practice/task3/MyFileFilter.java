package com.epam.streams.practice.task3;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileFilter implements FilenameFilter {
    private String filterStr;

    public MyFileFilter(String filterStr) {
        this.filterStr = filterStr;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.contains(filterStr);
    }
}
