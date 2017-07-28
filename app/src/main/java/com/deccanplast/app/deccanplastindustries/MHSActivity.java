package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MHSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        ArrayList<Category> categories = new ArrayList<>();

        // Create a list of words
        categories.add(new Category(20101,"JCDW Double Wall Crate", R.drawable.jcdw_double_wall));
        categories.add(new Category(20201,"JCSW Single Wall Crate",R.drawable.jcsw_single_wall));
        categories.add(new Category(20301,"JCSWH Single Wall Crate (Handle)",R.drawable.jcsw_handle));
        categories.add(new Category(20401,"MP21 Utility Crate",R.drawable.mp21));
        categories.add(new Category(20501,"MP22 Utility Crate",R.drawable.mp12));
        categories.add(new Category(20601,"MP01 Multipurpose Crate",R.drawable.multipurpose_crate));
        categories.add(new Category(20701,"MP11 Mini Veg Crate",R.drawable.mp11_mini));
        categories.add(new Category(20801,"MP12 Mini Veg Crate",R.drawable.mp12));
        categories.add(new Category(20901,"BC01 Bottle Crate",R.drawable.bottle_crate));
        categories.add(new Category(20101,"Sindhushree 25 Jalli Butti",R.drawable.sindhushree_25));
        categories.add(new Category(21101,"Sindhushree 21 Jalli Butti",R.drawable.sindhushree_21));
        categories.add(new Category(21201,"Sindhushree 18 Jalli Butti",R.drawable.sindhushree_18));
        categories.add(new Category(21301,"Jayashree Butti",R.drawable.jayashree));
        categories.add(new Category(21401,"Buckets",R.drawable.bucket));

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
                generateActivity(position);

            }
        });

    }

    public void generateActivity(int position) {

        Class activityClass = ProductPageActivity.class;

        Product product = new Product();
        String activityTitle = "";
        String activityParent = "MHSActivity";

        switch (position) {
            case 0:
                activityTitle = "JCDW";
                product.setmProductCode(20101);
                product.setmProductImageId(R.drawable.jcdw_double_wall);
                product.setmProductName(activityTitle);
                product.setmProductCost(970);
                product.setmProductFeatures(getString(R.string.jcdw_features));
                product.setmProductDimensions(getString(R.string.jcdw_dimensions));
                product.setmProductRecommendations(getString(R.string.jcdw_recommendations));
                break;
            case 1:
                activityTitle = "JCSW";
                product.setmProductCode(20201);
                product.setmProductImageId(R.drawable.jcsw_single_wall);
                product.setmProductName(activityTitle);
                product.setmProductCost(875);
                product.setmProductFeatures(getString(R.string.jcsw_features));
                product.setmProductDimensions(getString(R.string.jcsw_dimensions));
                product.setmProductRecommendations(getString(R.string.jcsw_recommendations));
                break;
            case 2:
                activityTitle = "JCSWH";
                product.setmProductCode(20301);
                product.setmProductImageId(R.drawable.jcsw_handle);
                product.setmProductName(activityTitle);
                product.setmProductCost(875);
                product.setmProductFeatures(getString(R.string.jcsw_features));
                product.setmProductDimensions(getString(R.string.jcsw_dimensions));
                product.setmProductRecommendations(getString(R.string.jcsw_recommendations));
                break;
            case 3:
                activityTitle = "MP 21";
                product.setmProductCode(20401);
                product.setmProductImageId(R.drawable.mp21);
                product.setmProductName(activityTitle);
                product.setmProductCost(740);
                product.setmProductFeatures(getString(R.string.mp11_features));
                product.setmProductDimensions(getString(R.string.mp11_dimensions));
                product.setmProductRecommendations(getString(R.string.mp11_recommendations));
                break;
            case 4:
                activityTitle = "MP 22";
                product.setmProductCode(20501);
                product.setmProductImageId(R.drawable.mp22);
                product.setmProductName(activityTitle);
                product.setmProductCost(620);
                product.setmProductFeatures(getString(R.string.mp11_features));
                product.setmProductDimensions(getString(R.string.mp11_dimensions));
                product.setmProductRecommendations(getString(R.string.mp11_recommendations));
                break;
            case 5:
                activityTitle = "MP Multipurpose 01";
                product.setmProductCode(20601);
                product.setmProductImageId(R.drawable.multipurpose_crate);
                product.setmProductName(activityTitle);
                product.setmProductCost(350);
                product.setmProductFeatures(getString(R.string.mp01_features));
                product.setmProductDimensions(getString(R.string.mp01_dimensions));
                product.setmProductRecommendations(getString(R.string.mp01_recommendations));
                break;
            case 6:
                activityTitle = "MP 11";
                product.setmProductCode(20701);
                product.setmProductImageId(R.drawable.mp11_mini);
                product.setmProductName(activityTitle);
                product.setmProductCost(350);
                product.setmProductFeatures(getString(R.string.mp11_features));
                product.setmProductDimensions(getString(R.string.mp11_dimensions));
                product.setmProductRecommendations(getString(R.string.mp11_recommendations));
                break;
            case 7:
                activityTitle = "MP 12";
                product.setmProductCode(20801);
                product.setmProductImageId(R.drawable.mp12);
                product.setmProductName(activityTitle);
                product.setmProductCost(970);
                product.setmProductFeatures(getString(R.string.mp12_features));
                product.setmProductDimensions(getString(R.string.mp12_dimensions));
                product.setmProductRecommendations(getString(R.string.mp12_recommendations));
                break;
            case 8:
                activityTitle = "BC01 Bottle Crate";
                product.setmProductCode(20901);
                product.setmProductImageId(R.drawable.bottle_crate);
                product.setmProductName(activityTitle);
                product.setmProductCost(500);
                product.setmProductFeatures(getString(R.string.bc01_features));
                product.setmProductDimensions(getString(R.string.bc01_dimensions));
                product.setmProductRecommendations(getString(R.string.bc01_recommendations));
                break;
            case 9:
                activityTitle = "Sindushree 25";
                product.setmProductCode(21001);
                product.setmProductImageId(R.drawable.sindhushree_25);
                product.setmProductName(activityTitle);
                product.setmProductCost(350);
                product.setmProductFeatures(getString(R.string.sindhushree_features));
                product.setmProductDimensions(getString(R.string.sindhushree_25_dimensions));
                product.setmProductRecommendations(getString(R.string.sindhushree_recomendations));
                break;
            case 10:
                activityTitle = "Sindushree 21";
                product.setmProductCode(21101);
                product.setmProductImageId(R.drawable.sindhushree_21);
                product.setmProductName(activityTitle);
                product.setmProductCost(250);
                product.setmProductFeatures(getString(R.string.sindhushree_features));
                product.setmProductDimensions(getString(R.string.sindhushree_21_dimensions));
                product.setmProductRecommendations(getString(R.string.sindhushree_recomendations));
                break;
            case 11:
                activityTitle = "Sindushree 18";
                product.setmProductCode(21201);
                product.setmProductImageId(R.drawable.sindhushree_18);
                product.setmProductName(activityTitle);
                product.setmProductCost(250);
                product.setmProductFeatures(getString(R.string.sindhushree_features));
                product.setmProductDimensions(getString(R.string.sindhushree_18_dimensions));
                product.setmProductRecommendations(getString(R.string.sindhushree_recomendations));
                break;
            case 12:
                activityTitle = "Jayashree Butti";
                product.setmProductCode(21301);
                product.setmProductImageId(R.drawable.jayashree);
                product.setmProductName(activityTitle);
                product.setmProductCost(255);
                product.setmProductFeatures(getString(R.string.jayashree_features));
                product.setmProductDimensions(getString(R.string.jayashree_dimensions));
                product.setmProductRecommendations(getString(R.string.jayashree_recommendations));
                break;
            case 13:
                activityTitle = "Buckets";
                product.setmProductCode(21401);
                product.setmProductImageId(R.drawable.bucket);
                product.setmProductName(activityTitle);
                product.setmProductCost(180);
                product.setmProductFeatures(getString(R.string.buckets_features));
                product.setmProductDimensions(getString(R.string.buckets_dimensions));
                product.setmProductRecommendations(getString(R.string.buckets_recommendations));
                break;
        }

        Intent activityIntent = new Intent(getApplicationContext(), activityClass);
        activityIntent.putExtra("product",product);
        activityIntent.putExtra("activityTitle",activityTitle);
        activityIntent.putExtra("activityParent",activityParent);
        startActivity(activityIntent);
    }
}
