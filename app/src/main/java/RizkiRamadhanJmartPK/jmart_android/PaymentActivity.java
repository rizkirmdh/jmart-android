package RizkiRamadhanJmartPK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Class ini berfungsi untuk membayar product yang dipilih di
 * ProductDetailActivity
 */

public class PaymentActivity extends AppCompatActivity {
    public static final String payName = "pay";
    public static final String payPlan = "plan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView name = findViewById(R.id.payname);
        TextView plan = findViewById(R.id.payplan);
        Button buyButton = findViewById(R.id.buttonpay);

        String getName = getIntent().getStringExtra(payName);
        String getPlan = getIntent().getStringExtra(payPlan);

        name.setText(getName);
        plan.setText(getPlan);

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}