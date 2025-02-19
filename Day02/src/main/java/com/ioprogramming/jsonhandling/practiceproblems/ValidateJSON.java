package com.ioprogramming.jsonhandling.practiceproblems;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

class Student{
    public String name;
    public int age;
    public String email;

    public Student(){

    }
}

public class ValidateJSON {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"Harshit\", \"age\": 22, \"email\": \"harshit@example.com\" }";
        ObjectMapper mapper = new ObjectMapper();

        try{
            // validate json structure by mapping to pojo
            Student student = mapper.readValue(jsonString, Student.class);
            System.out.println("Valid JSON: " + student.name);
            System.out.println("Valid JSON: " + student.age);
            System.out.println("Valid JSON: " + student.email);

        } catch (JsonProcessingException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
