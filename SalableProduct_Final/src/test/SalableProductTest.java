package test;

import static org.junit.Assert.*;

import org.junit.Test;

import salableProduct.SalableProduct;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalableProductTest {
    private SalableProduct product;

    @Before
    public void setUp() {
        product = new SalableProduct("TestProduct", "Description", 10.0, 5, 0);
    }

    @Test
    public void testGetName() {
        assertEquals("TestProduct", product.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Description", product.getDescription());
    }

    @Test
    public void testGetPrice() {
        assertEquals(10.0, product.getPrice(), 0.0);
    }

    @Test
    public void testGetQuantity() {
        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testGetQuantityPurchased() {
        assertEquals(0, product.getQuantityPurchased());
    }

    @Test
    public void testSetters() {
        product.setName("NewName");
        product.setDescription("NewDescription");
        product.setPrice(20.0);
        product.setQuantity(10);
        product.setQuantityPurchased(2);

        assertEquals("NewName", product.getName());
        assertEquals("NewDescription", product.getDescription());
        assertEquals(20.0, product.getPrice(), 0.0);
        assertEquals(10, product.getQuantity());
        assertEquals(2, product.getQuantityPurchased());
    }

    @Test
    public void testCompareTo() {
        SalableProduct otherProduct = new SalableProduct("testproduct", "Description", 10.0, 5, 0);
        assertEquals(0, product.compareTo(otherProduct));
    }

    @Test
    public void testToString() {
        String expectedString = "Name: TestProduct, Description: Description, Price: $10.0, Quantity: 5, Quantity Purchased: 0";
        assertEquals(expectedString, product.toString());
    }
}
