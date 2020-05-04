package com.qinchy.springclouddemoprovider1.domain.generic2;

public class Plate<T extends Fruit> {
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
}
