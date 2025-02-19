package com.ioprogramming.csvdatahandling.intermediateproblems.sortcsvrecord;

import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filPath = "src/main/resources/employee.csv";
        List<String[]> employeeData = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filPath));
            String line;
            boolean firstLine = true;
            String[] header = null;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                if (firstLine) {
                    header = columns;
                    firstLine = false;
                    continue;
                }
                employeeData.add(columns);
            }
            // Sort employees by Salary (Descending Order)
            employeeData.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

// Print the top 5 highest-paid employees
            System.out.println(String.join(", ", header)); // Print header
            int count = 0;
            for (String[] employee : employeeData) {
                System.out.println(String.join(", ", employee));
                count++;
                if (count == 5) break; // Stop after top 5
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
