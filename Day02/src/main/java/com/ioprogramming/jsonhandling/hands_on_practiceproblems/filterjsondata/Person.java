package com.ioprogramming.jsonhandling.hands_on_practiceproblems.filterjsondata;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private String name;
    private int age;
    private String email;


    public Person(@JsonProperty("name") String name,
                  @JsonProperty("age") int age,
                  @JsonProperty("email") String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }


    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email;
    }
}


