package com.ioprogramming.csvdatahandling.advancedproblems.validatecsv;

import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/validatecsv/employees.csv";

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { // Skip header row
                    firstLine = false;
                    continue;
                }

                String[] columns = line.split(",");
                String email = columns[2].trim();
                String phone = columns[3].trim();

                if (!email.matches(emailRegex)) {
                    System.out.println("Invalid Email: " + email + " (Row: " + line + ")");
                }
                if (!phone.matches(phoneRegex)) {
                    System.out.println("Invalid Phone: " + phone + " (Row: " + line + ")");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
