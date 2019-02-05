package com.itstep.naumovich.model;

import java.io.Serializable;

/**
 * Created by admin on 05.02.2019.
 */
public class Apple implements Serializable {

    private String color;
    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple() {
    }

    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apple apple = (Apple) o;

        if (color != null ? !color.equals(apple.color) : apple.color != null) return false;
        return weight != null ? weight.equals(apple.weight) : apple.weight == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }
}
