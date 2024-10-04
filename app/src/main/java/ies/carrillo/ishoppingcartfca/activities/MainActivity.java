package ies.carrillo.ishoppingcartfca.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ies.carrillo.ishoppingcartfca.R;
import ies.carrillo.ishoppingcartfca.adapters.ProductAdapter;
import ies.carrillo.ishoppingcartfca.models.Products;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadingComponents();
    }

    private void loadingComponents(){

        Intent seeDetails = new Intent(this, DetailsActivity.class);
        Intent addWaitList = new Intent(this, AddProductToWaitListActivity.class);
        Intent addProduct = new Intent(this, AddProductAtivity.class);

        Button btnWaitList = findViewById(R.id.btnAddWaitngList);
        Button btnAddProduct = findViewById(R.id.btnAddProduct);

        ListView lvProducts = findViewById(R.id.lvProducts);
        ProductAdapter productAdapter = new ProductAdapter(this.getApplicationContext(), 0, Products.products);
        lvProducts.setAdapter(productAdapter);


        lvProducts.setOnItemClickListener((adapterView, view, i, l) ->  startActivity(seeDetails));
        btnWaitList.setOnClickListener(v-> startActivity(addWaitList));
        btnAddProduct.setOnClickListener(v-> startActivity(addProduct));

    }
}