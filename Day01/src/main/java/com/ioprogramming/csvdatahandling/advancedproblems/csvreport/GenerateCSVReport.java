package com.ioprogramming.csvdatahandling.advancedproblems.csvreport;

import java.io.*;
import java.sql.*;

public class GenerateCSVReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database"; // Database URL
        String user = "root";  // Database username
        String password = "password";  // Database password
        String outputFilePath = "employee_report.csv";  // CSV output file path

        // SQL query to fetch employee records
        String query = "SELECT id, name, department, salary FROM employees";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            // Write CSV header
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();  // Move to the next line

            // Process the result set and write to CSV
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                // Write the record to CSV
                writer.write(id + "," + name + "," + department + "," + salary);
                writer.newLine();  // Move to the next line
            }

            System.out.println("CSV report generated successfully!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
