package com.iuri.services;

import com.iuri.domain.Customer;
import com.iuri.domain.RentalCompany;

public class RegisterCustomer {
    public static void register(String name, String cpf, String password, RentalCompany company) {
        Customer customer = new Customer(name, cpf, password);
        company.addCustomer(customer);
    }
}
