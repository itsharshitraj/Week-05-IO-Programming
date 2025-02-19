package com.ioprogramming.jsonhandling.hands_on_practiceproblems.csvtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.Arrays;

public class CsvToJson {
    public static void main(String[] args) {
        String csvFile = "src/main/java/com/ioprogramming/jsonhandling/hands_on_practiceproblems/csvtojson/data.csv";
        String jsonFile = "src/main/java/com/ioprogramming/jsonhandling/hands_on_practiceproblems/csvtojson/output.json";

        convertCsvToJson(csvFile, jsonFile);
    }

    public static void convertCsvToJson(String csvFile, String jsonFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.out.println("CSV file is empty!");
                return;
            }

            // Extract headers
            String[] headers = headerLine.split(",");

            // Read CSV data
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ObjectNode jsonObject = objectMapper.createObjectNode();

                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i].trim(), values[i].trim());
                }

                jsonArray.add(jsonObject);
            }

            // Write JSON to file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), jsonArray);
            System.out.println("JSON file created successfully: " + jsonFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
