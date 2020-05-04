package com.qinchy.springclouddemoprovider1.domain.generic2;

import java.util.Objects;

public class Fruit {
    private String color;
    private Float weight;

    public Fruit(String color, Float weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(color, fruit.color) &&
                Objects.equals(weight, fruit.weight);
    }

    @Override
    public int hashCode() {

        return Objects.hash(color, weight);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
