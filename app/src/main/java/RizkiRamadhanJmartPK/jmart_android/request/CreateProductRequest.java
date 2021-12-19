package RizkiRamadhanJmartPK.jmart_android.request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Class ini berfungsi untuk mengirim request ke Back-End
 * bagian product create
 */

public class CreateProductRequest extends StringRequest {
    private static final String URL = "http://10.0.2.2:8080/product/create";
    private final Map<String, String> params;

    public CreateProductRequest(String name, String weight, String price, String discount, String check, String category, String shipmentPlan,
                           Response.Listener<String>listener, Response.ErrorListener errorListener)
    {
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("name", name);
        params.put("weight", weight);
        params.put("price", price);
        params.put("discount", discount);
        params.put("check", check);
        params.put("category", category);
        params.put("shipmentPlan", shipmentPlan);
    }

    public Map<String, String> getParams(){
        return params;
    }
}
