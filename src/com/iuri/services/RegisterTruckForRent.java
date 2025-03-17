package com.iuri.services;

import com.iuri.domain.RentalCompany;
import com.iuri.domain.Truck;

public class RegisterTruckForRent {
    public static void register(String name, String model, String plate, double price, RentalCompany company
    ) {
        Truck truck = new Truck(name, model, plate, price);
        company.addVehicle(truck);
    }
}
