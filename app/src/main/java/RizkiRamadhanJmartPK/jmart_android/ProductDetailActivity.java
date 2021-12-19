package RizkiRamadhanJmartPK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Class ini berfungsi untuk menampilkan detail dari product
 */

public class ProductDetailActivity extends AppCompatActivity {
    CreateProductActivity createProductActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        TextView productName = findViewById(R.id.pdname);
        TextView productWeight = findViewById(R.id.pdweight);
        TextView productCondition = findViewById(R.id.pdcond);
        TextView productPrice = findViewById(R.id.pdprice);
        TextView productDiscount = findViewById(R.id.pddiscount);
        TextView productCategory = findViewById(R.id.pdcategory);
        TextView productShipmentPlan = findViewById(R.id.pdship);
        Button buyButton = findViewById(R.id.buttonbuy);

        productName.setText(createProductActivity.getName());
        productWeight.setText(createProductActivity.getWeight());
        productCondition.setText(createProductActivity.getCheck());
        productPrice.setText(createProductActivity.getPrice());
        productDiscount.setText(createProductActivity.getDiscount());
        productCategory.setText(createProductActivity.getKategori());
        productShipmentPlan.setText(createProductActivity.getShipmentPlan());


        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailActivity.this, PaymentActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}