package ies.carrillo.ishoppingcartfca.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ies.carrillo.ishoppingcartfca.R;
import ies.carrillo.ishoppingcartfca.adapters.ProductAdapter;
import ies.carrillo.ishoppingcartfca.models.Product;
import ies.carrillo.ishoppingcartfca.dataBase.DataBase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Just like Hello Kitty loves her friends, we love a full-screen experience!
        setContentView(R.layout.activity_main); // Setting up our cute main screen!

        // Adjusting the layout for a cozy fit, just like Hello Kitty snuggles in her favorite spot!
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; // We want everything to be just right, like a perfectly styled bow!
        });

        DataBase.fillList(); // Filling our product list, just like filling a cupcake with yummy frosting!
        loadingComponents(); // Time to load all the fun stuff, just like Hello Kitty loves her adventures!
    }

    private void loadingComponents() {
        // Preparing our intents to navigate, like choosing which bow to wear for the day!
        Intent seeDetails = new Intent(MainActivity.this, DetailsActivity.class);
        Intent addWaitList = new Intent(MainActivity.this, AddProductToWaitListActivity.class);
        Intent addProduct = new Intent(MainActivity.this, AddProductActivity.class);

        // Buttons to add products and view waitlist, as cute as Hello Kitty's friends!
        Button btnWaitList = findViewById(R.id.btnAddWaitngList);
        Button btnAddProduct = findViewById(R.id.btnAddProduct);

        // Setting up our adorable product list view!
        ListView lvProducts = findViewById(R.id.lvProducts);
        Log.i("List", DataBase.getProducts().toString());
        ProductAdapter productAdapter = new ProductAdapter(MainActivity.this, 0, DataBase.getProducts());
        lvProducts.setAdapter(productAdapter); // Adapting our products like Hello Kitty adapts to new friends!

        // Click listener for the product items, just like choosing which treat to share!
        lvProducts.setOnItemClickListener((parent, view, position, id) -> {
            Product p = (Product) parent.getItemAtPosition(position);
            Log.i("Product", p.toString());
            seeDetails.putExtra("product", p); // Sending the selected product, just like sharing secrets with friends!
            startActivity(seeDetails); // Let's see the details, just like uncovering a mystery in a fun story!
        });

        // Setting up click listeners for our buttons, just like organizing a cute tea party!
        btnWaitList.setOnClickListener(v -> startActivity(addWaitList)); // Adding to the waitlist, as sweet as a cupcake!

        btnAddProduct.setOnClickListener(v -> {
            Log.i("Changing to add Product Activity", "Changing to add Product Activity"); // Time to add a new friend!
            startActivity(addProduct); // Let's add a new product, just like adding a new charm to Hello Kitty's collection!
        });
    }
}
