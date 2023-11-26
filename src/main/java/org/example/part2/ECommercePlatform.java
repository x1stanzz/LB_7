package org.example.part2;

import org.example.part1.*;

import java.util.*;

public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;
    public ECommercePlatform(){
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }
    public Map<Integer, User> getUsers(){
        return users;
    }
    public Map<Integer, Product> getProducts(){
        return products;
    }
    public Map<Integer, Order> getOrders(){
        return orders;
    }
    public void addUser(User user){
        users.put(user.getId(), user);
    }
    public void addProduct(Product product){
        products.put(product.getId(), product);
    }
    public void createOrder(User user){
        int orderId = orders.size() + 1;
        Map<Product, Integer> orderDetails = new HashMap<>(user.getCartCopy());
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
        if(products.containsKey(productId) & newStock >= 0){
            Product product = products.get(productId);
            product.setStock(newStock);
        } else if (newStock < 0){
            System.out.println("Quantity can not be a negative number!");
        }
        else {
            System.out.println("Product with ID " + productId + " not found!");
        }
    }
    public void displayProductsByName(){
        List<Product> sortedProducts = new ArrayList<>(getProducts().values());
        Collections.sort(sortedProducts, new Product.NameComparator());
        System.out.println("Products sorted by name: ");
        for(Product product : sortedProducts){
            System.out.println(product);
        }
    }
    public void displayProductsByPrice(){
        List<Product> sortedProducts = new ArrayList<>(getProducts().values());
        Collections.sort(sortedProducts);

        System.out.println("Products sorted by price: ");
        for(Product product : sortedProducts){
            System.out.println(product);
        }
    }
    public void displayProductsByStock(){
        List<Product> sortedProducts = new ArrayList<>(getProducts().values());
        Collections.sort(sortedProducts, new Product.StockComparator());

        System.out.println("Product sorted by stock:");
        for(Product product : sortedProducts){
            System.out.println(product);
        }
    }
    public void displaySortedAvailableProducts(){
        List<Product> availableProducts = new ArrayList<>();
        for(Map.Entry<Integer, Product> entry : getProducts().entrySet()){
            Product product = entry.getValue();
            if(product.getStock() > 0){
                availableProducts.add(product);
            }
        }
        System.out.println("Available products: ");
        for(Product product : availableProducts){
            System.out.println(product);
        }
    }
}
