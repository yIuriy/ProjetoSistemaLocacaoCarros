package com.iuri.domain;

public abstract class Vehicle implements Rentable{
    protected String name;
    protected String model;
    protected String plate;
    protected double price;
    protected double rentPricePerDay;

    public Vehicle(String name, String model, String plate, double price) {
        this.name = name;
        this.model = model;
        this.plate = plate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public double getPrice() {
        return price;
    }

    public double getRentPricePerDay() {
        return rentPricePerDay;
    }
}
