package com.ioprogramming.csvdatahandling.advancedproblems.csvintojavaobjects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudentObjects {
    public static void main(String[] args) {
        String filePath = "src/main/resources/student.csv";
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                int age = Integer.parseInt(columns[2].trim());
                int marks = Integer.parseInt(columns[3].trim());

                // Create Student object and add to list
                Student student = new Student(id, name, age, marks);
                studentList.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
