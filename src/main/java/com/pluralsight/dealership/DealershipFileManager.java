package com.pluralsight.dealership;

import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"));

            String line = reader.readLine();
            String[] dealershipParts = line.split("\\|");

            String name = dealershipParts[0];
            String address = dealershipParts[1];
            String phone = dealershipParts[2];

            dealership = new Dealership(name, address, phone);

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] vehicleParts = currentLine.split("\\|");

                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String vehicleType = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                double price = Double.parseDouble(vehicleParts[7]);

                dealership.addVehicle(new Vehicle(vin, year, make, model,
                        vehicleType, color, odometer, price));

            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("\nError reading file.");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv"));

            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|"
                        + vehicle.getOdometer() + "|" + String.format("%.1f", vehicle.getPrice()) + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("\nError writing to file.");
        }
    }
}
