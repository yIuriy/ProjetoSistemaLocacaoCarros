package com.iuri.services;

import com.iuri.domain.RentalCompany;
import com.iuri.domain.Vehicle;

public class ShowAllRentedVehicles {
    public static void showRented(RentalCompany company) {
        for (Vehicle vehicle : company.getVehicleList()) {
            if (!vehicle.isAvailable()) {
                System.out.println("Nome do veículo: " + vehicle.getName());
                System.out.println("Placa do veículo: " + vehicle.getPlate());
                System.out.println("=========================================================================");
            }
        }
    }
}

