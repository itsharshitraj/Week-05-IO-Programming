package com.ioprogramming.jsonhandling.practiceproblems;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

class Stud{
    private String name;
    private int age;
    private String email;

    public Stud(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }

}
public class ListToJsonArray {
    public static void main(String[] args) {
        List<Stud> students = new ArrayList<>();
        students.add(new Stud("Harshit",22,"harshit@example.com"));
        students.add(new Stud("Gautam",21,"gautam@example.com"));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // list to Json Array
            String jsonArray = objectMapper.writeValueAsString(students);
            System.out.println(jsonArray);

        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
