package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the family category
        View categoryFurniture = findViewById(R.id.furniture_category);

        // Set a click listener on that View
        categoryFurniture.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Furniture View is clicked on.
            @Override
            public void onClick(View view) {
                Intent furnitureIntent = new Intent(MainActivity.this, FurnitureActivity.class);
                startActivity(furnitureIntent);
            }
        });

        // Find the View that shows the family category
        View categoryMHS = findViewById(R.id.mhs_category);

        // Set a click listener on that View
        categoryMHS.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the MHS Solution View is clicked on.
            @Override
            public void onClick(View view) {
                Intent mhsIntent = new Intent(MainActivity.this, MHSActivity.class);
                startActivity(mhsIntent);
            }
        });
    }
}
