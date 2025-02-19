package com.ioprogramming.jsonhandling.practiceproblems;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FilterJsonRecords {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON from file
        List<Person> people = objectMapper.readValue(new File("src/main/resources/student_parse.json"),
                new TypeReference<List<Person>>() {});

        // Filter records where age > 25
        List<Person> filtered = people.stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList());

        // Print results
        filtered.forEach(System.out::println);
    }
}

// Simple POJO class
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore extra fields in JSON
class Person {
    private String name;
    private int age;
    private String email;

    public Person(){}

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
