package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
        final ArrayList<Product> products = activityIntent.getParcelableArrayListExtra("products");

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = products.get(position);
                int productCode = product.getmProductCode();
                generateActivity(product, productCode);


            }
        });
    }

    public void generateActivity(Product product, int productCode) {

        Class activityClass = ProductPageActivity.class;

        switch (productCode) {
            case 10101:
                product.setmProductCost(1215);
                product.setmProductFeatures(getString(R.string.premium_relax_chairs_features));
                break;
            case 10102:
                product.setmProductCost(1215);
                product.setmProductFeatures(getString(R.string.premium_relax_chairs_features));
                break;
            case 10201:
                product.setmProductCost(935);
                break;
            case 10202:
                product.setmProductCost(935);
                break;
            case 10301:
                product.setmProductCost(820);
                break;
            case 10302:
                product.setmProductCost(820);
                break;
            case 10303:
                product.setmProductCost(820);
                break;
            case 10401:
                product.setmProductCost(665);
                break;
            case 10402:
                product.setmProductCost(665);
                break;
            case 10403:
                product.setmProductCost(665);
                break;
            case 10501:
                product.setmProductCost(635);
                break;
            case 10502:
                product.setmProductCost(635);
                break;
            case 10503:
                product.setmProductCost(635);
                break;
            case 10504:
                product.setmProductCost(555);
                break;
            case 10505:
                product.setmProductCost(555);
                break;
            case 10506:
                product.setmProductCost(555);
                break;
            case 10601:
                product.setmProductCost(530);
                break;
            case 10602:
                product.setmProductCost(530);
                break;
            case 10701:
                product.setmProductCost(540);
                break;
            case 10801:
                product.setmProductCost(1950);
                break;
            case 10802:
                product.setmProductCost(1695);
                break;
            case 10901:
                product.setmProductCost(930);
                break;
            case 10902:
                product.setmProductCost(860);
                break;
            case 11001:
                product.setmProductCost(1700);
                break;
            case 11101:
                product.setmProductCost(325);
                break;
            case 11102:
                product.setmProductCost(325);
                break;
            case 11103:
                product.setmProductCost(325);
                break;
            case 11201:
                product.setmProductCost(185);
                break;
            case 11202:
                product.setmProductCost(185);
                break;
            case 11203:
                product.setmProductCost(185);
                break;
            case 11301:
                product.setmProductCost(550);
                break;
            case 11401:
                product.setmProductCost(360);
                break;
            case 11402:
                product.setmProductCost(260);
                break;
            case 11403:
                product.setmProductCost(350);
                break;
            case 11404:
                product.setmProductCost(160);
                break;
        }

        Intent activityIntent = new Intent(getApplicationContext(), activityClass);
        activityIntent.putExtra("product",product);
        startActivity(activityIntent);
    }

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
