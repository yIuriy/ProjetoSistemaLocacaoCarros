package com.iuri.services;

import com.iuri.domain.Customer;
import com.iuri.domain.Vehicle;

public class ShowCustomerRentedVehicles {
    public static void show(Customer customer) {
        for (Vehicle rentedVehicle : customer.getRentedVehicles()) {
            System.out.println("Nome do veículo: " + rentedVehicle.getName());
            System.out.println("Placa do veículo " + rentedVehicle.getPlate());
        }

    }
}
