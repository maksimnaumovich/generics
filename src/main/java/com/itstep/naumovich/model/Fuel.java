package com.itstep.naumovich.model;

import java.io.Serializable;

/**
 * Created by admin on 05.02.2019.
 */
public class Fuel implements Serializable {

    private Integer octaneNumber;
    private Integer quantity;

    public Fuel() {
    }

    public Fuel(Integer octaneNumber, Integer quantity) {
        this.octaneNumber = octaneNumber;
        this.quantity = quantity;
    }

    public Integer getOctaneNumber() {
        return octaneNumber;
    }

    public void setOctaneNumber(Integer octaneNumber) {
        this.octaneNumber = octaneNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fuel fuel = (Fuel) o;

        if (octaneNumber != null ? !octaneNumber.equals(fuel.octaneNumber) : fuel.octaneNumber != null) return false;
        return quantity != null ? quantity.equals(fuel.quantity) : fuel.quantity == null;
    }

    @Override
    public int hashCode() {
        int result = octaneNumber != null ? octaneNumber.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
