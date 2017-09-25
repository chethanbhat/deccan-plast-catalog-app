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

    private ViewPager mPager;
    private int currentPage = 0;
    private ArrayList<Integer> imageArray = new ArrayList<>();
    private String colorsAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        Intent activityIntent = getIntent();

        final Product currentProduct = activityIntent.getParcelableExtra("product");

        setTitle(currentProduct.getmProductName());

        final TextView productTitle = (TextView)findViewById(R.id.product_name);
        productTitle.setText(currentProduct.getmProductName());

        ImageView productImage = (ImageView)findViewById(R.id.product_image);

        if(currentProduct.hasSlider()){
            productImage.setVisibility(View.GONE);
            init(currentProduct.getmProductSlider(),currentProduct.getmProductColors());
        }else{
            productImage.setImageResource(currentProduct.getmProductImageId());
            productImage.setVisibility(View.VISIBLE);
            findViewById(R.id.colors_available_headline).setVisibility(View.GONE);
            findViewById(R.id.product_colors).setVisibility(View.GONE);
            findViewById(R.id.pager).setVisibility(View.GONE);
            findViewById(R.id.indicator).setVisibility(View.GONE);
        }

        TextView productPrice = (TextView)findViewById(R.id.product_price);
        productPrice.setText("Unit Price: ₹ " + currentProduct.getmProductCost() + "/-");

        TextView productFeatures = (TextView)findViewById(R.id.product_features);
        productFeatures.setText(currentProduct.getmProductFeatures());

        TextView productDimensions = (TextView)findViewById(R.id.product_dimensions);
        productDimensions.setText(currentProduct.getmProductDimensions());

        if(currentProduct.hasColors()){
            TextView productColors = (TextView)findViewById(R.id.product_colors);
            colorsAvailable = Arrays.toString(currentProduct.getmProductColors()).replaceAll("\\[|\\]|\\s", "");
            productColors.setText(colorsAvailable.replaceAll(",",", "));
        }

        TextView productRecommendation = (TextView)findViewById(R.id.product_recommendation);
        productRecommendation.setText(currentProduct.getmProductRecommendations());

        Button orderButton = (Button)findViewById(R.id.order_button);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class activityClass = OrderActivity.class;
                Intent activityIntent = new Intent(getApplicationContext(), activityClass);
                activityIntent.putExtra("product", currentProduct);
                activityIntent.putExtra("activityTitle","Order Now: " + currentProduct.getmProductName());
                startActivity(activityIntent);
            }
        });
    }

    private void init(final int[] sliderImageResourceId, final String[] sliderProductColorId) {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SliderAdapter(getApplicationContext(),sliderImageResourceId,sliderProductColorId));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
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
