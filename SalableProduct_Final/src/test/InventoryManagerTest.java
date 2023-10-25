package test; 

import org.junit.Before;
import org.junit.Test;

import inventoryManager.InventoryManager;
import salableProduct.SalableProduct;
import storeFront.StoreFront;

import static org.junit.Assert.*;

public class InventoryManagerTest {
    
    private InventoryManager inventoryManager;
    private StoreFront storeFront;
    
    @Before
    public void setUp() {
        // Initialize or Mock StoreFront and InventoryManager instance before each test
        storeFront = new StoreFront(); // Assuming StoreFront has a suitable default constructor
        inventoryManager = new InventoryManager(storeFront);
    }
    
    @Test
    public void testAddProduct() {
        SalableProduct product = new SalableProduct("TestProduct", "Description", 10.0, 5, 0); // Initialize or Mock SalableProduct
        inventoryManager.addProduct(product);
        
        // Check whether the added product is present in the productList
        assertTrue(inventoryManager.getProductList().contains(product));
    }
    
    @Test
    public void testFindProductByName() {
        SalableProduct product = new SalableProduct("TestProduct", "Description", 10.0, 5, 0); // Initialize or Mock SalableProduct
        product.setName("TestProduct"); // Assuming setName method is present in SalableProduct class
        inventoryManager.addProduct(product);
        
        // Check whether the correct product is returned
        assertEquals(product, inventoryManager.findProductByName("TestProduct"));
    }
    
    @Test
    public void testLoadInventoryFromJsonFile() {
        // Assuming there is a JSON file "testInventory.json" with known content
        inventoryManager.loadInventoryFromJsonFile("testInventory.json");
        
        // Asserts to check whether the productList has been loaded correctly
        // This may involve checking the size of the productList and/or whether
        // the productList contains expected products.
    }
    
    @Test
    public void testSaveInventoryToJsonFile() {
        // Here, you can add some products to inventoryManager and then call
        // saveInventoryToJsonFile() method, and finally check whether the file
        // has been created successfully and contains the expected content.
    }
    
    // Similar detailed tests can be created for other methods of InventoryManager
}
