package com.ioprogramming.csvdatahandling.intermediateproblems.filterrecords;

import java.io.*;

public class FilterRecords {
    public static void main(String[] args) {
        String filePath = "src/main/resources/studentMarks.csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                // Skip the header row
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] columns = line.split(",");
                int marks = Integer.parseInt(columns[2].trim());
                if (marks > 80) {
                    System.out.println(columns[1] + " scored " + marks);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
