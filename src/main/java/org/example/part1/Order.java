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
    public Integer getId(){
        return id;
    }
    public Integer getUserId(){
        return userId;
    }
    public String getOrderDetails(){
        StringBuilder details = new StringBuilder("{");
        for(Map.Entry<Product, Integer> entry : orderDetails.entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            details.append(product.getName()).append(" - ").append(quantity).append(", ");
        }
        if(details.length() > 2) {
            details.delete(details.length() - 2, details.length());
        }
        details.append("}");
        return details.toString();
    }
    public void setOrderDetails(Map<Product, Integer> orderDetails){
        this.orderDetails = orderDetails;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public void calculateTotalPrice(){
        for(Map.Entry<Product, Integer> entry : orderDetails.entrySet()){
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
    }
    @Override
    public String toString(){
        return "id: " + id + ", userId: " + userId + ", orderDetails: " + getOrderDetails() + ", totalPrice: " + totalPrice;
    }
}
