package ies.carrillo.ishoppingcartfca.dataBase;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ies.carrillo.ishoppingcartfca.models.Product;

public class DataBase {
    // Static list to hold Product objects
    public static List<Product> products = new ArrayList<>();

    /**
     * Method to get the list of products
     *
     * @return List of Product objects
     */
    public static List<Product> getProducts() {
        return products; // Return the list of products
    }

    /**
     * Method to set a new list of products
     *
     * @param products List of Product objects to set
     */
    public static void setProducts(List<Product> products) {
        DataBase.products = products; // Update the products list with the new list
    }

    /**
     * Method to fill the products list with initial data
     * This method adds some default Product objects to the list if it's empty
     */
    public static void fillList() {
        // Check if the products list is empty
        if (products.isEmpty()) {
            // Create sample Product objects
            Product p1 = new Product();
            Product p2 = new Product();
            Product p3 = new Product();

            // Set properties for the first product
            p1.setName("car");
            p1.setNote("Small toy car");
            p1.setLactose(true);
            p1.setGluten(false);
            p1.setId(generateId()); // Generate a unique ID

            // Set properties for the second product
            p2.setName("Eggs");
            p2.setNote("A pack of eggs");
            p2.setLactose(true);
            p2.setGluten(false);
            p2.setBuy(true); // Mark this product as a buy item
            p2.setId(generateId()); // Generate a unique ID

            // Set properties for the third product
            p3.setName("Hello kitty T-shirt");
            p3.setNote("A Hello Kitty shirt for kids");
            p3.setLactose(false);
            p3.setGluten(true);
            p3.setBuy(true); // Mark this product as a buy item
            p3.setId(generateId()); // Generate a unique ID

            // Add the sample products to the products list
            products.add(p1);
            products.add(p2);
            products.add(p3);

            // Create additional toy products in a loop
            for (int i = 0; i < 10; i++) {
                Product p4 = new Product();
                p4.setName("Survival food " + i);
                if (i % 2 == 0) {
                    p4.setGluten(true);
                    p4.setLactose(false);
                    p4.setBuy(false); // Mark this product as a buy item
                } else {
                    p4.setGluten(false);
                    p4.setLactose(true);
                    p4.setBuy(true); // Mark this product as a buy item
                }

                p4.setNote("Liofilized food for real survivors like Jacob");
                p4.setId(generateId()); // Generate a unique ID
                products.add(p4); // Add the product to the list
            }
        } else {
            Log.i("DataBase", "DataBase already filled"); // Log a message if the database is already filled
        }
    }

    /**
     * Method to generate a unique ID for new products
     *
     * @return A unique integer ID
     */
    public static int generateId() {
        int id = 0; // Initialize the ID variable
        // Iterate through the list of products to find the highest existing ID
        for (Product p : products) {
            if (p.getId() > id) {
                id = p.getId(); // Update the ID if a higher one is found
            }
        }
        return id + 1; // Return the next available ID
    }

    /**
     * Method to get a list of products marked for purchase
     *
     * @param products List of Product objects to filter
     * @return List of products that are marked as buy items
     */
    public static List<Product> getProductsDiferentsToBuy(List<Product> products) {
        List<Product> productsDiferentsToBuy = new ArrayList<>(); // List to hold products to buy
        // Iterate through the provided list and add buy-marked products to the new list
        for (Product p : products) {
            if (p.isBuy()) {
                productsDiferentsToBuy.add(p); // Add the product to the list if it's marked for buying
            }
        }
        return productsDiferentsToBuy; // Return the filtered list
    }

    /**
     * Method to get a list of products with lactose
     *
     * @param products List of Product objects to filter
     * @return List of products with lactose
     */
    public static List<Product> getProductsWithLactose(List<Product> products) {
        List<Product> productsWithLactose = new ArrayList<>(); // List to hold products with lactose
        for (Product p : products) {
            if (p.isLactose()) {
                productsWithLactose.add(p);
            }
        }
        return productsWithLactose;
    }

    /**
     * Method to get a list of products with gluten
     *
     * @param products List of Product objects to filter
     * @return List of products with gluten
     */
    public static List<Product> getProductsWithGluten(List<Product> products) {
        List<Product> productsWithGluten = new ArrayList<>(); // List to hold products with lactose
        for (Product p : products) {
            if (p.isGluten()) {
                productsWithGluten.add(p);
            }
        }
        return productsWithGluten;
    }
}

