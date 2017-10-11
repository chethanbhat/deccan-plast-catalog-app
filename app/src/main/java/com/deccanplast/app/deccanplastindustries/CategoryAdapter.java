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
 * Category Adapter to generates categories to be displayed
 * in list view in corresponding to {@link FurnitureActivity}
 */

public class CategoryAdapter extends ArrayAdapter<Category> {
    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context    is the current context (i.e. Activity) that the adapter is being created in.
     * @param categories is the list of {@link Category}s to be displayed.
     */
    public CategoryAdapter(Context context, ArrayList<Category> categories) {
        super(context, 0, categories);
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

        // Get the {@link Category} object located at this position in the list
        Category currentCategory = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID list_item_name
        TextView categoryName = listItemView.findViewById(R.id.list_item_name);
        // Get the Category Name from the current Category object and set this text on
        // the categoryName TextView.

        categoryName.setText(currentCategory.getmCategoryName());

        // Find the ImageView in the list_item.xml layout with the ID list_item_image
        ImageView categoryImage = listItemView.findViewById(R.id.list_item_image);

        // Get the Category image Id from current Category object and set the image on
        // the categoryImage ImageView.

        categoryImage.setImageResource(currentCategory.getmCategoryImageId());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
