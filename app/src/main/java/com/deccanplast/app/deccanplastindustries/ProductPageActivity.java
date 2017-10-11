package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import me.relex.circleindicator.CircleIndicator;

public class ProductPageActivity extends AppCompatActivity {

    // Below are used only if timer is enabled for Product Image Sliders
    private int currentPage = 0;
    private ArrayList<Integer> imageArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        Intent activityIntent = getIntent();

        final Product currentProduct = activityIntent.getParcelableExtra("product");

        setTitle(currentProduct.getmProductName());

        final TextView productTitle = findViewById(R.id.product_name);
        productTitle.setText(currentProduct.getmProductName());

        ImageView productImage = findViewById(R.id.product_image);

        if (currentProduct.hasSlider()) {
            productImage.setVisibility(View.GONE);
            init(currentProduct.getmProductSlider(), currentProduct.getmProductColors());
        } else {
            productImage.setImageResource(currentProduct.getmProductImageId());
            productImage.setVisibility(View.VISIBLE);
            findViewById(R.id.colors_available_headline).setVisibility(View.GONE);
            findViewById(R.id.product_colors).setVisibility(View.GONE);
            findViewById(R.id.pager).setVisibility(View.GONE);
            findViewById(R.id.indicator).setVisibility(View.GONE);
        }

        TextView productPrice = findViewById(R.id.product_price);
        productPrice.setText("Unit Price: ₹ " + currentProduct.getmProductCost() + "/-");

        TextView productFeatures = findViewById(R.id.product_features);
        productFeatures.setText(currentProduct.getmProductFeatures());

        TextView productDimensions = findViewById(R.id.product_dimensions);
        productDimensions.setText(currentProduct.getmProductDimensions());

        if (currentProduct.hasColors()) {
            TextView productColors = findViewById(R.id.product_colors);
            String colorsAvailable = Arrays.toString(currentProduct.getmProductColors()).replaceAll("\\[|\\]|\\s", "");
            productColors.setText(colorsAvailable.replaceAll(",", ", "));
        }

        TextView productRecommendation = findViewById(R.id.product_recommendation);
        productRecommendation.setText(currentProduct.getmProductRecommendations());

        Button orderButton = findViewById(R.id.order_button);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class activityClass = OrderActivity.class;
                Intent activityIntent = new Intent(getApplicationContext(), activityClass);
                activityIntent.putExtra("product", currentProduct);
                activityIntent.putExtra("activityTitle", "Send Enquiry: " + currentProduct.getmProductName());
                startActivity(activityIntent);
            }
        });
    }

    private void init(final int[] sliderImageResourceId, final String[] sliderProductColorId) {

        ViewPager mPager = findViewById(R.id.pager);
        mPager.setAdapter(new SliderAdapter(getApplicationContext(), sliderImageResourceId, sliderProductColorId));
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(mPager);


//        // Disable to comments to Auto start of viewpager slider.
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (currentPage == sliderImageResourceId.length) {
//                    currentPage = 0;
//                }
//                mPager.setCurrentItem(currentPage++, true);
//            }
//        };
//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 5000, 5000);
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
