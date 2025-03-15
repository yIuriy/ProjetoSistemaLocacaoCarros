package com.iuri.test;

import com.iuri.domain.*;

public class VehicleRentSystem {
    public static void main(String[] args) {
        RentalCompany rentalCompany = new RentalCompany("CarrosJavai");
        Vehicle car1 = new Car("Audi", "Sport", "AKC4F32", 100_000, CarType.SPORTY);
        Vehicle car2 = new Car("BMW", "Sedan", "XYZ1A23", 150_000, CarType.SEDAN);
        Vehicle car3 = new Car("Toyota", "Corolla", "JHG2B45", 90_000, CarType.SEDAN);

        Vehicle moto1 = new Motorcycle("Honda", "Ji", "GHT4F54", 20_000);
        Vehicle moto2 = new Motorcycle("Yamaha", "MT-07", "MOT3C67", 35_000);
        Vehicle moto3 = new Motorcycle("Suzuki", "GSX-R1000", "BKE9D89", 50_000);

        Vehicle truck1 = new Truck("Marcopolo", "Rural", "FDF8G12", 400_000);
        Vehicle truck2 = new Truck("Volvo", "FH16", "TRK5E77", 600_000);
        Vehicle truck3 = new Truck("Scania", "R450", "LOR7F99", 550_000);
    }
}
