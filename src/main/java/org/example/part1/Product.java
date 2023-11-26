package org.example.part1;
import java.util.Comparator;

public class Product implements Comparable<Product>{
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
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    @Override
    public String toString(){
        return "id: " + id + ", name: " + name + ", price: " + price + ", stock: " + stock;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }
    public static class NameComparator implements Comparator<Product>{
        @Override
        public int compare(Product product1, Product product2){
            return product1.getName().compareTo(product2.getName());
        }
    }
    public static class StockComparator implements Comparator<Product>{
        @Override
        public int compare(Product product1, Product product2){
            return Integer.compare(product1.getStock(), product2.getStock());
        }
    }
}
