package ies.carrillo.ishoppingcartfca.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ies.carrillo.ishoppingcartfca.R;
import ies.carrillo.ishoppingcartfca.models.Product;
import ies.carrillo.ishoppingcartfca.dataBase.DataBase;

/**
 * Class for edit the atributes of an product
 *
 * @author Fran
 */
public class EditProductActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadingComponents();


    }

    /**
     * Method for load the components of the view
     */
    private void loadingComponents() {
        //declare a product object
        Product product;

        Intent cancel = new Intent(this, MainActivity.class);
        Intent data = getIntent();
        Intent showEdited = new Intent(this, DetailsActivity.class);

        //get the product from the intent
        product = (Product) data.getSerializableExtra("product");
        //show the datas on the log
        Log.i("Product", product.toString());

        //action butttons
        Button btnEditProduct = findViewById(R.id.btnEditDone);
        Button btnCancel = findViewById(R.id.btnCancel);

        //Components of the view
        TextView name = findViewById(R.id.tvProductOldName);
        TextView note = findViewById(R.id.tvProductOldNote);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch buy = findViewById(R.id.SwitchOldState);
        EditText nName = findViewById(R.id.etNewName);
        EditText nNote = findViewById(R.id.etNewNote);


        loadData(product);
        Log.i("Product on edition", product.toString());


        btnEditProduct.setOnClickListener(v -> {
            Log.i("Name taken: ", nName.getText().toString());
            Log.i("Note taken: ", nNote.getText().toString());
            Log.i("Buy taken: ", String.valueOf(buy.isChecked()));

            editproduct(product, nName.getText().toString(), nNote.getText().toString(), buy.isChecked());
            showEdited.putExtra("product", product);
            startActivity(showEdited);
        });

        btnCancel.setOnClickListener(v -> startActivity(cancel));
    }

    /**
     * method for edit the data of the product selected
     *
     * @param p    product
     * @param name name of the product
     * @param note short note of the product
     * @param buy  boolean for if it is going to be buy
     * @return Product edited
     */
    private Product editproduct(@NonNull Product p, String name, String note, boolean buy) {
        Log.i("Button pressed", "Product editing");

        Log.i("Name: ", name);
        Log.i("Note: ", note);
        Log.i("Buy: ", String.valueOf(buy));

        p.setBuy(buy);
        p.setName(name);
        p.setNote(note);

        Log.i("Product edited", p.toString());
        DataBase.getProducts().set(p.getId() - 1, p);
        return p;
    }

    /**
     * Method for load old data from an product
     *
     * @param p object selected previously
     */
    private void loadData(@NonNull Product p) {
        TextView name = findViewById(R.id.tvProductOldName);
        TextView note = findViewById(R.id.tvProductOldNote);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch buy = findViewById(R.id.SwitchOldState);
        name.setText(p.getName());
        note.setText(p.getNote());
        buy.setChecked(p.isBuy());
    }
}

