package com.ioprogramming.csvdatahandling.basicproblems.writecsvdata;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class WriteDataCSV_File {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/employee.csv";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write("ID,Name,Department,Salary \n");

            writer.write("101,John Doe,Engineering,60000 \n");
            writer.write("102,Jane Smith,HR,50000 \n]");
            writer.write("103,Michael Brown,Marketing,55000 \n");
            writer.write("104,John Cena Doe,Engineering,64000 \n");
            writer.write("105,Jane Smith Grace,HR,55000 \n]");
            writer.write("106,Michael Brown Smith,Marketing,55000 \n");

            writer.close();
            System.out.println("CSV file created at " + csvFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
