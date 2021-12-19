package RizkiRamadhanJmartPK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import RizkiRamadhanJmartPK.jmart_android.model.Product;
import RizkiRamadhanJmartPK.jmart_android.request.CreateProductRequest;

/**
 * Class ini berfungsi membuat prpoduct baru
 *
 */

public class CreateProductActivity extends AppCompatActivity {

    private static final Gson gson = new Gson();
    private static Product product = null;
    public String name, weight, price, discount, check, kategori, shipmentPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
        EditText nameInput = (EditText) findViewById(R.id.createname);
        EditText weightInput = (EditText) findViewById(R.id.createweight);
        EditText priceInput = (EditText) findViewById(R.id.createprice);
        EditText discountInput = (EditText) findViewById(R.id.creatediscount);
        CheckBox checkNew = (CheckBox) findViewById(R.id.createnew);
        CheckBox checkUsed = (CheckBox) findViewById(R.id.createused);
        Spinner category = (Spinner) findViewById(R.id.createcategory);
        Spinner shipmentPlans = (Spinner) findViewById(R.id.createplan);
        Button create = (Button) findViewById(R.id.createbutton);
        Button cancel = (Button) findViewById(R.id.createcancel);

        checkNew.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean state) {
                if(state){
                    checkUsed.setChecked(false);
                }
            }
        });

        checkUsed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean state) {
                if(state){
                    checkNew.setChecked(false);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameInput.setText("");
                weightInput.setText("");
                priceInput.setText("");
                discountInput.setText("");
                checkUsed.setChecked(false);
                checkNew.setChecked(false);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameInput.getText().toString();
                weight = weightInput.getText().toString();
                price = priceInput.getText().toString();
                discount = discountInput.getText().toString();
                check = String.valueOf(checkNew.isChecked());
                kategori = category.getSelectedItem().toString();
                shipmentPlan = convertShipmentPlans(shipmentPlans.getSelectedItem().toString());

                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            product = gson.fromJson(object.toString(),Product.class);
                            Toast.makeText(CreateProductActivity.this,"Product Created",Toast.LENGTH_SHORT).show();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                        System.out.println(product);
                    }
                };
                CreateProductRequest requestProduct = new CreateProductRequest(name, weight, price, discount, check, kategori, shipmentPlan, listener, null);
                RequestQueue queue = Volley.newRequestQueue(CreateProductActivity.this);
                queue.add(requestProduct);
            }
        });
    }

    protected String convertShipmentPlans(String shipment){
        switch (shipment) {
            case "INSTANT":
                return "0";
            case "SAME DAY":
                return "1";
            case "NEXT DAY":
                return "2";
            case "REGULER":
                return "3";
            default:
                return "4";
        }
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getCheck() {
        return check;
    }

    public String getKategori() {
        return kategori;
    }

    public String getShipmentPlan() {
        return shipmentPlan;
    }
}