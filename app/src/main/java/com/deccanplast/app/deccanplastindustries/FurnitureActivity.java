package com.deccanplast.app.deccanplastindustries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This class {@link FurnitureActivity} generates list of various Furniture Categories
 */

public class FurnitureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        final ArrayList<Category> categories = new ArrayList<>();

        // Create a list of Furniture Categories
        categories.add(new Category(101, "premium relax chairs", R.drawable.ferrari));
        categories.add(new Category(102, "premium arm chairs", R.drawable.bently));
        categories.add(new Category(103, "premium high back chairs", R.drawable.porsche));
        categories.add(new Category(104, "premium dining chairs", R.drawable.hexa));
        categories.add(new Category(105, "mid back arm chairs", R.drawable.eon));
        categories.add(new Category(106, "high back dining chairs", R.drawable.figo));
        categories.add(new Category(107, "armless chairs", R.drawable.nano));
        categories.add(new Category(108, "dining tables", R.drawable.calicut_round_tables));
        categories.add(new Category(109, "center tables", R.drawable.innova));
        categories.add(new Category(110, "multi seating systems", R.drawable.ritz));
        categories.add(new Category(114, "stools", R.drawable.maestro_rattan));
        categories.add(new Category(777, "children chairs", R.drawable.baby_rocker));

        // Create an {@link CategoryAdapter}, whose data source is a list of {@link Category}s. The
        // adapter knows how to create list items for each item in the list.
        CategoryAdapter adapter = new CategoryAdapter(this, categories);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // product_list.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ProductAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Category category = categories.get(position);

                int categoryId = category.getmCategoryCode();

                // If selected category is 'Children's Chairs',
                // Generate sub categories in 'Children's Chairs'
                // Else Generate Products Activity {@link FurnitureProductActivity} in selected category

                if (categoryId == 777) {
                    generateCategory();
                } else {
                    generateActivity(categoryId);
                }
            }
        });

    }

    /**
     * This method creates intent to {@link FurnitureProductActivity}
     * to generates products in the selected furniture category
     *
     * @param categoryId refers to the unique id of selected category
     */

    public void generateActivity(int categoryId) {

        Class activityClass = FurnitureProductActivity.class;
        ArrayList<Product> productsToPass = new ArrayList<>();
        String activityTitle = "";

        switch (categoryId) {
            case 101:
                productsToPass.add(new Product(10101, "Ferrari", R.drawable.ferrari));
                productsToPass.add(new Product(10102, "Lotus", R.drawable.lotus));
                activityTitle = "Premium Relax Chairs";
                break;
            case 102:
                productsToPass.add(new Product(10201, "Buggati", R.drawable.buggati));
                productsToPass.add(new Product(10202, "Bently", R.drawable.bently));
                activityTitle = "Premium Arm Chairs";
                break;
            case 103:
                productsToPass.add(new Product(10301, "Lexus", R.drawable.lexus));
                productsToPass.add(new Product(10302, "Porsche", R.drawable.porsche));
                productsToPass.add(new Product(10303, "Mercedes", R.drawable.mercedes));
                activityTitle = "Premium High Back Chairs";
                break;
            case 104:
                productsToPass.add(new Product(10401, "Brezza", R.drawable.brezza));
                productsToPass.add(new Product(10402, "Hexa", R.drawable.hexa));
                productsToPass.add(new Product(10403, "Crysta", R.drawable.crysta));
                activityTitle = "Premium Dining Chairs";
                break;
            case 105:
                productsToPass.add(new Product(10501, "Camry", R.drawable.camry));
                productsToPass.add(new Product(10502, "Accord", R.drawable.accord));
                productsToPass.add(new Product(10503, "Amaze", R.drawable.amaze));
                productsToPass.add(new Product(10504, "Eon", R.drawable.eon));
                productsToPass.add(new Product(10505, "Brio", R.drawable.brio));
                productsToPass.add(new Product(10506, "Up", R.drawable.up));
                activityTitle = "Premium Mid Back Chairs";
                break;
            case 106:
                productsToPass.add(new Product(10601, "Figo", R.drawable.figo));
                productsToPass.add(new Product(10602, "Polo", R.drawable.polo));
                activityTitle = "High Back Dining Chairs";
                break;
            case 107:
                productsToPass.add(new Product(10701, "Nano", R.drawable.nano));
                activityTitle = "Armless Chairs";
                break;
            case 108:
                productsToPass.add(new Product(10801, "Mangalore Dining Tables", R.drawable.mangalore_dining_tables));
                productsToPass.add(new Product(10802, "Calicut Dining Tables", R.drawable.calicut_round_tables));
                activityTitle = "Dining Tables";
                break;
            case 109:
                productsToPass.add(new Product(10901, "Innova", R.drawable.innova));
                productsToPass.add(new Product(10902, "Swift", R.drawable.swift));
                activityTitle = "Center Tables";
                break;
            case 110:
                productsToPass.add(new Product(11001, "Ritz", R.drawable.ritz));
                activityTitle = "Multi Seating Systems";
                break;
            case 111:
                productsToPass.add(new Product(11101, "Ferrari Mini", R.drawable.ferrari_mini));
                productsToPass.add(new Product(11102, "Lotus Mini", R.drawable.lotus_mini));
                productsToPass.add(new Product(11103, "Noble Mini", R.drawable.noble_mini));
                activityTitle = "Mini Relax Chairs";
                break;
            case 112:
                productsToPass.add(new Product(11201, "Baby Eon", R.drawable.baby_eon));
                productsToPass.add(new Product(11202, "Baby ABCD", R.drawable.baby_abcd));
                productsToPass.add(new Product(11203, "Baby Up", R.drawable.baby_up));
                activityTitle = "Baby Chairs";
                break;
            case 113:
                productsToPass.add(new Product(11301, "Gogo Rocker Toy", R.drawable.baby_rocker));
                activityTitle = "Rocker Toys";
                break;
            case 114:
                productsToPass.add(new Product(11401, "Pulsar", R.drawable.pulsar));
                productsToPass.add(new Product(11402, "Activa", R.drawable.activa));
                productsToPass.add(new Product(11403, "Maestro Rattan", R.drawable.maestro_rattan));
                productsToPass.add(new Product(11404, "Pleasure", R.drawable.pleasure));
                activityTitle = "Stools";
                break;
        }

        Intent activityIntent = new Intent(getApplicationContext(), activityClass);
        activityIntent.putExtra("products", productsToPass);
        activityIntent.putExtra("activityTitle", activityTitle);
        startActivity(activityIntent);
    }

    /**
     * This method creates intent to {@link ChildrenChairs Activity}
     * to generates subcategory in the Children Chairs
     */

    public void generateCategory() {
        ArrayList<Category> categoryChildren = new ArrayList<>();
        Class activityClass = ChildrenChairs.class;
        String activityTitle;

        categoryChildren.add(new Category(111, "Mini Chairs", R.drawable.ferrari_mini));
        categoryChildren.add(new Category(112, "Baby Chairs", R.drawable.baby_abcd));
        categoryChildren.add(new Category(113, "Rocker Toys", R.drawable.baby_rocker));
        activityTitle = "Children Chairs";

        Intent activityIntent = new Intent(getApplicationContext(), activityClass);
        activityIntent.putExtra("categories", categoryChildren);
        activityIntent.putExtra("activityTitle", activityTitle);
        startActivity(activityIntent);

    }
}
