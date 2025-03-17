package com.iuri.services;

import com.iuri.domain.Car;
import com.iuri.domain.CarType;
import com.iuri.domain.RentalCompany;

public class RegisterCarForRent {
    public void register(String name, String model, String plate, double price, CarType type, RentalCompany company
    ) {
        Car car = new Car(name, model, plate, price, type);
        company.addVehicle(car);
    }
}
