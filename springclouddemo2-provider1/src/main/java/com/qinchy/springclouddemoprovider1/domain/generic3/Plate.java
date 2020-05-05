package com.qinchy.springclouddemoprovider1.domain.generic3;

public class Plate<T> {
    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "item=" + item +
                '}';
    }
}
