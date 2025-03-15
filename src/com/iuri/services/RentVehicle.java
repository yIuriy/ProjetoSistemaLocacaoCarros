package com.iuri.services;

import com.iuri.domain.Customer;
import com.iuri.domain.RentalCompany;
import com.iuri.domain.Vehicle;

import java.util.Objects;

public class RentVehicle {
    public void rent(Customer customer, RentalCompany company, String carPlate, int rentalDays) {
        for (Vehicle vehicle : company.getVehicleList()) {
            if (Objects.equals(vehicle.getPlate(), carPlate) && vehicle.isAvailable()) {
                vehicle.setAvailable(false);
                customer.addVehicleToRentedList(vehicle);

                return;
            }
        }
        System.out.println("Erro ao alugar um veículo, tente novamente.");
    }
}
