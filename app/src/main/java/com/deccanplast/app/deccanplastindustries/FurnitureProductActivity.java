package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FurnitureProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        Intent activityIntent = getIntent();
        final String activityTitle = activityIntent.getStringExtra("activityTitle");
        setTitle(activityTitle);
        final ArrayList<Product> activityProduct = activityIntent.getParcelableArrayListExtra("products");

        // Create an {@link ProductAdapter}, whose data source is a list of {@link Product}s. The
        // adapter knows how to create list items for each item in the list.
        ProductAdapter adapter = new ProductAdapter(this, activityProduct);

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
                Product product = activityProduct.get(position);
                Log.v("FurnitureProduct",product.getmProductName());
            }
        });
    }
}
