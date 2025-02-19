package com.ioprogramming.jsonhandling.hands_on_practiceproblems.filterjsondata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FilterJsonRecords {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file and convert to List of Person objects
            List<Person> people = objectMapper.readValue(new File("src/main/resources/people.json"), new TypeReference<List<Person>>() {});

            // Filter users with age > 25
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            // Print filtered users
            filteredPeople.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
