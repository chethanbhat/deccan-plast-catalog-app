package com.deccanplast.app.deccanplastindustries;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    int quantity = 1;
    String productName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent orderIntent = getIntent();
        setTitle(orderIntent.getStringExtra("activityTitle"));

        productName = orderIntent.getStringExtra("product");

        TextView productNameTextView = (TextView)findViewById(R.id.product);
        productNameTextView.setText("Product Name: " + productName);

        Button incrementButton = (Button)(findViewById(R.id.increment_button));
        Button decrementButton = (Button)(findViewById(R.id.decrement_button));
        Button submitButton = (Button)findViewById(R.id.submit_button);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitOrder();
            }
        });



    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment() {
        if(quantity<100)
        {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
        else{
            createToast("Sorry, maximum limit is 100 nos per product !");
        }

    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement() {
        if(quantity>1)
        {
            quantity = quantity - 1;
            displayQuantity(quantity);

        }
        else{
            createToast("You can't order less than 1 item");
        }

    }

    /**
     * Checks if Chocolate Topping has been added.
     * @param message indicates toast message.
     *
     */
    private void createToast(String message) {

        Context context = this;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    public void displayQuantity(int number) {

        TextView quantityTextView =(TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));

    }

    public void submitOrder() {

        EditText userNameBox = (EditText) findViewById(R.id.name);
        EditText userPhone = (EditText) findViewById(R.id.phone);


        String orderSummary = "Name: " + userNameBox.getText().toString();
        orderSummary += "\nPhone Number: " + userPhone.getText().toString();
        orderSummary += "\nProduct: " + productName;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += "\nThank You!";

        String emailAddress = "chethanbhat@gmail.com";
        String emailSubject = "Order Summary - Deccan App";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"+emailAddress)); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
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
