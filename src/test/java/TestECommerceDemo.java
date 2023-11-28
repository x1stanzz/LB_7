import org.example.Exceptions.OutOfStockException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.part1.*;
import org.example.part2.ECommercePlatform;
public class TestECommerceDemo {
    private User user1;
    private User user2;
    private Product product1;
    private Product product2;
    private Product product3;
    ECommercePlatform platform;
    @BeforeEach
    public void setUp(){
        user1 = new User(1, "Charlie Evans");
        user2 = new User(2, "Sara Craig");
        product1 = new Product(1, "Laptop", 800.00, 20);
        product2 = new Product(2, "Keyboard", 100.00, 25);
        product3 = new Product(3, "Headphones", 150.00, 15);
        platform = new ECommercePlatform();
        platform.addUser(user1);
        platform.addUser(user2);
        platform.addProduct(product1);
        platform.addProduct(product2);
        platform.addProduct(product3);
    }
    @Test
    public void testAddToCartSufficientStock() throws OutOfStockException {
        user1.addToCart(product1, 5);
        Assertions.assertEquals(5, user1.getCart().get(product1).intValue());
    }
    @Test
    public void testAddToCartInsufficientStock() throws OutOfStockException{
        try {
            user1.addToCart(product1, 50);
        } catch (OutOfStockException e) {
            Assertions.assertEquals("Not enough stock available", e.getMessage());
        }
    }
    @Test
    public void testRemoveFromCartExistingProduct() throws OutOfStockException {
        user1.addToCart(product1, 4);
        user1.removeFromCart(product1);
        Assertions.assertNull(user1.getCart().get(product1));
    }
    @Test
    public void testRemoveFromCartNonExistingProduct() {
        user1.removeFromCart(product1);
        Assertions.assertNull(user1.getCart().get(product1));
    }
    @Test
    public void testCreateOrder() throws OutOfStockException {
        user1.addToCart(product1, 7);
        user1.addToCart(product2, 3);

        int initialStock1 = product1.getStock();
        int initialStock2 = product2.getStock();

        platform.createOrder(user1);

        Assertions.assertEquals(0, user1.getCart().size());
        Assertions.assertEquals(1, platform.getOrders().size());
        Assertions.assertEquals(initialStock1 - 7, product1.getStock());
        Assertions.assertEquals(initialStock2 - 3, product2.getStock());
    }

    @Test
    public void testUpdateProductStock(){
        platform.updateProductStock(1, 40);
        Assertions.assertEquals(40, product1.getStock());
    }

    @Test
    public void testUpdateProductStockNegativeQuantity(){
        try {
            platform.updateProductStock(1, -12);
        } catch (IllegalArgumentException e){
            Assertions.assertEquals("Quantity can not be a negative number!", e.getMessage());
            Assertions.assertEquals(20, product1.getStock());
        }
    }
    @Test
    public void testUpdateProductStockNonExistingProduct() {
        int productId = 10;
        try {
            platform.updateProductStock(productId, 5);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Product with ID " + productId + " not found!", e.getMessage());
        }
    }
}
