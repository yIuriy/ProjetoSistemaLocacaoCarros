package com.iuri.services;

import com.iuri.domain.Customer;
import com.iuri.domain.RentalCompany;
import com.iuri.domain.Vehicle;

public class ReturnVehicle {
    public static void returnVehicle(Customer customer, RentalCompany company, String plate) {
        if (customer.getRentedVehicles().isEmpty()) {
            System.out.println("Cliente " + customer.getName() + "não possui nenhum veículo alugado.");
            return;
        }
        for (Vehicle rentedVehicle : customer.getRentedVehicles()) {
            if (rentedVehicle.getPlate().equals(plate)) {
                rentedVehicle.setAvailable(true);
                customer.removeVehicleFromRentedList(rentedVehicle);
            }
        }
    }
}
