package com.ioprogramming.jsonhandling.hands_on_practiceproblems.mergetwojsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Load first JSON file
            JsonNode json1 = objectMapper.readTree(new File("src/main/java/com/ioprogramming/jsonhandling/hands_on_practiceproblems/mergetwojsonfiles/file1.json"));

            // Load second JSON file
            JsonNode json2 = objectMapper.readTree(new File("src/main/java/com/ioprogramming/jsonhandling/hands_on_practiceproblems/mergetwojsonfiles/file2.json"));

            // Merge json2 into json1
            ObjectNode mergedJson = (ObjectNode) json1;
            mergedJson.setAll((ObjectNode) json2);

            // Print the merged JSON
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));

            // Write merged JSON to a new file
            objectMapper.writeValue(new File("src/main/java/com/ioprogramming/jsonhandling/hands_on_practiceproblems/mergetwojsonfiles/merged.json"), mergedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
