package ies.carrillo.ishoppingcartfca.dataBase;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ies.carrillo.ishoppingcartfca.models.Product;

public class DataBase {
    public static List<Product> products = new ArrayList<>();


    public static List<Product> getProducts() {

        return products;
    }

    public static void setProducts(List<Product> products) {
        DataBase.products = products;

    }

    public static void fillList() {

        if(products.isEmpty()) {

            Product p1 = new Product();
            Product p2 = new Product();
            Product p3 = new Product();

            p1.setName("car");
            p1.setNote("Small toy car");
            p1.setId(generateId());

            p2.setName("Eggs");
            p2.setNote("a pack of eggs");
            p2.setBuy(true);
            p2.setId(generateId());

            p3.setName("Hello kitty T-shirt");
            p3.setNote("a hell kitten shirt for kids");
            p3.setBuy(true);
            p3.setId(generateId());

            products.add(p1);
            products.add(p2);
            products.add(p3);

            for (int i = 0; i < 10; i++) {
                Product p4 = new Product();
                p4.setName("toy " + i);
                p4.setNote("A toy for kids");
                p4.setBuy(true);
                p4.setId(generateId());
                products.add(p4);
            }
        }else {
            Log.i("DataBase", "DataBase already filled");
        }

    }

    public static int generateId() {
        int id = 0;
        for (Product p : products) {
            if (p.getId() > id) {
                id = p.getId();
            }
        }
        return id+1;
    }

    /*   public static ArrayList<Product> getProductsToBuy(ArrayList<Product> products) {
           ArrayList<Product> productsToBuy = new ArrayList<>();
           for (Product p : products)
               if (p.isBuy()) {
                   productsToBuy.add(p);
               }
           return productsToBuy;
       }*/
    public static List<Product> getProductsDiferentsToBuy(List<Product> products) {
        List<Product> productsDiferentsToBuy = new ArrayList<>();
        for (Product p : products) {
            if (p.isBuy()) {
                productsDiferentsToBuy.add(p);
            }
        }
        return productsDiferentsToBuy;
    }
}
