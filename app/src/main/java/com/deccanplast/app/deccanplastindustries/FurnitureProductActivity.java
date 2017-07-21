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
                product.setmProductDimensions(getString(R.string.premium_relax_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_relax_chairs_recommendations));
                break;
            case 10102:
                product.setmProductCost(1215);
                product.setmProductFeatures(getString(R.string.premium_relax_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_relax_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_relax_chairs_recommendations));
                break;
            case 10201:
                product.setmProductCost(935);
                product.setmProductCost(1215);
                product.setmProductFeatures(getString(R.string.premium_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_arm_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_arm_chairs_recommendations));
                break;
            case 10202:
                product.setmProductCost(935);
                product.setmProductCost(1215);
                product.setmProductFeatures(getString(R.string.premium_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_arm_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_arm_chairs_recommendations));
                break;
            case 10301:
                product.setmProductCost(820);
                product.setmProductFeatures(getString(R.string.premium_high_back_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_high_back_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_high_back_chairs_recommendations));
                break;
            case 10302:
                product.setmProductCost(820);
                product.setmProductFeatures(getString(R.string.premium_high_back_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_high_back_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_high_back_chairs_recommendations));
                break;
            case 10303:
                product.setmProductCost(820);
                product.setmProductFeatures(getString(R.string.premium_high_back_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_high_back_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_high_back_chairs_recommendations));
                break;
            case 10401:
                product.setmProductCost(665);
                product.setmProductFeatures(getString(R.string.premium_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_dining_chairs_recommendations));
                break;
            case 10402:
                product.setmProductCost(665);
                product.setmProductFeatures(getString(R.string.premium_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_dining_chairs_recommendations));
                break;
            case 10403:
                product.setmProductCost(665);
                product.setmProductFeatures(getString(R.string.premium_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_dining_chairs_recommendations));
                break;
            case 10501:
                product.setmProductCost(635);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_a));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                break;
            case 10502:
                product.setmProductCost(635);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_a));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                break;
            case 10503:
                product.setmProductCost(635);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_a));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                break;
            case 10504:
                product.setmProductCost(555);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_b));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                break;
            case 10505:
                product.setmProductCost(555);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_b));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                break;
            case 10506:
                product.setmProductCost(555);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_b));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                break;
            case 10601:
                product.setmProductCost(530);
                product.setmProductFeatures(getString(R.string.high_back_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.high_back_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.high_back_dining_chairs_recommendations));
                break;
            case 10602:
                product.setmProductCost(530);
                product.setmProductFeatures(getString(R.string.high_back_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.high_back_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.high_back_dining_chairs_recommendations));
                break;
            case 10701:
                product.setmProductCost(540);
                product.setmProductFeatures(getString(R.string.armless_chairs_features));
                product.setmProductDimensions(getString(R.string.armless_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.armless_chairs_recommendations));
                break;
            case 10801:
                product.setmProductCost(1950);
                product.setmProductFeatures(getString(R.string.dining_table_features));
                product.setmProductDimensions(getString(R.string.dining_table_dimensions));
                product.setmProductRecommendations(getString(R.string.dining_table_recommendations));
                break;
            case 10802:
                product.setmProductCost(1695);
                product.setmProductFeatures(getString(R.string.dining_table_features));
                product.setmProductDimensions(getString(R.string.dining_table_dimensions));
                product.setmProductRecommendations(getString(R.string.dining_table_recommendations));
                break;
            case 10901:
                product.setmProductCost(930);
                product.setmProductFeatures(getString(R.string.innova_table_features));
                product.setmProductDimensions(getString(R.string.innova_table_dimensions));
                product.setmProductRecommendations(getString(R.string.innova_table_recommendations));
                break;
            case 10902:
                product.setmProductCost(860);
                product.setmProductFeatures(getString(R.string.swift_table_features));
                product.setmProductDimensions(getString(R.string.swift_table_dimensions));
                product.setmProductRecommendations(getString(R.string.swift_table_recommendations));
                break;
            case 11001:
                product.setmProductCost(1700);
                product.setmProductFeatures(getString(R.string.multi_seating_features));
                product.setmProductDimensions(getString(R.string.multi_seating_dimensions));
                product.setmProductRecommendations(getString(R.string.multi_seating_recommendations));
                break;
            case 11101:
                product.setmProductCost(325);
                product.setmProductFeatures(getString(R.string.mini_relax_chairs_features));
                product.setmProductDimensions(getString(R.string.mini_relax_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.mini_relax_chairs_recommendations));
                break;
            case 11102:
                product.setmProductCost(325);
                product.setmProductFeatures(getString(R.string.mini_relax_chairs_features));
                product.setmProductDimensions(getString(R.string.mini_relax_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.mini_relax_chairs_recommendations));
                break;
            case 11103:
                product.setmProductCost(325);
                product.setmProductFeatures(getString(R.string.mini_relax_chairs_features));
                product.setmProductDimensions(getString(R.string.mini_relax_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.mini_relax_chairs_recommendations));
                break;
            case 11201:
                product.setmProductCost(185);
                product.setmProductFeatures(getString(R.string.baby_chairs_features));
                product.setmProductDimensions(getString(R.string.baby_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.baby_chairs_recommendations));
                break;
            case 11202:
                product.setmProductCost(185);
                product.setmProductFeatures(getString(R.string.baby_chairs_features));
                product.setmProductDimensions(getString(R.string.baby_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.baby_chairs_recommendations));
                break;
            case 11203:
                product.setmProductCost(185);
                product.setmProductFeatures(getString(R.string.baby_chairs_features));
                product.setmProductDimensions(getString(R.string.baby_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.baby_chairs_recommendations));
                break;
            case 11301:
                product.setmProductCost(550);
                product.setmProductFeatures(getString(R.string.rocker_toy_features));
                product.setmProductDimensions(getString(R.string.rocker_toy_dimensions));
                product.setmProductRecommendations(getString(R.string.rocker_toy_recommendations));
                break;
            case 11401:
                product.setmProductCost(360);
                product.setmProductFeatures(getString(R.string.pulsar_stool_features));
                product.setmProductDimensions(getString(R.string.pulsar_stool_dimensions));
                product.setmProductRecommendations(getString(R.string.pulsar_stool_recommendations));
                break;
            case 11402:
                product.setmProductCost(260);
                product.setmProductFeatures(getString(R.string.activa_stool_features));
                product.setmProductDimensions(getString(R.string.activa_stool_dimensions));
                product.setmProductRecommendations(getString(R.string.activa_stool_recommendations));
                break;
            case 11403:
                product.setmProductCost(350);
                product.setmProductFeatures(getString(R.string.rattan_stool_features));
                product.setmProductDimensions(getString(R.string.rattan_stool_dimensions));
                product.setmProductRecommendations(getString(R.string.rattan_stool_recommendations));
                break;
            case 11404:
                product.setmProductCost(160);
                product.setmProductFeatures(getString(R.string.pleasure_stool_features));
                product.setmProductDimensions(getString(R.string.pleasure_stool_dimensions));
                product.setmProductRecommendations(getString(R.string.pleasure_stool_recommendations));
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
