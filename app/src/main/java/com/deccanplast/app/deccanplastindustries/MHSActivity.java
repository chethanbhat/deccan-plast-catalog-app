package com.deccanplast.app.deccanplastindustries;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MHSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        ArrayList<Product> products = new ArrayList<>();

        // Create a list of words
        products.add(new Product("JCDW Double Wall Crate", R.drawable.jcdw_double_wall));
        products.add(new Product("JCSW Single Wall Crate",R.drawable.jcsw_single_wall));
        products.add(new Product("JCSWH Single Wall Crate (Handle)",R.drawable.jcsw_single_wall));
        products.add(new Product("MP21 Utility Crate",R.drawable.mp_11_mini_veg));
        products.add(new Product("MP22 Utility Crate",R.drawable.mp_11_mini_veg));
        products.add(new Product("MP01 Multipurpose Crate",R.drawable.multipurpose_crate));
        products.add(new Product("MP11 Mini Veg Crate",R.drawable.mp_11_mini_veg));
        products.add(new Product("MP12 Mini Veg Crate",R.drawable.mp_11_mini_veg));
        products.add(new Product("BC01 Bottle Crate",R.drawable.bottle_crate));
        products.add(new Product("Sindhushree 25 Jalli Butti",R.drawable.sindhushree));
        products.add(new Product("Sindhushree 21 Jalli Butti",R.drawable.sindhushree));
        products.add(new Product("Sindhushree 18 Jalli Butti",R.drawable.sindhushree));
        products.add(new Product("Jayashree Butti",R.drawable.jayashree));
        products.add(new Product("Buckets",R.drawable.bucket));

        for(int i=0; i< products.size(); i++ )
        {
            Log.v("Furniture Activity","Current Product: " + products.get(i));
        }

        // Create an {@link ProductAdapter}, whose data source is a list of {@link Product}s. The
        // adapter knows how to create list items for each item in the list.
        ProductAdapter adapter = new ProductAdapter(this, products);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // product_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ProductAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


    }
}
