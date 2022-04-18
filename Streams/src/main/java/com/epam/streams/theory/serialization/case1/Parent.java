package com.epam.streams.theory.serialization.case1;

import java.io.Serializable;

public class Parent implements Serializable {
    private Integer parentId;
    private Child child;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parentId=" + parentId +
                ", child=" + child +
                '}';
    }
}
