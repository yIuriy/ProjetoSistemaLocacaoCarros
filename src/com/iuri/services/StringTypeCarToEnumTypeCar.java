package com.iuri.services;

import com.iuri.domain.CarType;

public class StringTypeCarToEnumTypeCar {
    public CarType convert(String string){
        return switch (string) {
            case "1" -> CarType.SUV;
            case "2" -> CarType.PICKUP;
            case "3" -> CarType.SEDAN;
            case "4" -> CarType.SPORTY;
            default -> null;
        };
    }
}
