package com.iuri.services;

import com.iuri.domain.Customer;
import com.iuri.domain.RentalCompany;
import com.iuri.domain.Vehicle;

public class ShowAllCustomers {
    public void showCustomers(RentalCompany company){
        for (Customer customer : company.getCustomerList()) {
            System.out.println("Nome do cliente: " + customer.getName());
            if(!customer.getRentedVehicles().isEmpty()){
                System.out.println("Carros alugados: ");
                for (Vehicle rentedVehicle : customer.getRentedVehicles()) {
                    System.out.print(rentedVehicle.getName() + " ");
                }
                System.out.println();
            }
            System.out.println("=========================================================================");
        }

    }
}
