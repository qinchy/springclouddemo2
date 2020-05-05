package com.qinchy.springclouddemoprovider1.domain.generic3;

import java.util.Objects;

class Meat extends Food {
    private String name;
    private Double price;

    public Meat(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meat meat = (Meat) o;
        return Objects.equals(name, meat.name) &&
                Objects.equals(price, meat.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Meat{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}