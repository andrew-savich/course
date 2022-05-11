package com.epam.streams.theory.serialization.case2;

import java.io.Serializable;

public class Parent{
    private Integer parentId;

    static int staticField = 1;

    public Parent() {
        staticField = 2;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public static int getStaticField() {
        return staticField;
    }

    public static void setStaticField(int staticField) {
        Parent.staticField = staticField;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parentId=" + parentId +
                '}';
    }
}
