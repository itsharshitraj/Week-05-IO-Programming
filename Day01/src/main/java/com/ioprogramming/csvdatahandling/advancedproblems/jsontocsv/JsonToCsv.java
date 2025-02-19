package com.ioprogramming.csvdatahandling.advancedproblems.jsontocsv;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JsonToCsv {

    public static void main(String[] args) {
        String jsonFilePath = "src/main/resources/students.json";
        String csvFilePath = "src/main/resources/students.csv";

        try {
            // Read the JSON file
            String jsonContent = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(jsonFilePath)));
            JSONArray jsonArray = new JSONArray(jsonContent);

            // Create CSV file and BufferedWriter to write it
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));

            // Write CSV headers
            writer.write("ID,Name,Age,Grade");
            writer.newLine();

            // Write JSON data to CSV
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject student = jsonArray.getJSONObject(i);
                String id = student.getString("ID");
                String name = student.getString("Name");
                int age = student.getInt("Age");
                String grade = student.getString("Grade");

                // Write row to CSV file
                writer.write(id + "," + name + "," + age + "," + grade);
                writer.newLine();
            }

            // Close writer
            writer.close();
            System.out.println("CSV file generated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
