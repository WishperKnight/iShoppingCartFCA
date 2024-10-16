package ies.carrillo.ishoppingcartfca.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ies.carrillo.ishoppingcartfca.R;
import ies.carrillo.ishoppingcartfca.dataBase.DataBase;
import ies.carrillo.ishoppingcartfca.models.Product;

public class AddProductActivity extends AppCompatActivity {

    private Switch isBuy; // The switch to determine if the product is a buy item
    private Switch isLactose; // The switch to determine if the product is a Lactose item
    private Switch isGluten; // The switch to determine if the product is a Gluten item
    private Button btnCancel; // Button to cancel the action
    private Button btnSave; // Button to save the product
    private EditText etName; // Input for the product name
    private EditText etNote; // Input for additional notes

    private Intent cancel; // Intent to navigate back to the main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Setting up our activity
        setContentView(R.layout.activity_add_product_activity); // Set the layout for this activity

        // Initialize views after setting the content view
        btnCancel = findViewById(R.id.btnCancelFromAP);
        btnSave = findViewById(R.id.btnSave);
        etName = findViewById(R.id.etName);
        etNote = findViewById(R.id.etShortNote);

        // Set up window insets for handling system UI elements
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.i("Add Product Activity", "Activity created"); // Logging for debugging
        loadingComponents(); // Load the components
    }

    private void loadingComponents() {
        // Prepare the cancel intent to go back to MainActivity
        cancel = new Intent(AddProductActivity.this, MainActivity.class);

        btnCancel.setOnClickListener(v -> startActivity(cancel)); // On click, cancel the action
        btnSave.setOnClickListener(v -> {
            Product p = addProduct(); // Create and add the product
            Log.i("Button pressed", "Product saving"); // Log saving action
            Log.i("Product added", p.toString()); // Log the product details
            startActivity(cancel); // Go back to the main activity
        });

        isBuy = findViewById(R.id.SwtToBuy); // Initialize the buy switch
        isLactose = findViewById(R.id.swtLactose); // Initialize the buy switch
        isGluten = findViewById(R.id.switchGluten); // Initialize the buy switch
    }

    @NonNull
    private Product addProduct() {
        Product p = new Product(); // Creating a new product
        p.setGluten(isGluten.isChecked()); // Set the gluten status
        p.setLactose(isLactose.isChecked());// Set the lactose status
        p.setId(DataBase.generateId()); // Set a unique ID for the product
        p.setName(etName.getText().toString()); // Get the product name
        p.setNote(etNote.getText().toString()); // Get the additional notes
        p.setBuy(isBuy.isChecked()); // Check if it's a buy item

        // Add the product to the list instead of setting it
        DataBase.getProducts().add(p); // Add the new product to the database
        return p; // Return the created product
    }
}
