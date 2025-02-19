package com.ioprogramming.jsonhandling.hands_on_practiceproblems.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXml {
    public static void main(String[] args) {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        try {
            // Load JSON file
            JsonNode jsonData = jsonMapper.readTree(new File("src/main/java/com/ioprogramming/jsonhandling/hands_on_practiceproblems/jsontoxml/input.json"));

            // Convert JSON to XML
            String xmlData = xmlMapper.writeValueAsString(jsonData);

            // Print XML output
            System.out.println(xmlData);

            // Write XML to a file
            xmlMapper.writeValue(new File("src/main/java/com/ioprogramming/jsonhandling/hands_on_practiceproblems/jsontoxml/output.xml"), jsonData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

