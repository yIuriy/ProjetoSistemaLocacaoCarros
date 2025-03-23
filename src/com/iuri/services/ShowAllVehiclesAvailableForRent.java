package com.iuri.services;

import com.iuri.domain.RentalCompany;
import com.iuri.domain.Vehicle;

public class ShowAllVehiclesAvailableForRent {
    public static void showAvailableForRent(RentalCompany company) {
        for (Vehicle vehicle : company.getVehicleList()) {
            if (vehicle.isAvailable()) {
                System.out.println("Nome do veículo: " + vehicle.getName());
                System.out.println("Modelo do veículo: " + vehicle.getModel());
                System.out.println("Placa do veículo: " + vehicle.getPlate());
                System.out.println("Preço do aluguel diário: " + vehicle.getRentPricePerDay());
                System.out.println("=========================================================================");
            }
        }
    }
}

