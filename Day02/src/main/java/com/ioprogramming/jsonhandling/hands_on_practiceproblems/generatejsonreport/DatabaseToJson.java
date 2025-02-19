package com.ioprogramming.jsonhandling.hands_on_practiceproblems.generatejsonreport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseToJson {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "password";

        String query = "SELECT EmployeeID, Name, Department, Salary FROM employees";

        // Jackson ObjectMapper to handle JSON
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                jsonObject.put("EmployeeID", rs.getInt("EmployeeID"));
                jsonObject.put("Name", rs.getString("Name"));
                jsonObject.put("Department", rs.getString("Department"));
                jsonObject.put("Salary", rs.getDouble("Salary"));

                jsonArray.add(jsonObject);
            }

            // Write JSON to a file
            File file = new File("src/main/java/com/ioprogramming/jsonhandling/hands_on_practiceproblems/generatejsonreport/employees.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, jsonArray);

            System.out.println("JSON report generated successfully: " + file.getAbsolutePath());

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

