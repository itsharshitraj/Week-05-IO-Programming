package com.ioprogramming.csvdatahandling.advancedproblems.mergetwocsvfile;

import java.io.*;
import java.util.*;

public class MergeCSVFile {
    public static void main(String[] args) {
        String file1 = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/mergetwocsvfile/students1.csv";
        String file2 = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/mergetwocsvfile/students2.csv";
        String outputFile = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/mergetwocsvfile/mergedFile.csv";

        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean firstLine = true;
            while ((line = br1.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                } // Skip header
                String[] columns = line.split(",");
                studentData.put(columns[0], new String[]{columns[1], columns[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Student> mergedStudents = new ArrayList<>();

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean firstLine = true;
            while ((line = br2.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                } // Skip header
                String[] columns = line.split(",");
                if (studentData.containsKey(columns[0])) {
                    String[] studentInfo = studentData.get(columns[0]);
                    mergedStudents.add(new Student(columns[0], studentInfo[0], studentInfo[1], columns[1], columns[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write merged data to a new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n"); // Header
            for (Student s : mergedStudents) {
                bw.write(s.toString() + "\n");
            }
            System.out.println("Merged CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
