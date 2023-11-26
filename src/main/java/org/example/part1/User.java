package org.example.part1;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;
    public User (Integer id, String username){
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public Integer getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public Map<Product, Integer> getCart(){
        return cart;
    }
    public void addToCart(Product product, int quantity){
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeFromCart(Product product, int quantity){
        cart.put(product, cart.getOrDefault(product, 0) - quantity);
        cart.remove(product);
    }
    public void modifyCart(Product product, int newQuantity){
        cart.put(product, newQuantity);
    }
    public Map<Product, Integer> getCartCopy() {
        return new HashMap<>(cart);
    }
    @Override
    public String toString(){
        return "id: " + id + ", username: " + username;
    }
}
