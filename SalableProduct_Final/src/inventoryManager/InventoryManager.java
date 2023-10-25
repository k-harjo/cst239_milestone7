package inventoryManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import salableProduct.SalableProduct;
import storeFront.StoreFront;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manages the inventory of SalableProducts.
 * Provides methods to add products, load and save inventory data to and from a JSON file, and sort products.
 */
public class InventoryManager {
    // List to store all the SalableProducts
    private List<SalableProduct> productList = new ArrayList<>();
    
    // Reference to the StoreFront to which this InventoryManager belongs
    private StoreFront storeFront;

    /**
     * Constructor to initialize with a StoreFront object and instantiate productList.
     * @param storeFront StoreFront object to which this InventoryManager belongs.
     */
    public InventoryManager(StoreFront storeFront) {
        this.storeFront = storeFront;
        this.productList = new ArrayList<>();
    }

    /**
     * Adds a SalableProduct to the productList.
     * @param product The product to be added.
     */
    public void addProduct(SalableProduct product) {
        productList.add(product);
    }

    /**
     * @return The list of all SalableProducts in the inventory.
     */
    public List<SalableProduct> getProductList() {
        return productList;
    }

    /**
     * Finds a SalableProduct in the inventory by name.
     * @param productName The name of the product to be found.
     * @return The found SalableProduct, or null if not found.
     */
    public SalableProduct findProductByName(String productName) {
        for (SalableProduct product : productList) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Loads inventory data from a JSON file using a separate thread.
     * Deserializes JSON data into a list of SalableProduct objects and clears the existing inventory before adding the loaded products.
     * @param filePath The path to the JSON file.
     */
    public void loadInventoryFromJsonFile(String filePath) {
        Thread loadInventoryThread = new Thread(() -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                SalableProduct[] loadedProducts = objectMapper.readValue(new File(filePath), SalableProduct[].class);
                productList.clear();
                Collections.addAll(productList, loadedProducts);
            } catch (JsonParseException | JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        loadInventoryThread.start();
    }

    /**
     * Saves inventory data to a JSON file using a separate thread.
     * Serializes the list of SalableProduct objects to JSON and writes to the file with pretty printing.
     * @param filePath The path to the JSON file.
     */
    public void saveInventoryToJsonFile(String filePath) {
        Thread saveInventoryThread = new Thread(() -> {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            try {
                objectMapper.writeValue(new File(filePath), productList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        saveInventoryThread.start();
    }

    // Methods to sort productList based on name or price in ascending or descending order.
    public void sortProductsByNameAscending() {
        productList.sort(Comparator.comparing(SalableProduct::getName, String.CASE_INSENSITIVE_ORDER));
    }

    public void sortProductsByNameDescending() {
        productList.sort(Collections.reverseOrder(Comparator.comparing(SalableProduct::getName, String.CASE_INSENSITIVE_ORDER)));
    }

    public void sortProductsByPriceAscending() {
        productList.sort(Comparator.comparing(SalableProduct::getPrice));
    }

    public void sortProductsByPriceDescending() {
        productList.sort(Collections.reverseOrder(Comparator.comparing(SalableProduct::getPrice)));
    }
}
