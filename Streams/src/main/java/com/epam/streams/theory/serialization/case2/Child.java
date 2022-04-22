package com.epam.streams.theory.serialization.case2;

import java.io.Serializable;

public class Child extends Parent implements Serializable {
    private int childId;
    private Parent parentField;

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public Parent getParentField() {
        return parentField;
    }

    public void setParentField(Parent parentField) {
        this.parentField = parentField;
    }

    @Override
    public String toString() {
        return "Child{" +
                "childId=" + childId +
                ", parentField=" + parentField +
                '}';
    }
}
