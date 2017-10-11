package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This Activity class {@link ChildrenChairs} generates subcategory
 * under selected Children Chairs Category from {@link FurnitureActivity}
 */
public class ChildrenChairs extends AppCompatActivity {

    ArrayList<Category> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        Intent activityIntent = getIntent();

        Bundle extras = activityIntent.getExtras();

        if (extras != null) {
            final String activityTitle = activityIntent.getStringExtra("activityTitle");
            setTitle(activityTitle);
            categories = activityIntent.getParcelableArrayListExtra("categories");
        }

        // Create an {@link ProductAdapter}, whose data source is a list of {@link Product}s. The
        // adapter knows how to create list items for each item in the list.
        CategoryAdapter adapter = new CategoryAdapter(this, categories);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // product_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ProductAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Class activityClass = FurnitureProductActivity.class;
                ArrayList<Product> productsToPass = new ArrayList<>();
                String activityTitle = "";

                Category category = categories.get(position);
                int categoryId = category.getmCategoryCode();

                switch (categoryId) {
                    case 111:
                        productsToPass.add(new Product(11101, "Ferrari Mini", R.drawable.ferrari_mini));
                        productsToPass.add(new Product(11102, "Lotus Mini", R.drawable.lotus_mini));
                        productsToPass.add(new Product(11103, "Noble Mini", R.drawable.noble_mini));
                        activityTitle = "Mini Relax Chairs";
                        break;
                    case 112:
                        productsToPass.add(new Product(11201, "Baby Eon", R.drawable.baby_eon));
                        productsToPass.add(new Product(11202, "Baby ABCD", R.drawable.baby_abcd));
                        productsToPass.add(new Product(11203, "Baby Up", R.drawable.baby_up));
                        activityTitle = "Baby Chairs";
                        break;
                    case 113:
                        productsToPass.add(new Product(11301, "Gogo Rocker Toy", R.drawable.baby_rocker));
                        activityTitle = "Rocker Toys";
                        break;
                }

                Intent activityIntent = new Intent(getApplicationContext(), activityClass);
                activityIntent.putExtra("products", productsToPass);
                activityIntent.putExtra("activityTitle", activityTitle);
                startActivity(activityIntent);
            }
        });


    }

    /**
     * This method manages back button in the Toolbar / App Bar
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                // Launch the correct Activity here
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
