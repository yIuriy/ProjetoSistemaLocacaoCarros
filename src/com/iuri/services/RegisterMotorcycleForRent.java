package com.iuri.services;

import com.iuri.domain.Motorcycle;
import com.iuri.domain.RentalCompany;

public class RegisterMotorcycleForRent {
    public static void register(String name, String model, String plate, double price, RentalCompany company
    ) {
        Motorcycle moto = new Motorcycle(name, model, plate, price);
        company.addVehicle(moto);
    }
}
