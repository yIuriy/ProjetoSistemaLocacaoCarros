package com.iuri.domain;

public class Motorcycle extends Vehicle{
    private final double RENT_VALUE = price * 0.002;
    public Motorcycle(String name, String model, String plate, double price) {
        super(name, model, plate, price);
        this.rentPricePerDay = calculateRentPricePerDay();
    }

    @Override
    public double calculateRentPricePerDay() {
        return RENT_VALUE;
    }
}
