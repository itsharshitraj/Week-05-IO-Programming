package com.ioprogramming.csvdatahandling.basicproblems.readandcountrows;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Read_Count_Rows {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employee.csv";
        int rowsCount = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (reader.readLine() != null) {
                rowsCount++;
            }
            System.out.println("Total rows: " + rowsCount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
