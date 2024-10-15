package ies.carrillo.ishoppingcartfca.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ies.carrillo.ishoppingcartfca.R;
import ies.carrillo.ishoppingcartfca.dataBase.DataBase;
import ies.carrillo.ishoppingcartfca.models.Product;

public class AddProductActivity extends AppCompatActivity {

    private Switch isBuy;
    private Button btnCancel = findViewById(R.id.btnCancelFromAP);
    private Button btnSave = findViewById(R.id.btnSave);
    private EditText etName = findViewById(R.id.etName);
    private EditText etNote = findViewById(R.id.etShortNote);
    private Intent cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_product_ativity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadingComponents();
    }

    private void loadingComponents() {
        cancel = new Intent(AddProductActivity.this, MainActivity.class);
        btnCancel.setOnClickListener(v -> startActivity(cancel));
        btnSave.setOnClickListener(v -> DataBase.products.add(addProduct()));
        isBuy = findViewById(R.id.SwtToBuy);
    }

    private Product addProduct() {
        Product p = new Product();
        p.setName(etName.getText().toString());
        p.setNote(etNote.getText().toString());
        p.setBuy(isBuy.isChecked());
        return p;
    }
}