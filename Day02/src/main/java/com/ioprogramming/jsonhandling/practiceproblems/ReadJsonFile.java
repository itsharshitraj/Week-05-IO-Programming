package com.ioprogramming.jsonhandling.practiceproblems;

import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadJsonFile {
    public static void main(String[] args) {
        String filePath = "src/main/resources/student.json";

        try (FileReader reader = new FileReader(filePath, StandardCharsets.UTF_8)) {
            // Read JSON file content into a String
            StringBuilder jsonContent = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                jsonContent.append((char) i);
            }

            // Parse the JSON content
            JSONObject jsonObject = new JSONObject(jsonContent.toString());

            // Extract specific fields (name and email)
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");

            // Print extracted fields
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

