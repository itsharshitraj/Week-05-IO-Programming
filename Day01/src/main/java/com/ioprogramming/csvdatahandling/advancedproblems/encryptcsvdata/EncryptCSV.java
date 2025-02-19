package com.ioprogramming.csvdatahandling.advancedproblems.encryptcsvdata;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class EncryptCSV {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "1234567890123456"; // 16-byte key for AES-128

    public static void main(String[] args) {
        String csvFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/encryptcsvdata/employees_encrypt.csv "; // Path to output CSV file


        String[][] employees = {
                {"101", "John Doe", "john@example.com", "60000"},
                {"102", "Alice Ray", "alice@example.com", "50000"},
                {"103", "Bob Smith", "bob@example.com", "70000"}
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            // Write CSV header
            writer.write("ID,Name,Email,Salary");
            writer.newLine();

            for (String[] emp : employees) {
                String id = emp[0];
                String name = emp[1];
                String email = emp[2];
                String salary = emp[3];

                // Encrypt sensitive fields (Email and Salary)
                String encryptedEmail = encrypt(email);
                String encryptedSalary = encrypt(salary);

                // Write encrypted data to CSV
                writer.write(id + "," + name + "," + encryptedEmail + "," + encryptedSalary);
                writer.newLine();
            }

            System.out.println("Encrypted CSV file generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to encrypt data using AES
    private static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes); // Encode to Base64 for storing
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
