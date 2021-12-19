package RizkiRamadhanJmartPK.jmart_android;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import RizkiRamadhanJmartPK.jmart_android.model.Account;
import RizkiRamadhanJmartPK.jmart_android.model.ProductCategory;

/**
 * Fragment dari Class MainActivity yang berfungsi
 * untuk menampilkan list product
 */

// implements AdapterView.OnItemClickListener
public class Fragment_Product extends Fragment{

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        EnumSet<ProductCategory> all = EnumSet.allOf(ProductCategory.class);
        List<ProductCategory> arrayCategory = new ArrayList<>();
        for (ProductCategory s:all){
            arrayCategory.add(s);
        }

        ListView listView = view.findViewById(R.id.listview);
        ArrayAdapter<ProductCategory> adapter = new ArrayAdapter<ProductCategory>(getActivity(),
                android.R.layout.simple_list_item_1, arrayCategory);

        listView.setAdapter(adapter);
//        listView.setOnClickListener((View.OnClickListener) this);
    }

//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        if(position == 0){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "BOOK");
//            startActivity(intent);
//        }
//        else if(position == 1){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "KITCHEN");
//            startActivity(intent);
//        }
//        else if(position == 2){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "ELECTRONIC");
//            startActivity(intent);
//        }
//        else if(position == 3){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "FASHION");
//            startActivity(intent);
//        }
//        else if(position == 4){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "GAMING");
//            startActivity(intent);
//        }
//        else if(position == 5){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "GADGET");
//            startActivity(intent);
//        }
//        else if(position == 6){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "MOTHERCARE");
//            startActivity(intent);
//        }
//        else if(position == 7){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "COSMETICS");
//            startActivity(intent);
//        }
//        else if(position == 8){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "HEALTHCARE");
//            startActivity(intent);
//        }else if(position == 9){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "FURNITURE");
//            startActivity(intent);
//        }else if(position == 10){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "JEWELRY");
//            startActivity(intent);
//        }else if(position == 11){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "TOYS");
//            startActivity(intent);
//        }else if(position == 11){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "FNB");
//            startActivity(intent);
//        }else if(position == 12){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "STATIONERY");
//            startActivity(intent);
//        }else if(position == 13){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "SPORTS");
//            startActivity(intent);
//        }else if(position == 14){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "AUTOMOTIF");
//            startActivity(intent);
//        }else if(position == 15){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "PETCARE");
//            startActivity(intent);
//        }else if(position == 16){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "ART_CRAFT");
//            startActivity(intent);
//        }else if(position == 17){
//            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
//            intent.putExtra(ProductDetailActivity.productName, "CARPENTRY");
//            startActivity(intent);
//        }
//    }
}