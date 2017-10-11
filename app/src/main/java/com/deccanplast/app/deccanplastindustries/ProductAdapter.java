package com.deccanplast.app.deccanplastindustries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Product Adapter to generates products to be displayed
 * in list view in corresponding furniture category
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    /**
     * Create a new {@link ProductAdapter} object.
     *
     * @param context  is the current context (i.e. Activity) that the adapter is being created in.
     * @param products is the list of {@link Product}s to be displayed.
     */
    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Product} object located at this position in the list
        Product currentProduct = getItem(position);

        // Find the TextView in the list_item.xml layout with the id list_item_name
        TextView productName = listItemView.findViewById(R.id.list_item_name);
        // Get the Product Name from the current Product object and set this text on
        // the product_name TextView.

        productName.setText(currentProduct.getmProductName());


        // Find the ImageView in the list_item.xml layout with the id list_item_image
        ImageView productImage = listItemView.findViewById(R.id.list_item_image);

        // Get the Product Image Id from current Product object and set the image on
        // the product_image ImageView.

        productImage.setImageResource(currentProduct.getmProductImageId());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
