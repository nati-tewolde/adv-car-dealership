package com.pluralsight.dealership;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {

    }

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 99) {
            System.out.println("\nWelcome to the Car Dealership!");
            System.out.println("1 - Find vehicles within a price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Sell/Lease a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your selection: ");

            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a corresponding numeric option.");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> processGetByPriceRequest(scanner);
                case 2 -> processGetByMakeModelRequest(scanner);
                case 3 -> processGetByYearRequest(scanner);
                case 4 -> processGetByColorRequest(scanner);
                case 5 -> processGetByMileageRequest(scanner);
                case 6 -> processGetByVehicleTypeRequest(scanner);
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest(scanner);
                case 9 -> processRemoveVehicleRequest(scanner);
                case 10 -> processSellOrLeaseVehicleRequest(scanner);
                case 99 -> System.out.println("\nExiting application ...");
                default -> System.out.println("\nInvalid selection: please enter a valid selection.");
            }
        }
        scanner.close();
    }

    public void processGetByPriceRequest(Scanner scanner) {
        double minPrice;
        while (true) {
            System.out.print("\nEnter minimum price: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("\nInvalid selection: please enter a numeric value for price.");
                scanner.nextLine();
                continue;
            }
            minPrice = scanner.nextDouble();
            scanner.nextLine();
            break;
        }

        double maxPrice;
        while (true) {
            System.out.print("\nEnter maximum price: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("\nInvalid selection: please enter a numeric value for price.");
                scanner.nextLine();
                continue;
            }
            maxPrice = scanner.nextDouble();
            scanner.nextLine();
            break;
        }

        List<Vehicle> matchingVehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);

        if (matchingVehicles.isEmpty()) {
            System.out.println("\nNo vehicles found within that price range.");
        } else {
            displayVehicles(matchingVehicles);
        }
    }

    public void processGetByMakeModelRequest(Scanner scanner) {
        System.out.print("\nEnter vehicle make: ");
        String make = scanner.nextLine().trim();

        System.out.print("\nEnter vehicle model: ");
        String model = scanner.nextLine().trim();

        List<Vehicle> matchingVehicles = dealership.getVehiclesByMakeModel(make, model);

        if (matchingVehicles.isEmpty()) {
            System.out.println("\nNo vehicles found matching that make/model.");
        } else {
            displayVehicles(matchingVehicles);
        }
    }

    public void processGetByYearRequest(Scanner scanner) {
        int minYear;
        while (true) {
            System.out.print("\nEnter minimum year: ");
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a numeric value for year.");
                scanner.nextLine();
                continue;
            }
            minYear = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        int maxYear;
        while (true) {
            System.out.print("\nEnter maximum year: ");
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a numeric value for year.");
                scanner.nextLine();
                continue;
            }
            maxYear = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        List<Vehicle> matchingVehicles = dealership.getVehiclesByYear(minYear, maxYear);

        if (matchingVehicles.isEmpty()) {
            System.out.println("\nNo vehicles found within that date range.");
        } else {
            displayVehicles(matchingVehicles);
        }
    }

    public void processGetByColorRequest(Scanner scanner) {
        String color;
        while (true) {
            System.out.print("\nEnter vehicle color: ");
            color = scanner.nextLine().trim();
            if (color.isEmpty()) {
                System.out.println("\nField cannot be empty.");
                continue;
            }
            break;
        }

        List<Vehicle> matchingVehicles = dealership.getVehiclesByColor(color);

        if (matchingVehicles.isEmpty()) {
            System.out.println("\nNo vehicles found matching that color.");
        } else {
            displayVehicles(matchingVehicles);
        }
    }

    public void processGetByMileageRequest(Scanner scanner) {
        int minMileage;
        while (true) {
            System.out.print("\nEnter minimum mileage: ");
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a numeric value for mileage.");
                scanner.nextLine();
                continue;
            }
            minMileage = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        int maxMileage;
        while (true) {
            System.out.print("\nEnter maximum mileage: ");
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a numeric value for mileage.");
                scanner.nextLine();
                continue;
            }
            maxMileage = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        List<Vehicle> matchingVehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);

        if (matchingVehicles.isEmpty()) {
            System.out.println("\nNo vehicles found within that mileage range.");
        } else {
            displayVehicles(matchingVehicles);
        }
    }

    public void processGetByVehicleTypeRequest(Scanner scanner) {
        String vehicleType;
        while (true) {
            System.out.print("\nEnter vehicle type: ");
            vehicleType = scanner.nextLine().trim();
            if (vehicleType.isEmpty()) {
                System.out.println("\nField cannot be empty.");
                continue;
            }
            break;
        }

        List<Vehicle> matchingVehicles = dealership.getVehiclesByType(vehicleType);

        if (matchingVehicles.isEmpty()) {
            System.out.println("\nNo vehicles found matching that type.");
        } else {
            displayVehicles(matchingVehicles);
        }
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(Scanner scanner) {
        int vin;
        while (true) {
            System.out.print("\nEnter vin to begin adding vehicle: ");
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a numeric value for vin.");
                scanner.nextLine();
                continue;
            }
            vin = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        int year;
        while (true) {
            System.out.print("\nEnter year: ");
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a numeric value for year.");
                scanner.nextLine();
                continue;
            }
            year = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        String make;
        while (true) {
            System.out.print("\nEnter vehicle make: ");
            make = scanner.nextLine().trim();
            if (make.isEmpty()) {
                System.out.println("\nField cannot be empty.");
                continue;
            }
            break;
        }

        String model;
        while (true) {
            System.out.print("\nEnter vehicle model: ");
            model = scanner.nextLine().trim();
            if (model.isEmpty()) {
                System.out.println("\nField cannot be empty.");
                continue;
            }
            break;
        }

        String type;
        while (true) {
            System.out.print("\nEnter vehicle type: ");
            type = scanner.nextLine().trim();
            if (type.isEmpty()) {
                System.out.println("\nField cannot be empty.");
                continue;
            }
            break;
        }

        String color;
        while (true) {
            System.out.print("\nEnter vehicle color: ");
            color = scanner.nextLine().trim();
            if (color.isEmpty()) {
                System.out.println("\nField cannot be empty.");
                continue;
            }
            break;
        }

        int mileage;
        while (true) {
            System.out.print("\nEnter vehicle mileage: ");
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a numeric value for mileage.");
                scanner.nextLine();
                continue;
            }
            mileage = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        double price;
        while (true) {
            System.out.print("\nEnter vehicle price: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("\nInvalid selection: please enter a numeric value for price.");
                scanner.nextLine();
                continue;
            }
            price = scanner.nextDouble();
            scanner.nextLine();
            break;
        }

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        dealership.addVehicle(vehicle);
        dealershipFileManager.saveDealership(dealership);

        System.out.println("\nVehicle successfully added!");
    }

    public void processRemoveVehicleRequest(Scanner scanner) {
        int vin;
        while (true) {
            System.out.print("\nEnter vin to remove vehicle from inventory: ");
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a numeric value for vin.");
                scanner.nextLine();
                continue;
            }
            vin = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        if (!dealership.removeVehicle(vin)) {
            System.out.println("\nVIN not found.");
        } else {
            dealershipFileManager.saveDealership(dealership);
            System.out.println("\nVehicle successfully removed.");
        }
    }

    private void init() {
        DealershipFileManager dealershipDetails = new DealershipFileManager();
        this.dealership = dealershipDetails.getDealership();
    }

    private void displayVehicles(List<Vehicle> inventory) {
        System.out.printf("%n%55s%n%n", "--Vehicle Inventory--");
        System.out.printf("%-6s | %-4s | %-12s | %-8s | %-8s | %-8s | %-8s | %9s%n",
                "VIN", "Year", "Make", "Model", "Vehicle Type", "Color", "Mileage", "Price");
        System.out.println("-".repeat(88));

        for (Vehicle vehicle : inventory) {
            System.out.printf("%-6s | %-4s | %-12s | %-8s | %-12s | %-8s | %-8s | %9s%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    String.format("$%.1f", vehicle.getPrice()));
        }
    }

    public void processSellOrLeaseVehicleRequest(Scanner scanner) {
        String contractType;
        while (true) {
            System.out.print("\nWould you like to record a Sale or Lease (S/L): ");
            contractType = scanner.nextLine().trim();
            if (!contractType.equalsIgnoreCase("s") &&
                    !contractType.equalsIgnoreCase("l")) {
                System.out.println("\nSelection must be S or L.");
                continue;
            }
            break;
        }

        int vin;
        while (true) {
            System.out.print("\nEnter vin to search for vehicle: ");
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid selection: please enter a numeric value for vin.");
                scanner.nextLine();
                continue;
            }
            vin = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        int age = 0;
        int currentYear = LocalDate.now().getYear();
        Vehicle matchingVehicle = null;

        boolean isFound = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vin == vehicle.getVin()) {
                matchingVehicle = vehicle;
                isFound = true;
                age = currentYear - vehicle.getYear();
            }
        }

        if (!isFound) {
            System.out.println("\nVehicle not found, please enter another vin.");
            return;
        } else if (contractType.equalsIgnoreCase("l") && age > 3) {
            System.out.println("\nVehicle cannot be leased (age exceeds 3 years).");
            return;
        }

        String customerName;
        while (true) {
            System.out.print("\nEnter customer's full name: ");
            customerName = scanner.nextLine().trim();
            if (customerName.isEmpty()) {
                System.out.println("\nField cannot be empty.");
                continue;
            }
            break;
        }

        String customerEmail;
        while (true) {
            System.out.print("\nEnter customer's email address: ");
            customerEmail = scanner.nextLine().trim();
            if (customerEmail.isEmpty()) {
                System.out.println("\nField cannot be empty.");
                continue;
            }
            break;
        }

        Contract contract;
        LocalDate contractDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedContractDate = contractDate.format(formatter);

        if (contractType.equalsIgnoreCase("s")) {
            String financeOption;
            while (true) {
                System.out.print("\nWill the customer be financing the vehicle? (Y/N): ");
                financeOption = scanner.nextLine().trim();
                if (!financeOption.equalsIgnoreCase("y") &&
                        !financeOption.equalsIgnoreCase("n")) {
                    System.out.println("\nSelection must be Y or N.");
                    continue;
                }
                break;
            }

            SalesContract salesContract = new SalesContract(formattedContractDate, customerName, customerEmail, matchingVehicle);
            salesContract.setFinanced(financeOption.equalsIgnoreCase("y"));
            contract = salesContract;
        } else {
            contract = new LeaseContract(formattedContractDate, customerName, customerEmail, matchingVehicle);
        }

        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.saveContract(contract);

        dealership.removeVehicle(vin);

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);

        System.out.println("\nContract successfully recorded and vehicle removed from inventory.");
    }
}
