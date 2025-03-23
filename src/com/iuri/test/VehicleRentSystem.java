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
                    3 - Sistema Concessionária
                    0 - Parar o programa""");
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
                                    3 - Mostrar veículo alugado
                                    3 - Devolver veículo alugado
                                    """);
                            option = scanner.nextInt();
                            scanner.nextLine();
                            switch (option) {
                                case 1:
                                    ShowAllVehiclesAvailableForRent.showAvailableForRent(rentalCompany);
                                    break;
                                case 2:
                                    System.out.println("Digite a placa do carro desejado: ");
                                    String plate = scanner.nextLine();
                                    System.out.println("Digite a quantidade de dias que o carro será alugado: ");
                                    int rentalDays = scanner.nextInt();
                                    scanner.nextLine();
                                    RentVehicle.rent(temporaryCustomer, rentalCompany, plate, rentalDays);
                                    System.out.println("Veículo alugado com sucesso.");
                                    break;
                                case 3:
                                    ShowCustomerRentedVehicles.show(temporaryCustomer);
                                    break;
                                case 4:
                                    if (temporaryCustomer.getRentedVehicles().isEmpty()) {
                                        System.out.println("O cliente " + temporaryCustomer.getName() + " não possui nenhum " +
                                                "veículo alugado");
                                        break;
                                    }
                                    System.out.println("Digite a placa do veículo a ser devolvido: ");
                                    String vehicleToBeReturnedPlate = scanner.nextLine();
                                    ReturnVehicle.returnVehicle(temporaryCustomer, rentalCompany, vehicleToBeReturnedPlate);
                                    break;
                            }
                        } else {
                            System.out.println("Senha incorreta.");
                            break;
                        }
                    } catch (RuntimeException e) {
                        System.out.println("O CPF digitado não foi encontrado no sistema.");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("""
                            SISTEMA CONCESSIONÁRIA
                            1 - Listar clientes
                            2 - Listar todos os veículos
                            3 - Listar todos os veículos alugados
                            4 - Listar todos os veículos disponíveis para alugar
                            5 - Cadastrar um veículo
                            6 - Gerar relatório
                            0 - Parar o programa
                            """);
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            if (rentalCompany.getCustomerList().isEmpty()) {
                                System.out.println("Não há nenhum cliente cadastrado.");
                                break;
                            }
                            ShowAllCustomers.showCustomers(rentalCompany);
                        case 2:
                            if (rentalCompany.getVehicleList().isEmpty()) {
                                System.out.println("Não há nenhum veículo cadastrado.");
                                break;
                            }
                            ShowAllVehicles.show(rentalCompany);
                        case 3:
                            ShowAllRentedVehicles.showRented(rentalCompany);
                            break;
                        case 4:
                            ShowAllVehiclesAvailableForRent.showAvailableForRent(rentalCompany);
                            break;
                        case 5:
                            System.out.println("""
                                    1 - Carro
                                    2 - Moto
                                    3 - Caminhão
                                    Digite o tipo de veículo a ser alugado:""");
                            option = scanner.nextInt();
                            scanner.nextLine();
                            switch (option) {
                                case 1:
                                    System.out.println("Digite o nome do carro: ");
                                    String carName = scanner.nextLine();
                                    System.out.println("Digite o modelo do carro: ");
                                    String carModel = scanner.nextLine();
                                    System.out.println("Digite a placa do carro no padrão(ACB1DE23): ");
                                    String carPlate = scanner.nextLine();
                                    System.out.println("Digite o preço do carro: ");
                                    double carPrice = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.println("""
                                            Escolha o tipo de carro:
                                            SUV
                                            PICKUP
                                            SPORTY
                                            SEDAN
                                            """);
                                    CarType carType = CarType.valueOf(scanner.nextLine().toUpperCase());
                                    RegisterCarForRent.register(carName, carModel, carPlate, carPrice, carType, rentalCompany);
                                    System.out.println("Carro cadastrado com sucesso.");
                                    break;
                                case 2:
                                    System.out.println("Digite o nome da moto: ");
                                    String motoName = scanner.nextLine();
                                    System.out.println("Digite o modelo da moto: ");
                                    String motoModel = scanner.nextLine();
                                    System.out.println("Digite a placa da moto no padrão(ACB1DE23): ");
                                    String motoPlate = scanner.nextLine();
                                    System.out.println("Digite o preço da moto: ");
                                    double motoPrice = scanner.nextDouble();
                                    scanner.nextLine();
                                    RegisterMotorcycleForRent.register(motoName, motoModel, motoPlate, motoPrice, rentalCompany);
                                    System.out.println("Moto cadastrada com sucesso.");
                                    break;
                                case 3:
                                    System.out.println("Digite o nome do caminhão: ");
                                    String truckName = scanner.nextLine();
                                    System.out.println("Digite o modelo do caminhão: ");
                                    String truckModel = scanner.nextLine();
                                    System.out.println("Digite a placa do caminhão no padrão(ACB1DE23): ");
                                    String truckPlate = scanner.nextLine();
                                    System.out.println("Digite o preço do caminhão: ");
                                    double truckPrice = scanner.nextDouble();
                                    scanner.nextLine();
                                    RegisterMotorcycleForRent.register(truckName, truckModel, truckPlate, truckPrice,
                                            rentalCompany);
                                    System.out.println("Caminhão cadastrada com sucesso.");
                                    break;
                            }
                        case 6:
                            try {
                                CreateReport.create(rentalCompany);
                                System.out.println("Relatório criado com sucesso");
                            } catch (RuntimeException e) {
                                System.out.println("Erro ao gerar o relatório.");
                            }
                            break;
                        default:
                            System.out.println("Digite uma opção válida!");
                            break;
                    }
            }
        }
        while (option != 0);
    }
}
