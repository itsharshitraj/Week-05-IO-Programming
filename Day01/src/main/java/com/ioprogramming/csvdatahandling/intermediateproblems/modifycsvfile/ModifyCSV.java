package com.ioprogramming.csvdatahandling.intermediateproblems.modifycsvfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSV {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/employee.csv";
        String outputFile = "src/main/resources/updatedEmployee.csv";
        List<String[]> employeeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                if (firstLine) {
                    employeeData.add(columns);
                    firstLine = false;
                    continue;
                }

                // Check if the employee is from the IT department
                if (columns[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(columns[3].trim());
                    salary *= 1.10; // Increase by 10%
                    columns[3] = String.format("%.2f", salary); // Format salary to 2 decimal places
                }

                employeeData.add(columns);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write updated data to a new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String[] row : employeeData) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
            System.out.println("Updated CSV file saved as " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
