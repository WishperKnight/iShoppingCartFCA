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
    private Intent cancel;
    private Spinner productSpinner;
    private ProductAdapter productAdapterSpinner;
    private Button btnCancelFromAPWL;
    private Button btnAddToWaitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_product_to_wait_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadingComponents();
    }

    private void loadingComponents() {
        cancel = new Intent(AddProductToWaitListActivity.this, MainActivity.class);
        productSpinner = findViewById(R.id.spinner);
        productAdapterSpinner = new ProductAdapter(AddProductToWaitListActivity.this, 0, DataBase.getProductsDiferentsToBuy(DataBase.getProducts()));
        productSpinner.setAdapter(productAdapterSpinner);

        btnCancelFromAPWL = findViewById(R.id.btnCancelFromAPWL);
        btnCancelFromAPWL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cancel);
            }
        });
        btnAddToWaitList = findViewById(R.id.btnAddToWaitList);
        btnAddToWaitList.setOnClickListener(v-> addProductToWaitList(((Product) productSpinner.getSelectedItem())));


    }

    private void addProductToWaitList(Product p) {
        p.setBuy(false);
    }
}