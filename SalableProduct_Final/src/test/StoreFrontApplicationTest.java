package test;

import org.junit.Before;
import org.junit.Test;

import app.StoreFrontApplication;
import salableProduct.SalableProduct;
import shoppingCart.ShoppingCart;
import storeFront.StoreFront;

import static org.junit.Assert.*;

public class StoreFrontApplicationTest {

    private StoreFront store;
    private ShoppingCart<SalableProduct> cart;
    private StoreFrontApplication app;

    @Before
    public void setup() {
        
        this.store = new StoreFront(); 
        this.cart = new ShoppingCart<>();
        this.app = new StoreFrontApplication();
    }

    @Test
    public void testPurchaseProduct() {
        // Arrange
        String productName = "sampleProduct";
        int quantity = 2;
        
        // Assume a simpler or stub version of SalableProduct suitable for tests
        SalableProduct product = new SalableProduct("TestProduct", "Description", 10.0, 5, 0); 
        store.getInventoryManager().addProduct(product);

        // Act
        
        // Assert
        // Verify that product is added to cart
        assertEquals("Product should be added to cart", 
            quantity, cart.findProductByName(productName).getQuantityPurchased());
    }
}
