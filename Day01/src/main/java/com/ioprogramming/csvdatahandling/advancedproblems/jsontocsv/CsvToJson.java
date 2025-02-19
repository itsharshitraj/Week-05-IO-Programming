package com.ioprogramming.csvdatahandling.advancedproblems.jsontocsv;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvToJson {

    public static void main(String[] args) {
        String csvFilePath = "src/main/resources/students2.csv";
        String jsonFilePath = "src/main/resources/student2.json";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            JSONArray jsonArray = new JSONArray();

            // Read CSV file and process
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                // Skip header row
                if (fields[0].equals("ID")) continue;

                JSONObject student = new JSONObject();
                student.put("ID", fields[0]);
                student.put("Name", fields[1]);
                student.put("Age", Integer.parseInt(fields[2]));
                student.put("Grade", fields[3]);

                // Add the student record to JSON array
                jsonArray.put(student);
            }

            // Write the JSON data to file
            java.nio.file.Files.write(java.nio.file.Paths.get(jsonFilePath), jsonArray.toString(4).getBytes());
            System.out.println("JSON file generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
