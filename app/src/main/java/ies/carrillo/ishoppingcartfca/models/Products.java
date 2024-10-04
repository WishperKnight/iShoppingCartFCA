package ies.carrillo.ishoppingcartfca.models;

import java.util.ArrayList;

public class Products {
    public static ArrayList<Product> products = new ArrayList<>();


    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        Products.products = products;
    }

    public static void fillList() {

        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        p1.setName("car");
        p1.setNote("Small toy car");
        p1.setId(generateId());

        p2.setName("Eggs");
        p2.setName("Eggs");
        p2.setBuy(true);
        p2.setId(generateId());

        p3.setName("Hello kitty T-shirt");
        p3.setName("Hello kitty T-shirt");
        p3.setBuy(true);
        p3.setId(generateId());

        products.add(p1);
        products.add(p3);
        products.add(p3);
    }

    public static int generateId() {
        return products.size();
    }
}
