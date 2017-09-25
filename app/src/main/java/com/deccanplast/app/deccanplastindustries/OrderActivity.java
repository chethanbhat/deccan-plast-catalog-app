package com.deccanplast.app.deccanplastindustries;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class OrderActivity extends AppCompatActivity {

    private int quantity = 1;
    private String productName;
    private AwesomeValidation awesomeValidation;
    static final int PICK_EMAIL_REQUEST = 1;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent orderIntent = getIntent();
        setTitle(orderIntent.getStringExtra("activityTitle"));

        final Product currentProduct = orderIntent.getParcelableExtra("product");

        productName = "Product Name: " +  currentProduct.getmProductName();

        if(currentProduct.hasColors())
        {
            Spinner spinner = findViewById(R.id.colorSpinner);

            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currentProduct.getmProductColors());
            // Apply the adapter to the spinner
            spinner.setAdapter(adapter);

        }else {
            findViewById(R.id.colorsHeading).setVisibility(View.GONE);
            findViewById(R.id.colorSpinner).setVisibility(View.GONE);
        }

        TextView productNameTextView = (TextView)findViewById(R.id.product);
        productNameTextView.setText(productName);

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
     * Creates toast message for increment and decrement
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

    public boolean validateInfo(){

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.name_error);
        awesomeValidation.addValidation(this, R.id.phone, "((\\+*)((0[ -]+)*|(91 )*)(\\d{12}+|\\d{10}+))|\\d{5}([- ]*)\\d{6}", R.string.phone_error);
        awesomeValidation.addValidation(this, R.id.address,"[a-zA-Z0-9.\\[\\]()\\s,\\/\\\\-]+", R.string.address_error);
        awesomeValidation.addValidation(this, R.id.city, "[a-zA-Z\\s]+", R.string.city_error);
        awesomeValidation.addValidation(this, R.id.pincode, "[0-9]{6}", R.string.pincode_error);

        return awesomeValidation.validate();


    }

    public void submitOrder() {

        if(validateInfo())
        {
            String colorSelected = "";
            EditText name = (EditText) findViewById(R.id.name);
            EditText phone = (EditText) findViewById(R.id.phone);
            EditText address = (EditText)findViewById(R.id.address);
            EditText city = (EditText)findViewById(R.id.city);
            EditText pincode = (EditText)findViewById(R.id.pincode);
            if(findViewById(R.id.colorSpinner).getVisibility() == View.VISIBLE)
            {
                Spinner color = (Spinner)findViewById(R.id.colorSpinner);
                colorSelected = color.getItemAtPosition(color.getSelectedItemPosition()).toString() ;
            }




            String orderSummary = "Name of the Customer: " + name.getText().toString();
            orderSummary += "\nPhone Number: " + phone.getText().toString();
            orderSummary += "\nAddress: " + address.getText().toString();
            orderSummary += "\nCity: " + city.getText().toString();
            orderSummary += "\nPincode: " + pincode.getText().toString();
            orderSummary += "\nProduct: " + productName;

            if(colorSelected != null && !colorSelected.isEmpty()){
                orderSummary += "\nColor: " + colorSelected;
            }

            orderSummary += "\nQuantity: " + quantity;
            orderSummary += "\n\nPlease take immediate action";
            orderSummary += "\nThank You!";

            String emailAddress = "sales@deccanplast.com";
            String emailSubject = "Order Request from Deccan Plast Mobile App";

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setType("*/*");
            intent.setData(Uri.parse("mailto:"+emailAddress)); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent,PICK_EMAIL_REQUEST);
            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            Intent orderCompletedIntent = new Intent(this, MainActivity.class);
            startActivity(orderCompletedIntent);
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