package com.ioprogramming.csvdatahandling.intermediateproblems.searchrecord;

import java.io.*;
import java.util.*;

public class SearchRecord {
    public static void main(String[] args) {
        String filPath = "src/main/resources/employee.csv";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Name to Search:");
        String searchName = sc.nextLine().trim();

        boolean found = false; // initializing a variable to keep track of employee

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filPath));
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] columns = line.split(",");

                // Check if the name matches
                if (columns[1].trim().equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + columns[2]);
                    System.out.println("Salary: $" + columns[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
