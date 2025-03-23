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

    public Customer getCustomerByCpf(String cpf) {
        for (Customer customer : customerList) {
            if (customer.getCpf().equals(cpf)) {
                return customer;
            }
        }
        throw new RuntimeException("Cpf not found.");
    }

    public Vehicle getCarByPlate(String plate) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getPlate().equals(plate)) {
                return vehicle;
            }
        }
        throw new RuntimeException("Vehicle not found.");
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public String getName() {
        return name;
    }
}
