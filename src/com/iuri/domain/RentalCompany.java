package com.iuri.domain;

import java.util.ArrayList;
import java.util.List;

public class RentalCompany {
    private String name;
    protected List<Customer> customerList = new ArrayList<>();
    protected List<Vehicle> vehicleList = new ArrayList<>();

    public RentalCompany(String name) {
        this.name = name;
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }
    public void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }
}
