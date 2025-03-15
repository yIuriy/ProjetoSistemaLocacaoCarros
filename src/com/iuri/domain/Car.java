package com.iuri.domain;

import com.iuri.services.CarTypeTax;
import com.iuri.services.StringTypeCarToEnumTypeCar;

public class Car extends Vehicle {
    private final double RENT_VALUE = price * 0.005;
    private final CarType type;

    public Car(String name, String model, String plate, double price, CarType carType) {
        super(name, model, plate, price);
        this.type = carType;
    }

    @Override
    public double calculateRentPrice() {
        double RENT_TAX = 350;
        return RENT_VALUE + RENT_TAX + CarTypeTax.calculateTypeTax(type);
    }
}
