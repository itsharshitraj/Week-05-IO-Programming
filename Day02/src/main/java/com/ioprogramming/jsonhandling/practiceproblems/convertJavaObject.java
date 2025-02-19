package com.ioprogramming.jsonhandling.practiceproblems;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Car{
    public String brandName;
    public String modelName;
    public String color;
    public double price;

    public Car(String brandName, String modelName,String color,double price){
        this.brandName = brandName;
        this.modelName = modelName;
        this.color = color;
        this.price = price;
    }

}
public class convertJavaObject {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Car car = new Car("Mahindra","Thar","Black",1500000);

            // Convert java object to json string
            String jsonString = mapper.writeValueAsString(car);
            System.out.println(jsonString);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}
