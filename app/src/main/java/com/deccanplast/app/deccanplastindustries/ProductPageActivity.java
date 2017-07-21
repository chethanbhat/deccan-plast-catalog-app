package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductPageActivity extends AppCompatActivity {

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
        productImage.setImageResource(currentProduct.getmProductImageId());

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
