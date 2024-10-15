package ies.carrillo.ishoppingcartfca.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ies.carrillo.ishoppingcartfca.R;
import ies.carrillo.ishoppingcartfca.models.Product;

public class ProductAdapter extends ArrayAdapter<Product> {
    // List to hold the Product objects
    private final List<Product> products;

    /**
     * Constructor for the adapter
     *
     * @param context  Application context used to access resources
     * @param resource ID of the layout resource that will be used for each item in the ListView
     * @param objects  List of Product objects to display in the adapter
     */
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.products = objects; // Initialize the products list with the passed objects
    }

    /**
     * Method to create and return the view for each item in the ListView
     *
     * @param position    Position of the item within the adapter's data set
     * @param convertView Recycled view to reuse if possible (for performance optimization)
     * @param parent      The parent view that this view will eventually be attached to
     * @return A view corresponding to the data at the specified position
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the current Product object based on the position
        Product p = this.products.get(position);

        // Check if we can reuse a view; if not, inflate a new view from the layout resource
        if (convertView == null) {
            // Inflate the layout for the list item
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_item, parent, false);
        }

        // Find the TextView in the list item layout
        TextView tvProduct = convertView.findViewById(R.id.tvProductList);

        // Set the product name to the TextView
        tvProduct.setText(p.getName());

        return convertView; // Return the completed view to be displayed in the ListView
    }

    /**
     * Method to provide a view for the dropdown items in a spinner
     *
     * @param position    Position of the item within the dropdown
     * @param convertView Recycled view to reuse if possible (for performance optimization)
     * @param parent      The parent view that this view will eventually be attached to
     * @return A view corresponding to the data at the specified position for the dropdown
     */
    @Override
    public View getDropDownView(int position, View convertview, @NonNull ViewGroup parent) {
        // Get the current Product object based on the position
        Product p = products.get(position);

        // Check if we can reuse a view; if not, inflate a new view from the layout resource
        if (convertview == null) {
            // Inflate the layout for the spinner dropdown item
            convertview = LayoutInflater.from(getContext()).inflate(R.layout.product_spinner_item, parent, false);
        }

        // Find the TextView in the dropdown item layout
        TextView tvSpinnerItem = convertview.findViewById(R.id.tvSpinnerItem);
        // Set the product name to the TextView for the spinner item
        tvSpinnerItem.setText(p.getName());

        return convertview; // Return the completed dropdown view
    }
}
