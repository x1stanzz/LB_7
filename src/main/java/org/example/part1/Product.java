package org.example.part1;

public class Product {
    private Integer id;
    private String name;
    private double price;
    private int stock;
    public Product(int id, String name, double price, int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    int getId(){
        return id;
    }
    String getName(){
        return name;
    }
    double getPrice(){
        return price;
    }
    int getStock(){
        return stock;
    }
    @Override
    public String toString(){
        return "id: " + id + ", name: " + name + ", price: " + price + ", stock: " + stock;
    }
}
