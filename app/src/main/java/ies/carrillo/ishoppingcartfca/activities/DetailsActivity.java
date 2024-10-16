package ies.carrillo.ishoppingcartfca.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ies.carrillo.ishoppingcartfca.R;
import ies.carrillo.ishoppingcartfca.models.Product;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Like how 'Edge of Tomorrow' redefines boundaries, we enable edge-to-edge display
        setContentView(R.layout.activity_details); // Set the layout for the details activity

        // Handle window insets to give a proper layout experience, just like a good superhero knows their space
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; // Return the insets to keep our layout on point
        });

        loadingComponents(); // Load UI components like assembling the Avengers
    }

    private void loadingComponents() {
        // Prepare intents for navigation, like getting your plot points ready
        Intent cancel = new Intent(DetailsActivity.this, MainActivity.class); // Intent to go back
        Intent edit = new Intent(DetailsActivity.this, EditProductActivity.class); // Intent to edit product
        Intent data = getIntent(); // Get the incoming intent

        // Initialize UI components, akin to how the Justice League gathers for a mission
        Button btnBack = findViewById(R.id.btnBack);
        Button btnEdit = findViewById(R.id.btnEdit);
        TextView tvId = findViewById(R.id.tvID);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvShortNote = findViewById(R.id.tvShortNote);
        TextView tvState = findViewById(R.id.tvState);
        TextView tvLactose = findViewById(R.id.tvLactose);
        TextView tvGluten = findViewById(R.id.tvGluten);

        // Retrieve the product from the intent, like finding the hidden treasure in a pirate movie
        Product p = (Product) data.getSerializableExtra("product");
        Log.i("Product", p.toString()); // Log the product for debugging, like a behind-the-scenes featurette

        // Set the product details in the TextViews, bringing the character to life on the screen
        tvId.setText("ID: " + String.valueOf(p.getId()));
        tvName.setText("Nombre: " + p.getName());
        tvShortNote.setText("Nota: " + p.getNote());
        tvState.setText(p.isBuy() ? "Comprar" : "No comprar"); // Display the product's state, as crucial as the "Chosen One" prophecy
        tvLactose.setText(p.isLactose() ? "have lactose" : "no have lactose"); // Display the product's state, as crucial as the "Chosen One" prophecy
        tvGluten.setText(p.isGluten() ? "Have gluten" : "No have gluten"); // Display the product's state, as crucial as the "Chosen One" prophecy

        // Set up button listeners
        btnBack.setOnClickListener(v -> startActivity(cancel)); // Go back to the main activity, like a classic movie wrap-up
        btnEdit.setOnClickListener(v -> {
            Product product = (Product) data.getSerializableExtra("product"); // Get product again for editing
            edit.putExtra("product", product); // Pass product to edit activity
            Log.i("Product to edit", product.toString()); // Log for debugging
            startActivity(edit); // Start the edit activity, like setting up for the sequel
        });
    }
}
