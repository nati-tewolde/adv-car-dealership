package com.pluralsight.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void saveContract(Contract contract) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.csv", true));

            String contractType;
            if (contract instanceof SalesContract) {
                String financeOption;
                if (((SalesContract) contract).isFinanced()) {
                    financeOption = "YES";
                } else {
                    financeOption = "NO";
                }
                contractType = "SALE";

                writer.write(contractType + "|" + contract.getContractDate() + "|" + contract.getCustomerName() + "|"
                        + contract.getCustomerEmail() + "|" + contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear() + "|"
                        + contract.getVehicleSold().getMake() + "|" + contract.getVehicleSold().getModel() + "|" + contract.getVehicleSold().getVehicleType() + "|"
                        + contract.getVehicleSold().getColor() + "|" + contract.getVehicleSold().getOdometer() + "|"
                        + String.format("%.2f", contract.getVehicleSold().getPrice()) + "|" + String.format("%.2f", ((SalesContract) contract).getSalesTaxAmount()) + "|"
                        + String.format("%.2f", ((SalesContract) contract).getRecordingFee()) + "|" + String.format("%.2f", ((SalesContract) contract).getProcessingFee()) + "|"
                        + String.format("%.2f", contract.getTotalPrice()) + "|" + financeOption + "|" + String.format("%.2f", contract.getMonthlyPayment()) + "\n");

            } else {
                contractType = "LEASE";

                writer.write(contractType + "|" + contract.getContractDate() + "|" + contract.getCustomerName() + "|"
                        + contract.getCustomerEmail() + "|" + contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear() + "|"
                        + contract.getVehicleSold().getMake() + "|" + contract.getVehicleSold().getModel() + "|" + contract.getVehicleSold().getVehicleType() + "|"
                        + contract.getVehicleSold().getColor() + "|" + contract.getVehicleSold().getOdometer() + "|"
                        + String.format("%.2f", contract.getVehicleSold().getPrice()) + "|" + String.format("%.2f", ((LeaseContract) contract).getExpectedEndingValue()) + "|"
                        + String.format("%.2f", ((LeaseContract) contract).getLeaseFee()) + "|" + String.format("%.2f", contract.getTotalPrice()) + "|"
                        + String.format("%.2f", contract.getMonthlyPayment()) + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("\nError writing to file.");
        }
    }
}
