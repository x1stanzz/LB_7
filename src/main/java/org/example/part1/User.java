package org.example.part1;

import java.util.Map;

public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;
    public User (Integer id, String username){
        this.id = id;
        this.username = username;
        this.cart = cart;
    }

    Integer getId(){
        return id;
    }
    String getUsername(){
        return username;
    }
    Map<Product, Integer> getCart(){
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

}
