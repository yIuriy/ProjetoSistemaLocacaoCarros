package com.iuri.domain;

public class Truck extends Vehicle{
    private final double RENT_VALUE = price * 0.008;

    public Truck(String name, String model, String plate, double price) {
        super(name, model, plate, price);
    }

    @Override
    public double calculateRentPrice() {
        double rentTax = 1200;
        return RENT_VALUE + rentTax;
    }
}
