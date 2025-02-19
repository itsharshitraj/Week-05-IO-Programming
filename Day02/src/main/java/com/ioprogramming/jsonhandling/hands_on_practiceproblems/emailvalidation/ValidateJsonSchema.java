package com.ioprogramming.jsonhandling.hands_on_practiceproblems.emailvalidation;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

import java.io.File;
import java.io.IOException;

public class ValidateJsonSchema {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonValidator validator = JsonSchemaFactory.byDefault().getValidator();

        try {
            // Load JSON data
            JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/user.json"));

            // Load JSON Schema
            JsonNode schemaNode = objectMapper.readTree(new File("src/main/resources/email-validation-schema.json"));

            // Validate JSON
            ProcessingReport report = validator.validate(schemaNode, jsonData);

            // Print validation result
            if (report.isSuccess()) {
                System.out.println("JSON is valid.");
            } else {
                System.out.println("JSON validation failed:");
                report.forEach(msg -> System.out.println(msg));
            }

        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }
}
