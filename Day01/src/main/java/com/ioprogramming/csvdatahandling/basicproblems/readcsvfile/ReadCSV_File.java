package com.ioprogramming.csvdatahandling.basicproblems.readcsvfile;

import java.io.IOException;
import java.io.*;

public class ReadCSV_File {
    public static void main(String[] args) {
        String filePath = "src/main/resources/student.csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println(columns[0] + "," + columns[1] + "," + columns[2] + "," + columns[3]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
