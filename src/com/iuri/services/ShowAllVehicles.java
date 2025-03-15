package com.iuri.services;

import com.iuri.domain.Car;
import com.iuri.domain.RentalCompany;
import com.iuri.domain.Vehicle;

public class ShowAllVehicles {
    public static void show(RentalCompany company) {
        for (Vehicle vehicle : company.getVehicleList()) {
            System.out.print("Nome do veículo: " + vehicle.getName());
            System.out.println("Modelo do veículo: " + vehicle.getModel());
            if (vehicle instanceof Car car) {
                System.out.println("Tipo de carro: " + car.getModel());
            }
            System.out.println("Preço do aluguel diário: " + vehicle.getRentPricePerDay());
            System.out.println("=========================================================================");
        }
    }
}
