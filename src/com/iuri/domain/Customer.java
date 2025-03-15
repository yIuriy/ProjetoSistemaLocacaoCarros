package com.iuri.domain;

import com.iuri.services.CheckCpfStandard;
import com.iuri.services.CheckPlateStandard;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String cpf;
    private List<Vehicle> rentedVehicles = new ArrayList<>();

    public Customer(String name, String cpf) {
        this.name = name;
        if (CheckCpfStandard.check(cpf)) {
            this.cpf = cpf;
        } else {
            throw new RuntimeException("Invalid CPF");
        }
    }

    public String getName() {
        return name;
    }

    public void addVehicleToRentedList(Vehicle vehicle){
        rentedVehicles.add(vehicle);
    }

    public void removeVehicleFromRentedList(Vehicle vehicle){
        rentedVehicles.remove(vehicle);
    }

    public List<Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }
}
