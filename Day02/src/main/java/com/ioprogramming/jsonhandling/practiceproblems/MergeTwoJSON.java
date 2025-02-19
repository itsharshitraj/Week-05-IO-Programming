package com.ioprogramming.jsonhandling.practiceproblems;
import org.json.JSONObject;
public class MergeTwoJSON {
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("name", "Harshit");
        json1.put("age",22);

        JSONObject json2 = new JSONObject();
        json2.put("email", "harshit@gmail.com");
        json2.put("city", "Bhopal");

        for(String key : json2.keySet()) {
            json1.put(key,json2.get(key));
        }
        System.out.println(json1.toString(4));
    }
}
