package com.ioprogramming.jsonhandling.hands_on_practiceproblems.listobjectintojsonarray;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ListToJsonArray {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("John Doe", 25, "john.doe@example.com"),
                new Person("Alice Smith", 30, "alice.smith@example.com"),
                new Person("Bob Johnson", 28, "bob.johnson@example.com")
        );

        // Convert list to JSON array
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {

            objectMapper.writeValue(new File("src/main/resources/people.json"), people);

            // Print JSON string to console
            String jsonString = objectMapper.writeValueAsString(people);
            System.out.println(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}