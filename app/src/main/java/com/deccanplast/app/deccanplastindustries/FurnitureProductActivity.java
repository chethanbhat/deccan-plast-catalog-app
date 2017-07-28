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
                product.setmProductSlider(new int[]{R.drawable.s_ferrari_1,R.drawable.s_ferrari_2,R.drawable.s_ferrari_3});
                break;
            case 10102:
                product.setmProductCost(1215);
                product.setmProductFeatures(getString(R.string.premium_relax_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_relax_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_relax_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_lotus_1,R.drawable.s_lotus_2,R.drawable.s_lotus_3});
                break;
            case 10201:
                product.setmProductCost(935);
                product.setmProductCost(1215);
                product.setmProductFeatures(getString(R.string.premium_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_arm_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_arm_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_buggati_1,R.drawable.s_buggati_2,R.drawable.s_buggati_3});
                break;
            case 10202:
                product.setmProductCost(935);
                product.setmProductCost(1215);
                product.setmProductFeatures(getString(R.string.premium_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_arm_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_arm_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_bently_1,R.drawable.s_bently_2,R.drawable.s_bently_3,R.drawable.s_bently_4,R.drawable.s_bently_5,R.drawable.s_bently_6,R.drawable.s_bently_7,R.drawable.s_bently_8});
                break;
            case 10301:
                product.setmProductCost(820);
                product.setmProductFeatures(getString(R.string.premium_high_back_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_high_back_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_high_back_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_lexus_1,R.drawable.s_lexus_2,R.drawable.s_lexus_3,R.drawable.s_lexus_4});
                break;
            case 10302:
                product.setmProductCost(820);
                product.setmProductFeatures(getString(R.string.premium_high_back_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_high_back_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_high_back_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_porsche_1,R.drawable.s_porsche_2,R.drawable.s_porsche_3,R.drawable.s_porsche_4,R.drawable.s_porsche_5});
                break;
            case 10303:
                product.setmProductCost(820);
                product.setmProductFeatures(getString(R.string.premium_high_back_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_high_back_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_high_back_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_mercedes_1,R.drawable.s_mercedes_2,R.drawable.s_mercedes_3});
                break;
            case 10401:
                product.setmProductCost(665);
                product.setmProductFeatures(getString(R.string.premium_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_dining_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_brezza_1,R.drawable.s_brezza_2,R.drawable.s_brezza_3,R.drawable.s_brezza_4,R.drawable.s_brezza_5,R.drawable.s_brezza_6,R.drawable.s_brezza_7,R.drawable.s_brezza_8,R.drawable.s_brezza_9});
                break;
            case 10402:
                product.setmProductCost(665);
                product.setmProductFeatures(getString(R.string.premium_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_dining_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_hexa_1,R.drawable.s_hexa_2,R.drawable.s_hexa_3,R.drawable.s_hexa_4,R.drawable.s_hexa_5,R.drawable.s_hexa_6,R.drawable.s_hexa_7,R.drawable.s_hexa_8});
                break;
            case 10403:
                product.setmProductCost(665);
                product.setmProductFeatures(getString(R.string.premium_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.premium_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.premium_dining_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_crysta_1,R.drawable.s_crysta_2,R.drawable.s_crysta_3,R.drawable.s_crysta_4,R.drawable.s_crysta_5,R.drawable.s_crysta_6});
                break;
            case 10501:
                product.setmProductCost(635);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_a));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_camry_1,R.drawable.s_camry_2,R.drawable.s_camry_3,R.drawable.s_camry_4});
                break;
            case 10502:
                product.setmProductCost(635);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_a));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_accord_1,R.drawable.s_accord_2,R.drawable.s_accord_3});
                break;
            case 10503:
                product.setmProductCost(635);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_a));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_amaze_1,R.drawable.s_amaze_2,R.drawable.s_amaze_3});
                break;
            case 10504:
                product.setmProductCost(555);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_b));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_eon_1,R.drawable.s_eon_2,R.drawable.s_eon_3,R.drawable.s_eon_4});
                break;
            case 10505:
                product.setmProductCost(555);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_b));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_brio_1,R.drawable.s_brio_2,R.drawable.s_brio_3,R.drawable.s_brio_4,R.drawable.s_brio_5});
                break;
            case 10506:
                product.setmProductCost(555);
                product.setmProductFeatures(getString(R.string.midback_arm_chairs_features));
                product.setmProductDimensions(getString(R.string.midback_arm_chairs_dimensions_b));
                product.setmProductRecommendations(getString(R.string.midback_arm_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_up_1,R.drawable.s_up_2,R.drawable.s_up_3,R.drawable.s_up_4});
                break;
            case 10601:
                product.setmProductCost(530);
                product.setmProductFeatures(getString(R.string.high_back_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.high_back_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.high_back_dining_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_figo_1,R.drawable.s_figo_2,R.drawable.s_figo_3,R.drawable.s_figo_4,R.drawable.s_figo_5,R.drawable.s_figo_6,R.drawable.s_figo_7,R.drawable.s_figo_8});
                break;
            case 10602:
                product.setmProductCost(530);
                product.setmProductFeatures(getString(R.string.high_back_dining_chairs_features));
                product.setmProductDimensions(getString(R.string.high_back_dining_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.high_back_dining_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_polo_1,R.drawable.s_polo_2,R.drawable.s_polo_3,R.drawable.s_polo_4});
                break;
            case 10701:
                product.setmProductCost(540);
                product.setmProductFeatures(getString(R.string.armless_chairs_features));
                product.setmProductDimensions(getString(R.string.armless_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.armless_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_nano_1,R.drawable.s_nano_2,R.drawable.s_nano_3});
                break;
            case 10801:
                product.setmProductCost(1950);
                product.setmProductFeatures(getString(R.string.dining_table_features));
                product.setmProductDimensions(getString(R.string.dining_table_dimensions));
                product.setmProductRecommendations(getString(R.string.dining_table_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_mangalore_dining_1,R.drawable.s_mangalore_dining_2,R.drawable.s_mangalore_dining_3,R.drawable.s_mangalore_dining_4,R.drawable.s_mangalore_dining_5});
                break;
            case 10802:
                product.setmProductCost(1695);
                product.setmProductFeatures(getString(R.string.dining_table_features));
                product.setmProductDimensions(getString(R.string.dining_table_dimensions));
                product.setmProductRecommendations(getString(R.string.dining_table_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_calicut_round_1,R.drawable.s_calicut_round_2,R.drawable.s_calicut_round_3});
                break;
            case 10901:
                product.setmProductCost(930);
                product.setmProductFeatures(getString(R.string.innova_table_features));
                product.setmProductDimensions(getString(R.string.innova_table_dimensions));
                product.setmProductRecommendations(getString(R.string.innova_table_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_innova_1,R.drawable.s_innova_2,R.drawable.s_innova_3,R.drawable.s_innova_4,R.drawable.s_innova_5});
                break;
            case 10902:
                product.setmProductCost(860);
                product.setmProductFeatures(getString(R.string.swift_table_features));
                product.setmProductDimensions(getString(R.string.swift_table_dimensions));
                product.setmProductRecommendations(getString(R.string.swift_table_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_swift_1,R.drawable.s_swift_2,R.drawable.s_swift_3});
                break;
            case 11001:
                product.setmProductCost(1700);
                product.setmProductFeatures(getString(R.string.multi_seating_features));
                product.setmProductDimensions(getString(R.string.multi_seating_dimensions));
                product.setmProductRecommendations(getString(R.string.multi_seating_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_ritz_1,R.drawable.s_ritz_2,R.drawable.s_ritz_3,R.drawable.s_ritz_4,R.drawable.s_ritz_5});
                break;
            case 11101:
                product.setmProductCost(325);
                product.setmProductFeatures(getString(R.string.mini_relax_chairs_features));
                product.setmProductDimensions(getString(R.string.mini_relax_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.mini_relax_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_ferrari_mini_1,R.drawable.s_ferrari_mini_2,R.drawable.s_ferrari_mini_3,R.drawable.s_ferrari_mini_4,R.drawable.s_ferrari_mini_5});
                break;
            case 11102:
                product.setmProductCost(325);
                product.setmProductFeatures(getString(R.string.mini_relax_chairs_features));
                product.setmProductDimensions(getString(R.string.mini_relax_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.mini_relax_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_noble_mini_1,R.drawable.s_noble_mini_2,R.drawable.s_noble_mini_3,R.drawable.s_noble_mini_4});
                break;
            case 11103:
                product.setmProductCost(325);
                product.setmProductFeatures(getString(R.string.mini_relax_chairs_features));
                product.setmProductDimensions(getString(R.string.mini_relax_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.mini_relax_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_ferrari_mini_1,R.drawable.s_ferrari_mini_2,R.drawable.s_ferrari_mini_3,R.drawable.s_ferrari_mini_4,R.drawable.s_ferrari_mini_5});
                break;
            case 11201:
                product.setmProductCost(185);
                product.setmProductFeatures(getString(R.string.baby_chairs_features));
                product.setmProductDimensions(getString(R.string.baby_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.baby_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_baby_eon_1,R.drawable.s_baby_eon_2,R.drawable.s_baby_eon_3,R.drawable.s_baby_eon_4,R.drawable.s_baby_eon_5});
                break;
            case 11202:
                product.setmProductCost(185);
                product.setmProductFeatures(getString(R.string.baby_chairs_features));
                product.setmProductDimensions(getString(R.string.baby_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.baby_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_baby_abcd_1,R.drawable.s_baby_abcd_2,R.drawable.s_baby_abcd_3,R.drawable.s_baby_abcd_4,R.drawable.s_baby_abcd_5});
                break;
            case 11203:
                product.setmProductCost(185);
                product.setmProductFeatures(getString(R.string.baby_chairs_features));
                product.setmProductDimensions(getString(R.string.baby_chairs_dimensions));
                product.setmProductRecommendations(getString(R.string.baby_chairs_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_baby_up_1,R.drawable.s_baby_up_2,R.drawable.s_baby_up_3,R.drawable.s_baby_up_4,R.drawable.s_baby_up_5});
                break;
            case 11301:
                product.setmProductCost(550);
                product.setmProductFeatures(getString(R.string.rocker_toy_features));
                product.setmProductDimensions(getString(R.string.rocker_toy_dimensions));
                product.setmProductRecommendations(getString(R.string.rocker_toy_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_baby_rocker_1,R.drawable.s_baby_rocker_2});
                break;
            case 11401:
                product.setmProductCost(360);
                product.setmProductFeatures(getString(R.string.pulsar_stool_features));
                product.setmProductDimensions(getString(R.string.pulsar_stool_dimensions));
                product.setmProductRecommendations(getString(R.string.pulsar_stool_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_pulsar_1,R.drawable.s_pulsar_2,R.drawable.s_pulsar_3,R.drawable.s_pulsar_4,R.drawable.s_pulsar_5,R.drawable.s_pulsar_6,R.drawable.s_pulsar_7});
                break;
            case 11402:
                product.setmProductCost(260);
                product.setmProductFeatures(getString(R.string.activa_stool_features));
                product.setmProductDimensions(getString(R.string.activa_stool_dimensions));
                product.setmProductRecommendations(getString(R.string.activa_stool_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_activa_1,R.drawable.s_activa_2,R.drawable.s_activa_3,R.drawable.s_activa_4,R.drawable.s_activa_5,R.drawable.s_activa_6,R.drawable.s_activa_7,R.drawable.s_activa_8});
                break;
            case 11403:
                product.setmProductCost(350);
                product.setmProductFeatures(getString(R.string.rattan_stool_features));
                product.setmProductDimensions(getString(R.string.rattan_stool_dimensions));
                product.setmProductRecommendations(getString(R.string.rattan_stool_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_maestro_1,R.drawable.s_maestro_2,R.drawable.s_maestro_3,R.drawable.s_maestro_4,R.drawable.s_maestro_5,R.drawable.s_maestro_6});
                break;
            case 11404:
                product.setmProductCost(160);
                product.setmProductFeatures(getString(R.string.pleasure_stool_features));
                product.setmProductDimensions(getString(R.string.pleasure_stool_dimensions));
                product.setmProductRecommendations(getString(R.string.pleasure_stool_recommendations));
                product.setmProductSlider(new int[]{R.drawable.s_pleasure_1,R.drawable.s_pleasure_2,R.drawable.s_pleasure_3,R.drawable.s_pleasure_4,R.drawable.s_pleasure_5});
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
