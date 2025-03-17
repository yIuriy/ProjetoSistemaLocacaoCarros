package com.iuri.test;

import com.iuri.domain.*;
import com.iuri.services.*;

import java.util.Objects;
import java.util.Scanner;

public class VehicleRentSystem {
    public static void main(String[] args) {
        RentalCompany rentalCompany = new RentalCompany("CarrosJavai");

        RegisterCarForRent.register("Audi", "Sport", "AKC4F32", 100_000, CarType.SPORTY, rentalCompany);
        RegisterCarForRent.register("BMW", "Sedan", "XYZ1A23", 150_000, CarType.SEDAN, rentalCompany);
        RegisterCarForRent.register("Toyota", "Corolla", "JHG2B45", 90_000, CarType.SEDAN, rentalCompany);

        RegisterMotorcycleForRent.register("Honda", "Ji", "GHT4F54", 20_000, rentalCompany);
        RegisterMotorcycleForRent.register("Yamaha", "MT-07", "MOT3C67", 35_000, rentalCompany);
        RegisterMotorcycleForRent.register("Suzuki", "GSX-R1000", "BKE9D89", 50_000, rentalCompany);

        RegisterTruckForRent.register("Marcopolo", "Rural", "FDF8G12", 400_000, rentalCompany);
        RegisterTruckForRent.register("Volvo", "FH16", "TRK5E77", 600_000, rentalCompany);
        RegisterTruckForRent.register("Scania", "R450", "LOR7F99", 550_000, rentalCompany);

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("""
                    1 - Cadastrar cliente
                    2 - Sistema Cliente
                    3 - Sistema Concessionária""");
            System.out.println("Digite a opção desejada:");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("CADASTRO DE CLIENTE");
                    System.out.println("Digite seu nome: ");
                    String name = scanner.nextLine();
                    System.out.println("Digite seu cpf: ");
                    String cpf = scanner.nextLine();
                    System.out.println("Crie um senha: ");
                    String pass = scanner.nextLine();
                    try {
                        RegisterCustomer.register(name, cpf, pass, rentalCompany);
                        System.out.println("Cliente registrado com sucesso.");
                        break;
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 2:
                    System.out.println("Digite seu cpf: ");
                    String cpfForValidation = scanner.nextLine();
                    System.out.println("Digite sua senha: ");
                    String passwordForValidation = scanner.nextLine();
                    try {
                        Customer temporaryCustomer = rentalCompany.getCustomerByCpf(cpfForValidation);
                        if (Objects.equals(temporaryCustomer.getPassword(), passwordForValidation)) {
                            System.out.println("""
                                    1 - Ver carros disponíveis para alugar
                                    2 - Alugar um veículo
                                    3 - Devolver veículo alugado
                                    """);
                            option = scanner.nextInt();
                            scanner.nextLine();
                            switch (option) {
                                case 1:
                                    ShowAllVehiclesAvailableForRent.showRented(rentalCompany);
                                    break;
                                case 2:
                                    
                            }
                        } else {
                            System.out.println("Senha incorreta.");
                            break;
                        }
                    } catch (RuntimeException e) {
                        System.out.println("O CPF digitado não foi encontrado no sistema.");
                        break;
                    }
            }
        }
        while (option != 0);
    }
}
