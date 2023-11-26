package org.example.part2;

import org.example.part1.*;
import java.util.Map;
import java.util.HashMap;

public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;
    public ECommercePlatform(){
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }
    public void addUser(User user){
        users.put(user.getId(), user);
    }
    public void addProduct(Product product){
        products.put(product.getId(), product);
    }
    public void createOrder(User user, Map<Product, Integer> orderDetails){
        int orderId = orders.size() + 1;
        Order order = new Order(orderId, user.getId());
        order.setOrderDetails(orderDetails);
        order.calculateTotalPrice();
        orders.put(orderId, order);

        for(Map.Entry<Product, Integer> entry : orderDetails.entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            int remainingStock = product.getStock() - quantity;
            product.setStock(remainingStock);
        }

        user.getCart().clear();
    }

    public void displayAvailableProducts(){
        for(Product product : products.values()){
            System.out.println(product);
        }
    }
    public void displayUsers(){
        for(User user : users.values()){
            System.out.println(user);
        }
    }
    public void displayOrders(){
        for(Order order : orders.values()){
            System.out.println(order);
        }
    }

    public void updateProductStock(int productId, int newStock){
        if(products.containsKey(productId)){
            Product product = products.get(productId);
            product.setStock(newStock);
        } else if (newStock < 0){
            System.out.println("Quantity can not be a negative number!");
        }
        else {
            System.out.println("Product with ID " + productId + " not found!");
        }
    }
}
