package com.ioprogramming.jsonhandling.practiceproblems;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSON_Object {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();

        student.put("name", "Harshit");
        student.put("age", 22);

        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Physics");
        subjects.put("Chemistry");

        student.put("subjects", subjects);

        System.out.println(student.toString(4));

    }
}
