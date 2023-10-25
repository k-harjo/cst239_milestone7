package storeFront;

import inventoryManager.InventoryManager;
import shoppingCart.ShoppingCart;
import salableProduct.SalableProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a StoreFront which holds inventory and handles purchase transactions.
 */
public class StoreFront {

    // Inventory manager to manage the products in the store
    private InventoryManager inventoryManager;

    // List to hold the shopping carts
    private List<ShoppingCart<SalableProduct>> shoppingCarts = new ArrayList<>();

    /**
     * Constructs a StoreFront with an associated InventoryManager.
     */
    public StoreFront() {
        inventoryManager = new InventoryManager(this);
    }

    /**
     * @return The InventoryManager associated with this StoreFront.
     */
    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    /**
     * Handles purchasing products and adding them to the provided shopping cart.
     * Updates product quantities and prints relevant messages to the console.
     * 
     * @param product  The product to be purchased.
     * @param cart     The shopping cart to which the product is to be added.
     * @param quantity The quantity of the product to purchase.
     */
    public void purchaseProduct(SalableProduct product, ShoppingCart<SalableProduct> cart, int quantity) {
        if (inventoryManager.getProductList().contains(product)) {
            if (product.getQuantity() >= quantity) {
                cart.addProduct(product, quantity);
                product.setQuantity(product.getQuantity() - quantity);
                System.out.println("Product purchased: " + product.getName());
            } else {
                System.out.println("Insufficient quantity in inventory for: " + product.getName());
            }
        } else {
            System.out.println("Product not found in inventory: " + product.getName());
        }
    }

    /**
     * Cancels the purchase of the products, removing them from the cart
     * and returning them to the inventory.
     * 
     * @param product  The product whose purchase is to be canceled.
     * @param cart     The shopping cart from which the product is to be removed.
     * @param quantity The quantity of the product to cancel.
     */
    public void cancelPurchase(SalableProduct product, ShoppingCart<SalableProduct> cart, int quantity) {
        if (cart.getCartItems().contains(product)) {
            int cartQuantity = cart.getQuantityInCart(product);
            if (cartQuantity >= quantity) {
                cart.removeProduct(product, quantity);
                product.setQuantity(product.getQuantity() + quantity);
                System.out.println("Purchase canceled, product returned to inventory: " + product.getName());
            } else {
                System.out.println("Insufficient quantity in cart for: " + product.getName());
            }
        } else {
            System.out.println("Product not found in cart: " + product.getName());
        }
    }

    /**
     * Sorts the product list by name in ascending order.
     */
    public void sortProductsByNameAscending() {
        Collections.sort(inventoryManager.getProductList());
    }

    /**
     * Sorts the product list by name in descending order.
     */
    public void sortProductsByNameDescending() {
        Comparator<SalableProduct> nameComparator = Comparator.comparing(SalableProduct::getName, String.CASE_INSENSITIVE_ORDER).reversed();
        inventoryManager.getProductList().sort(nameComparator);
    }

    /**
     * Sorts the product list by price in ascending order.
     */
    public void sortProductsByPriceAscending() {
        Comparator<SalableProduct> priceComparator = Comparator.comparing(SalableProduct::getPrice);
        inventoryManager.getProductList().sort(priceComparator);
    }

    /**
     * Sorts the product list by price in descending order.
     */
    public void sortProductsByPriceDescending() {
        Comparator<SalableProduct> priceComparator = Comparator.comparing(SalableProduct::getPrice).reversed();
        inventoryManager.getProductList().sort(priceComparator);
    }
}
