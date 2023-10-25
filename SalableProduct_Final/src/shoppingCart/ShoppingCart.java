package shoppingCart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import salableProduct.SalableProduct;

/**
 * Represents a shopping cart that can hold salable products.
 * Provides methods for adding and removing products, 
 * as well as retrieving cart details like total price and quantity of products.
 *
 * @param <T> Type parameter bounded by SalableProduct class.
 */
public class ShoppingCart<T extends SalableProduct> {

    // Map to hold the cart items and their quantities
    private Map<T, Integer> cartItems = new HashMap<>();
    
    // Variable to maintain the running total of item prices in the cart
    private double totalPrice = 0.0;

    /**
     * Adds a specified quantity of a product to the cart.
     * Updates the total price and prints the updated cart details.
     *
     * @param product  The product to be added.
     * @param quantity The quantity of the product to be added.
     */
    public synchronized void addProduct(T product, int quantity) {
        int currentQuantity = cartItems.getOrDefault(product, 0);
        cartItems.put(product, currentQuantity + quantity);
        totalPrice += product.getPrice() * quantity;
        product.setQuantityPurchased(product.getQuantityPurchased() + quantity);
        System.out.println("Added " + quantity + " " + product.getName() + " to cart. Total price: $" + String.format("%.2f", totalPrice));
    }

    /**
     * Removes a specified quantity of a product from the cart.
     * Updates the total price and prints the updated cart details.
     *
     * @param product  The product to be removed.
     * @param quantity The quantity of the product to be removed.
     */
    public synchronized void removeProduct(T product, int quantity) {
        if (cartItems.containsKey(product)) {
            int currentQuantity = cartItems.get(product);
            if (currentQuantity > quantity) {
                cartItems.put(product, currentQuantity - quantity);
                totalPrice -= product.getPrice() * quantity;
                System.out.println("Removed " + quantity + " " + product.getName() + " from cart. Total price: $" + String.format("%.2f", totalPrice));
            } else if (currentQuantity == quantity) {
                cartItems.remove(product);
                totalPrice -= product.getPrice() * quantity;
                System.out.println("Removed " + quantity + " " + product.getName() + " from cart. Total price: $" + String.format("%.2f", totalPrice));
            } else {
                System.out.println("Invalid quantity to remove.");
            }
        }
    }

    /**
     * @return The total price of all products in the cart.
     */
    public synchronized double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Retrieves the quantity of a specified product in the cart.
     *
     * @param product The product whose quantity is to be retrieved.
     * @return The quantity of the specified product in the cart.
     */
    public synchronized int getQuantityInCart(T product) {
        return cartItems.getOrDefault(product, 0);
    }
    
    /**
     * Finds a product in the cart by name.
     *
     * @param productName The name of the product to find.
     * @return The found product, or null if not found.
     */
    public synchronized T findProductByName(String productName) {
        for (T product : cartItems.keySet()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
    
    /**
     * @return A sorted list of all products in the cart.
     */
    public synchronized List<T> getCartItems() {
        List<T> items = new ArrayList<>(cartItems.keySet());
        items.sort(Comparator.comparing(SalableProduct::getName, String.CASE_INSENSITIVE_ORDER));
        return items;
    }

    /**
     * Empties the cart and resets the total price.
     */
    public synchronized void clearCart() {
        cartItems.clear();
        totalPrice = 0.0;
        System.out.println("Shopping Cart has been emptied.");
    }
}
