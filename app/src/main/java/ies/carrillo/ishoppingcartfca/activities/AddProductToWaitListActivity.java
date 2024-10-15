package ies.carrillo.ishoppingcartfca.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ies.carrillo.ishoppingcartfca.R;
import ies.carrillo.ishoppingcartfca.adapters.ProductAdapter;
import ies.carrillo.ishoppingcartfca.models.Product;
import ies.carrillo.ishoppingcartfca.dataBase.DataBase;

public class AddProductToWaitListActivity extends AppCompatActivity {
    private Intent cancel; // Intent to navigate back to the main activity
    private Spinner productSpinner; // Spinner to select a product
    private ProductAdapter productAdapterSpinner; // Adapter for the product spinner
    private Button btnCancelFromAPWL; // Button to cancel the action
    private Button btnAddToWaitList; // Button to add product to the wait list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Like how 'Edge of Tomorrow' lets you start fresh, we're setting up our activity
        setContentView(R.layout.activity_add_product_to_wait_list); // Set the layout for this activity

        // Set up window insets to handle system UI elements, just like a superhero navigates through chaos
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); // Padding adjustments for a better experience
            return insets;
        });

        loadingComponents(); // Load the UI components like assembling the Justice League
    }

    private void loadingComponents() {
        // Prepare the cancel intent to return to MainActivity
        cancel = new Intent(AddProductToWaitListActivity.this, MainActivity.class);

        // Initialize the product spinner with available products, like choosing your favorite Pokémon
        productSpinner = findViewById(R.id.spinner);
        productAdapterSpinner = new ProductAdapter(AddProductToWaitListActivity.this, 0, DataBase.getProductsDiferentsToBuy(DataBase.getProducts()));
        productSpinner.setAdapter(productAdapterSpinner); // Set the adapter to the spinner

        // Button to cancel the action, just like how every hero needs an exit strategy
        btnCancelFromAPWL = findViewById(R.id.btnCancelFromAPWL);
        btnCancelFromAPWL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cancel); // Go back to the main activity
            }
        });

        // Button to add the selected product to the wait list, similar to how you queue up for the next Marvel movie
        btnAddToWaitList = findViewById(R.id.btnAddToWaitList);
        btnAddToWaitList.setOnClickListener(v -> addProductToWaitList((Product) productSpinner.getSelectedItem())); // Add selected product to wait list
    }

    private void addProductToWaitList(Product p) {
        // Set the product as not for buying, akin to how Harry Potter has to wait for his next adventure
        p.setBuy(false); // Mark product as not for purchase
        Toast.makeText(this, p.getName() + " has been added to the waitlist!", Toast.LENGTH_SHORT).show(); // Notify the user
    }
}
