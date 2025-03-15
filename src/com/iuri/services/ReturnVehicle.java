package com.iuri.services;

import com.iuri.domain.Customer;
import com.iuri.domain.RentalCompany;
import com.iuri.domain.Vehicle;

public class ReturnVehicle {
    public void returnVehicle(Customer customer, RentalCompany company, String vehicleName) {
        if (customer.getRentedVehicles().isEmpty()) {
            System.out.println("Cliente " + customer.getName() + "não possui nenhum veículo alugado.");
            return;
        }
        for (Vehicle rentedVehicle : customer.getRentedVehicles()) {
            if (rentedVehicle.getName().equals(vehicleName)) {
                rentedVehicle.setAvailable(true);
                customer.removeVehicleFromRentedList(rentedVehicle);
            }
        }
    }
}
