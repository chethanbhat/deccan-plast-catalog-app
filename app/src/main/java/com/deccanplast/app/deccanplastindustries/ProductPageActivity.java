package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class ProductPageActivity extends AppCompatActivity {

    private ViewPager mPager;
    private int currentPage = 0;
    private ArrayList<Integer> imageArray = new ArrayList<>();

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
            init(currentProduct.getmProductSlider());
        }else{
            productImage.setImageResource(currentProduct.getmProductImageId());
            productImage.setVisibility(View.VISIBLE);
            findViewById(R.id.pager).setVisibility(View.GONE);
            findViewById(R.id.indicator).setVisibility(View.GONE);
        }

        TextView productPrice = (TextView)findViewById(R.id.product_price);
        productPrice.setText("Unit Price: " + currentProduct.getmProductCost());

        TextView productFeatures = (TextView)findViewById(R.id.product_features);
        productFeatures.setText(currentProduct.getmProductFeatures());

        TextView productDimensions = (TextView)findViewById(R.id.product_dimensions);
        productDimensions.setText(currentProduct.getmProductDimensions());

        TextView productRecommendation = (TextView)findViewById(R.id.product_recommendation);
        productRecommendation.setText(currentProduct.getmProductRecommendations());

        Button orderButton = (Button)findViewById(R.id.order_button);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class activityClass = OrderActivity.class;
                Intent activityIntent = new Intent(getApplicationContext(), activityClass);
                activityIntent.putExtra("product",currentProduct.getmProductName());
                activityIntent.putExtra("activityTitle","Order Now: " + currentProduct.getmProductName());
                startActivity(activityIntent);
            }
        });
    }

    private void init(final int[] sliderImageResourceId) {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SliderAdapter(getApplicationContext(),sliderImageResourceId));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == sliderImageResourceId.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);
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
