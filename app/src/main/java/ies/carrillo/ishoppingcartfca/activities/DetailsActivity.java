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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadingComponents();
    }

    private void loadingComponents() {
        Intent cancel = new Intent(DetailsActivity.this, MainActivity.class);
        Intent edit = new Intent(DetailsActivity.this, EditProductActivity.class);
        Intent data = getIntent();

        Button btnBack = findViewById(R.id.btnBack);
        Button btnEdit = findViewById(R.id.btnEdit);
        TextView tvId = findViewById(R.id.tvID);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvShortNote = findViewById(R.id.tvShortNote);
        TextView tvState = findViewById(R.id.tvState);



            Product p = (Product) data.getSerializableExtra("product");
            Log.i("Product", p.toString());

            tvId.setText("ID: " + String.valueOf(p.getId()));
            tvName.setText("Nombre: " + p.getName().toString());
            tvShortNote.setText("Nota: " + p.getNote().toString());
            tvState.setText( p.isBuy() ? "Comprar" : "No comprar");




        btnBack.setOnClickListener(v -> startActivity(cancel));
        btnEdit.setOnClickListener(v -> {
            Product product = (Product) data.getSerializableExtra("product");
            edit.putExtra("product", product);
            Log.i("Product to edit", product.toString());
            startActivity(edit);
        });

    }


}