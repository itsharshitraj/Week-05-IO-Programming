package com.ioprogramming.csvdatahandling.advancedproblems.detectduplicatecsv;

import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employee.csv";
        Set<String> seenIDs = new HashSet<>();  // To track unique IDs
        List<String> duplicates = new ArrayList<>(); // To store duplicates

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerProcessed = false;

            // Read the CSV file line by line
            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (!headerProcessed) {
                    headerProcessed = true;
                    continue;
                }

                String[] columns = line.split(",");
                String id = columns[0]; // Assuming ID is in the first column

                // Check if ID is already seen
                if (seenIDs.contains(id)) {
                    duplicates.add(line); // Add duplicate record to the list
                } else {
                    seenIDs.add(id); // Add ID to the seen set
                }
            }

            // If duplicates are found, print them
            if (!duplicates.isEmpty()) {
                System.out.println("Duplicate records detected:");
                for (String duplicate : duplicates) {
                    System.out.println(duplicate);
                }
            } else {
                System.out.println("No duplicates found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
