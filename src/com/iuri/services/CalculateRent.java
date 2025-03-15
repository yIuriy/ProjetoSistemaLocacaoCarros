package com.iuri.services;

import com.iuri.domain.Car;
import com.iuri.domain.Motorcycle;
import com.iuri.domain.Truck;
import com.iuri.domain.Vehicle;

public class CalculateRent {
    public static double calculate(Vehicle vehicle, int days) {
        double priceAtEnd = vehicle.getRentPricePerDay() * days;
        double rentTax;
        switch (vehicle) {
            case Car car -> {
                rentTax = 350;
            }
            case Motorcycle motorcycle -> {
                rentTax = 50;
            }
            case Truck truck -> {
                rentTax = 1200;
            }
            default -> {
                rentTax = 0;
            }
        }
        return vehicle.getRentPricePerDay() + rentTax;
    }
}
