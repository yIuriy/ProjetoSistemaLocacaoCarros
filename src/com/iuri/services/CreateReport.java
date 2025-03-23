package com.iuri.services;

import com.iuri.domain.Customer;
import com.iuri.domain.RentalCompany;
import com.iuri.domain.Vehicle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreateReport {
    public static void create(RentalCompany company) {
        File file = new File("D:\\ProjetoSistemaLocacaoCarros\\reports\\report.txt");
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            LocalDateTime dateNow = LocalDateTime.now();
            bufferedWriter.write("Relatório " + company.getName() + "[" + dateNow + "]");
            bufferedWriter.newLine();
            bufferedWriter.write("Carros alugados:");
            bufferedWriter.newLine();
            for (Vehicle vehicle : company.getVehicleList()) {
                if (!vehicle.isAvailable()) {
                    bufferedWriter.write("Nome do veículo: " + vehicle.getName() + "| Placa do veículo: " + vehicle.getPlate());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.write("Carros disponíveis para aluguel:");
            bufferedWriter.newLine();
            for (Vehicle vehicle : company.getVehicleList()) {
                if (vehicle.isAvailable()) {
                    bufferedWriter.write("Nome do veículo: " + vehicle.getName() + "| Placa do veículo: " + vehicle.getPlate());
                    bufferedWriter.newLine();
                }
            }
            if (!company.getCustomerList().isEmpty()) {
                bufferedWriter.write("Clientes cadastrados: ");
                bufferedWriter.newLine();
                for (Customer customer : company.getCustomerList()) {
                    bufferedWriter.write("Nome do cliente: ");
                    bufferedWriter.write(customer.getName());
                    bufferedWriter.newLine();
                    if (!customer.getRentedVehicles().isEmpty()) {
                        {
                            bufferedWriter.write("Carros alugados por "+ customer.getName() + ": ");
                            bufferedWriter.newLine();
                            for (Vehicle rentedVehicle : customer.getRentedVehicles()) {
                                bufferedWriter.write(rentedVehicle.getName());
                                bufferedWriter.newLine();
                            }
                        }
                    }
                }
            }
            bufferedWriter.write("===================================================================");
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
