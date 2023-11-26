package org.example.part1;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;
    public Order(Integer id, Integer userId){
        this.id = id;
        this.userId = userId;
        this.orderDetails = new HashMap<>();
        this.totalPrice = 0.0;
    }
    Integer getId(){
        return id;
    }
    Integer getUserId(){
        return userId;
    }
    Map<Product, Integer> getOrderDetails(){
        return orderDetails;
    }
    double getTotalPrice(){
        return totalPrice;
    }
    public void calculateTotalPrice(){
        for(Map.Entry<Product, Integer> entry : orderDetails.entrySet()){
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
    }
}
