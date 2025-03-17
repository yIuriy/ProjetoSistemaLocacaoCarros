package com.iuri.domain;

import com.iuri.services.CarTypeTax;

public class Car extends Vehicle {
    private final double rentValue;
    private final CarType type;

    public Car(String name, String model, String plate, double price, CarType carType) {
        super(name, model, plate, price);
        this.rentValue = price * 0.005;
        this.type = carType;
        this.rentPricePerDay = calculateRentPricePerDay();
    }

    @Override
    public double calculateRentPricePerDay() {
        return rentValue + CarTypeTax.calculateTypeTax(type);
    }
}
