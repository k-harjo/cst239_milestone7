package test;

import org.junit.Before;
import org.junit.Test;

import inventoryManager.InventoryManager;
import salableProduct.SalableProduct;
import shoppingCart.ShoppingCart;
import storeFront.StoreFront;

import static org.junit.Assert.*;

public class StoreFrontTest {
    private StoreFront storeFront;
    private InventoryManager inventoryManager;
    private ShoppingCart<SalableProduct> cart;
    private SalableProduct product;

    @Before
    public void setUp() {
        storeFront = new StoreFront();
        inventoryManager = new InventoryManager(storeFront);
        cart = new ShoppingCart<>();
        product = new SalableProduct("TestProduct", "Description", 10.0, 5, 0);
        product.setName("TestProduct");
        product.setPrice(10.0);
        product.setQuantity(5);
    }

    @Test
    public void testPurchaseProduct() {
        inventoryManager.addProduct(product);
        storeFront.purchaseProduct(product, cart, 2);
        
        assertEquals(3, product.getQuantity());
        assertEquals(2, cart.getQuantityInCart(product));
    }
    
    @Test
    public void testCancelPurchase() {
        inventoryManager.addProduct(product);
        storeFront.purchaseProduct(product, cart, 2);
        storeFront.cancelPurchase(product, cart, 1);

        assertEquals(4, product.getQuantity());
        assertEquals(1, cart.getQuantityInCart(product));
    }

    @Test
    public void testSortProductsByNameAscending() {
        // You will have to add some more products to inventoryManager
        // Then call storeFront.sortProductsByNameAscending();
        // And then assert whether the productList in inventoryManager is sorted in the expected order.
    }

    // Similarly, write tests for other sort methods
}
