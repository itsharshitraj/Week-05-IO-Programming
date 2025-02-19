package com.ioprogramming.csvdatahandling.advancedproblems.encryptcsvdata;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class DecryptCSV {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "1234567890123456"; // 16-byte key for AES-128

    public static void main(String[] args) {
        String csvFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/encryptcsvdata/employees_encrypt.csv"; // Path to input encrypted CSV file

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip the header line
                if (line.startsWith("ID")) {
                    continue;
                }

                // Split the CSV data
                String[] fields = line.split(",");
                String id = fields[0];
                String name = fields[1];
                String encryptedEmail = fields[2];
                String encryptedSalary = fields[3];

                // Decrypt sensitive fields (Email and Salary)
                String email = decrypt(encryptedEmail);
                String salary = decrypt(encryptedSalary);

                // Print the decrypted data
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Salary: " + salary);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to decrypt data using AES
    private static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData); // Decode from Base64
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes); // Return decrypted data as String
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
