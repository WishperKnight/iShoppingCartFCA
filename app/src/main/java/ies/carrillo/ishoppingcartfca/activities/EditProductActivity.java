package ies.carrillo.ishoppingcartfca.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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
import ies.carrillo.ishoppingcartfca.models.Products;

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
        Product p = null;
        Intent cancel = new Intent(this, MainActivity.class);
        Button btnEditProduct = findViewById(R.id.btnEditDone);
        Button btnCancel = findViewById(R.id.btnCancel);
        TextView name = findViewById(R.id.tvProductOldName);
        TextView note = findViewById(R.id.tvProductOldNote);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch buy = findViewById(R.id.SwitchOldState);
        EditText nName = findViewById(R.id.etNewName);
        EditText nNote = findViewById(R.id.etNewNote);

        loadData(p);
        String newName = nName.getText().toString();
        String newNote = nNote.getText().toString();

        if (!(newName.isBlank() && newNote.isBlank())) {
            String finalNewName = newName;
            String finalNewNote = newNote;
            btnEditProduct.setOnClickListener(v -> editproduct(p, finalNewName, finalNewNote, buy.isChecked()));
        } else if (!(newName.isBlank())) {

            newName = name.getText().toString();
            String finalNewName1 = newName;
            String finalNewNote3 = newNote;
            btnEditProduct.setOnClickListener(v -> editproduct(p, finalNewName1, finalNewNote3, buy.isChecked()));

        } else if (!(newNote.isBlank())) {

            newNote = name.getText().toString();
            String finalNewNote1 = newNote;
            String finalNewName3 = newName;
            btnEditProduct.setOnClickListener(v -> editproduct(p, finalNewName3, finalNewNote1, buy.isChecked()));

        } else {
            newNote = name.getText().toString();
            newName = name.getText().toString();

            String finalNewName2 = newName;
            String finalNewNote2 = newNote;

            btnEditProduct.setOnClickListener(v -> Products.products.add(editproduct(p, finalNewName2, finalNewNote2, buy.isChecked())));
        }

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
        p.setBuy(buy);
        p.setName(name);
        p.setNote(note);
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

