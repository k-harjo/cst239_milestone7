package test;

import org.junit.Before;
import org.junit.Test;

import salableProduct.SalableProduct;
import shoppingCart.ShoppingCart;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    
    private ShoppingCart<SalableProduct> shoppingCart;
    
    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart<>();
    }

    @Test
    public void testAddProduct() {
        SalableProduct product = new SalableProduct("TestProduct", "Description", 10.0, 5, 0);
        shoppingCart.addProduct(product, 2);

        assertEquals(20.0, shoppingCart.getTotalPrice(), 0.0); 
        assertEquals(2, shoppingCart.getQuantityInCart(product));
    }
    
    @Test
    public void testRemoveProduct() {
        SalableProduct product = new SalableProduct("TestProduct", "Description", 10.0, 5, 0); // Replace with actual instance
        product.setPrice(10.0); // Set product price
        shoppingCart.addProduct(product, 3);
        shoppingCart.removeProduct(product, 1);
        
        assertEquals(20.0, shoppingCart.getTotalPrice(), 0.0); // Check total price
        assertEquals(2, shoppingCart.getQuantityInCart(product)); // Check quantity
    }
    
    @Test
    public void testTotalPrice() {
        SalableProduct product1 = new SalableProduct("TestProduct", "Description", 10.0, 5, 0); // Replace with actual instance
        product1.setPrice(10.0); // Set product price

        SalableProduct product2 = new SalableProduct("TestProduct", "Description", 10.0, 5, 0); // Replace with actual instance
        product2.setPrice(20.0); // Set product price
        
        shoppingCart.addProduct(product1, 1);
        shoppingCart.addProduct(product2, 1);

        assertEquals(30.0, shoppingCart.getTotalPrice(), 0.0); // Check total price
    }
    
    @Test
    public void testFindProductByName() {
        SalableProduct product = new SalableProduct("TestProduct", "Description", 10.0, 5, 0); // Replace with actual instance
        product.setName("TestProduct"); // Assuming setName method is present in SalableProduct class
        shoppingCart.addProduct(product, 1);
        
        // Check whether the correct product is returned
        assertEquals(product, shoppingCart.findProductByName("TestProduct"));
    }

    @Test
    public void testGetCartItems() {
        // Here you can add some products to shoppingCart
        // and then call getCartItems() method, 
        // and finally check whether it returns the expected list of products.
    }

    @Test
    public void testClearCart() {
        SalableProduct product = new SalableProduct("TestProduct", "Description", 10.0, 5, 0); // Replace with actual instance
        shoppingCart.addProduct(product, 1);
        shoppingCart.clearCart();
        
        assertEquals(0.0, shoppingCart.getTotalPrice(), 0.0); // Check total price
        assertTrue(shoppingCart.getCartItems().isEmpty()); // Check if cart is empty
    }
}
