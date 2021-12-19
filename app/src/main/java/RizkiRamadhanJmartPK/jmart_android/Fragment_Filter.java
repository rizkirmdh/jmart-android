package RizkiRamadhanJmartPK.jmart_android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Fragment dari Class MainActivity yang berfungsi
 * untuk filter product
 */

public class Fragment_Filter extends Fragment {
    private static final Gson gson = new Gson();
    private static Product product = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_filter, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        EditText nameInput = view.findViewById(R.id.filtername);
        EditText lowPrice = view.findViewById(R.id.filterlow);
        EditText highPrice = view.findViewById(R.id.filterhight);
        CheckBox checkNew = view.findViewById(R.id.filternew);
        CheckBox checkUsed = view.findViewById(R.id.filterused);
        Spinner shipmentPlans = view.findViewById(R.id.filtercategory);
        Button apply = view.findViewById(R.id.filterapply);
        Button clear = view.findViewById(R.id.filterclear);

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

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameInput.setText("");
                lowPrice.setText("");
                highPrice.setText("");
                checkUsed.setChecked(false);
                checkNew.setChecked(false);
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                String low = lowPrice.getText().toString();
                String high = highPrice.getText().toString();
                String check = String.valueOf(checkNew.isChecked());
                String shipmentPlan = convertShipmentPlans(shipmentPlans.getSelectedItem().toString());

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
}