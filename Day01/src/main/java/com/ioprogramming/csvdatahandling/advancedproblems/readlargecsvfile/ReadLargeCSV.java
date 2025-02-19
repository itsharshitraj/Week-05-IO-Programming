package com.ioprogramming.csvdatahandling.advancedproblems.readlargecsvfile;

import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/large_dataset.csv";
        int batchSize = 100; // Process 100 lines at a time
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int batchCount = 0;

            // Read and process file in chunks
            while ((line = br.readLine()) != null) {
                batchCount++;
                totalRecords++;

                // Process the current line (Example: Just print the first few)
                if (totalRecords <= 5) { // Print only first 5 for preview
                    System.out.println(line);
                }

                // When batchSize limit is reached, reset batch counter
                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    batchCount = 0; // Reset for next batch
                }
            }

            // Final summary
            System.out.println("Total records processed: " + totalRecords);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
