package org.example;
import org.example.Exceptions.OutOfStockException;
import org.example.part1.*;
import org.example.part2.ECommercePlatform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EcommerceDemo {
    public static void main(String[] main) throws OutOfStockException {
        ECommercePlatform platform = new ECommercePlatform();
        User user1 = new User(1, "Paul Davies");
        User user2 = new User(2, "Kat Morgan");
        User user3 = new User(3, "Victor Blanco");
        platform.addUser(user1);
        platform.addUser(user2);
        platform.addUser(user3);

        Product product1 = new Product(1, "Headphones", 100.0, 30);
        Product product2 = new Product(2, "Microphone", 55.0, 20);
        Product product3 = new Product(3, "Laptop", 800.0, 15);
        platform.addProduct(product1);
        platform.addProduct(product2);
        platform.addProduct(product3);

        System.out.println("Available Products: ");
        platform.displayAvailableProducts();

        user1.addToCart(product1, 3);
        user1.addToCart(product2, 2);
        user2.addToCart(product3, 5);
        user3.addToCart(product3, 4);

        user3.modifyCart(product3, 2);
        user2.removeFromCart(product3);

        platform.createOrder(user1);
        platform.createOrder(user2);
        platform.createOrder(user3);

        platform.updateProductStock(3, 12);

        System.out.println("Available Products: ");
        platform.displayAvailableProducts();

        System.out.println("Users: ");
        platform.displayUsers();

        System.out.println("Orders: ");
        platform.displayOrders();

        platform.displayProductsByName();
        platform.displayProductsByStock();
        platform.displayProductsByPrice();
        platform.displaySortedAvailableProducts();

        platform.updateProductStock(2, -2);
        System.out.println("Available Products: ");
        platform.displayAvailableProducts();
        platform.updateProductStock(4, 10);
        System.out.println("Available Products: ");
        platform.displayAvailableProducts();
        platform.updateProductStock(3, 15);
        System.out.println("Available Products: ");
        platform.displayAvailableProducts();

    }

}
