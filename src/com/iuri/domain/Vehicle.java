package com.iuri.domain;

public abstract class Vehicle {
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
}
