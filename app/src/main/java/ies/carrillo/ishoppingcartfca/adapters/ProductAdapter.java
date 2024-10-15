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
    private final List<Product> products;

    /**
     * Constructor for the adapter
     *
     * @param context  app context
     * @param resource id from the xml
     * @param objects  objects from the models
     */
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.products = objects;
    }

    /**
     * method for complete the slots of the listview
     *
     * @param position    item of the list
     * @param convertView view where the list are
     * @param parent      the view
     * @return view transformed
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Product p = this.products.get(position);
        if (convertView == null) {
            //first refers the xml we want to show, second the parent of that xml and attachment root false
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_item, parent, false);
        }
        //we instancite the textView from the view of the list
        TextView tvProduct = convertView.findViewById(R.id.tvProductList);

        //add the data from the object
        tvProduct.setText(p.getName());

        return convertView;

    }

    /**
     *
     * @param position
     * @param convertview
     * @param parent
     * @return
     */
    @Override
    public View getDropDownView(int position, View convertview, @NonNull ViewGroup parent) {
        Product p = products.get(position);
        if (convertview == null) {
            convertview = LayoutInflater.from(getContext()).inflate(R.layout.product_item, parent, false);
        }
        return convertview;
    }
}
