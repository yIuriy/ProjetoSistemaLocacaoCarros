package com.iuri.domain;

import com.iuri.services.CheckCpfStandard;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String cpf;
    private String password;
    private List<Vehicle> rentedVehicles = new ArrayList<>();

    public Customer(String name, String cpf, String password) {
        this.name = name;
        this.password = password;
        if (CheckCpfStandard.check(cpf)) {
            this.cpf = cpf;
        } else {
            throw new RuntimeException("Invalid CPF");
        }
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public void addVehicleToRentedList(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
    }

    public void removeVehicleFromRentedList(Vehicle vehicle) {
        rentedVehicles.remove(vehicle);
    }

    public List<Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public String getPassword() {
        return password;
    }
}
