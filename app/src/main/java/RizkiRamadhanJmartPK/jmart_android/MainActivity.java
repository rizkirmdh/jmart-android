package RizkiRamadhanJmartPK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import RizkiRamadhanJmartPK.jmart_android.model.ProductCategory;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ListView listView;
    private Button prev, next, go;
    private TextView num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        listView = findViewById(R.id.listview);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        go = findViewById(R.id.go);
        num = findViewById(R.id.num);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new product(), "PRODUCT");
        vpAdapter.addFragment(new filter(), "FILTER");
        viewPager.setAdapter(vpAdapter);

        EnumSet<ProductCategory> all = EnumSet.allOf(ProductCategory.class);
        List<ProductCategory> arrayCategory = new ArrayList<>(all.size());
        for (ProductCategory s:all){
            arrayCategory.add(s);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayCategory);

    }
}