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


    private Log log;

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
        DataBase.fillList();
        Log.i("List", DataBase.getProducts().toString());
        ProductAdapter productAdapter = new ProductAdapter(MainActivity.this, 0, DataBase.getProducts());
        lvProducts.setAdapter(productAdapter);

        lvProducts.setOnItemClickListener((parent, view, position, id) ->  {
            Product p =(Product) parent.getItemAtPosition(position);
            seeDetails.putExtra("product", p);
            startActivity(seeDetails);
        });
        btnWaitList.setOnClickListener(v-> startActivity(addWaitList));
        btnAddProduct.setOnClickListener(v-> startActivity(addProduct));

    }
}