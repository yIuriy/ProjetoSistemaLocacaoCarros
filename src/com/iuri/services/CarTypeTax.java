package com.iuri.services;

import com.iuri.domain.CarType;

public class CarTypeTax {
    public static double calculateTypeTax(CarType carType) {
        return switch (carType) {
            case SUV -> 50;
            case PICKUP -> 75;
            case SEDAN -> 45;
            case SPORTY -> 120;
        };
    }
}
