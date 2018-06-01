package com.devtest.util.collections.impl;

public class Element {
    private Object priority;
    private Object data;
    private int pos;

    public Element(Object priority, Object data, int pos) {
        this.priority = priority;
        this.data = data;
        this.pos = pos;
    }

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
