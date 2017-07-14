package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FurnitureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        final ArrayList<Product> products = new ArrayList<>();

        // Create a list of words
        products.add(new Product("premium relax chairs", R.drawable.ferrari));
        products.add(new Product("premium arm chairs", R.drawable.bently));
        products.add(new Product("premium high back chairs", R.drawable.porsche));
        products.add(new Product("premium dining chairs", R.drawable.hexa));
        products.add(new Product("mid back arm chairs", R.drawable.brio));
        products.add(new Product("high back dining chairs", R.drawable.figo));
        products.add(new Product("armless chairs", R.drawable.nano));
        products.add(new Product("dining tables", R.drawable.calicut_round_table));
        products.add(new Product("center tables", R.drawable.innova));
        products.add(new Product("multi seating systems", R.drawable.ritz));
        products.add(new Product("children chairs", R.drawable.gogo_baby_rocker));
        products.add(new Product("stools", R.drawable.rattan));

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
                generateActivity(position);

            }
        });

    }

    public void generateActivity(int position) {

        Class activityClass = FurnitureProductActivity.class;
        ArrayList<Product> productToPass = new ArrayList<>();
        String activityTitle = "";

        switch (position) {
            case 0:
                productToPass.add(new Product("Ferrari", R.drawable.ferrari));
                productToPass.add(new Product("Lotus", R.drawable.lotus));
                activityTitle = "Premium Relax Chairs";
                break;
            case 1:
                productToPass.add(new Product("Buggati", R.drawable.buggatti));
                productToPass.add(new Product("Bently", R.drawable.bently));
                activityTitle = "Premium Arm Chairs";
                break;
            case 2:
                productToPass.add(new Product("Lexus", R.drawable.lexus));
                productToPass.add(new Product("Porsche", R.drawable.porsche));
                productToPass.add(new Product("Mercedes", R.drawable.mercedes));
                activityTitle = "Premium High Back Chairs";
                break;
            case 3:
                productToPass.add(new Product("Brezza", R.drawable.brezza));
                productToPass.add(new Product("Hexa", R.drawable.hexa));
                productToPass.add(new Product("Crysta", R.drawable.crysta));
                activityTitle = "Premium Dining Chairs";
                break;
            case 4:
                productToPass.add(new Product("Camry", R.drawable.camry));
                productToPass.add(new Product("Accord", R.drawable.accord));
                productToPass.add(new Product("Amaze", R.drawable.amaze));
                productToPass.add(new Product("Eon", R.drawable.eon));
                productToPass.add(new Product("Brio", R.drawable.brio));
                productToPass.add(new Product("Up", R.drawable.up_mid));
                activityTitle = "Premium Mid Back Chairs";
                break;
            case 5:
                productToPass.add(new Product("Figo", R.drawable.figo));
                productToPass.add(new Product("Polo", R.drawable.polo));
                activityTitle = "High Back Dining Chairs";
                break;
            case 6:
                productToPass.add(new Product("Nano", R.drawable.nano));
                activityTitle = "Armless Chairs";
                break;
            case 7:
                productToPass.add(new Product("Mangalore Dining Tables", R.drawable.mangalore_dining_table));
                productToPass.add(new Product("Calicut Dining Tables", R.drawable.calicut_round_table));
                activityTitle = "Dining Tables";
                break;
            case 8:
                productToPass.add(new Product("Innova", R.drawable.innova));
                productToPass.add(new Product("Swift", R.drawable.swift));
                activityTitle = "Center Tables";
                break;
            case 9:
                productToPass.add(new Product("Ritz", R.drawable.ritz));
                activityTitle = "Multi Seating Systems";
                break;
            case 10:
                productToPass.add(new Product("Mini Relax Chairs", R.drawable.ferrari_mini));
                productToPass.add(new Product("Baby Chairs", R.drawable.baby_abcd));
                productToPass.add(new Product("Rocker Toys", R.drawable.gogo_baby_rocker));
                activityTitle = "Children Chairs";
                break;
            case 11:
                productToPass.add(new Product("Ritz", R.drawable.rattan));
                productToPass.add(new Product("Ritz", R.drawable.pulsar21));
                productToPass.add(new Product("Ritz", R.drawable.activa));
                productToPass.add(new Product("Pleasure", R.drawable.pleasure_bath));
                activityTitle = "Stools";
                break;
        }

        Intent activityIntent = new Intent(getApplicationContext(), activityClass);
        activityIntent.putExtra("products",productToPass);
        activityIntent.putExtra("activityTitle",activityTitle);
        startActivity(activityIntent);
    }
}
