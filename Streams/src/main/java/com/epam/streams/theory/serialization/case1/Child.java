package com.epam.streams.theory.serialization.case1;

public class Child extends Parent {
    private Integer childId;

    public Child(Integer childId) {
        this.childId = childId;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    @Override
    public String toString() {
        return "Child{" +
                "childId=" + childId +
                '}';
    }
}
