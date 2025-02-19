package com.ioprogramming.jsonhandling.hands_on_practiceproblems.readjsonfile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.*;
import java.util.*;
public class ReadJSON_File {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            JsonNode rootNode = mapper.readTree(new File("src/main/resources/student.json"));

            // call recursive function to print all key,values
            printJson(rootNode,"");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void printJson(JsonNode node, String prefix){
        if(node.isObject()) {
            // If it's an object, iterate over fields (key-value pairs)
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while(fields.hasNext()) {
                 Map.Entry<String, JsonNode> entry = fields.next();
                 printJson(entry.getValue(), prefix + entry.getKey() + ".");
            }
        } else if (node.isArray()) {
            // If it's an array, iterate over elements
            for(int i = 0; i < node.size();i++){
                printJson(node.get(i),prefix + "[" + i + "].");
            }
        } else{
            // Print key-value pair
            System.out.println(prefix.substring(0,prefix.length() -1) + " = " + node.asText());
        }
    }
}
