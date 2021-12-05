package RizkiRamadhanJmartPK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ListView listView;
    private Button prev, next, go, search, add, aboutMe;
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
        go = findViewById(R.id.topup);
        num = findViewById(R.id.num);
        search = findViewById(R.id.search);
        add = findViewById(R.id.add);
        aboutMe = findViewById(R.id.account);

        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new product(), "PRODUCT");
        vpAdapter.addFragment(new filter(), "FILTER");
        viewPager.setAdapter(vpAdapter);


//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent createIntent = new Intent(MainActivity.this, CreateProductActivity.class);
//                startActivity(createIntent);
//            }
//        });
//        aboutMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent aboutIntent = new Intent(MainActivity.this, AboutMeActivity.class);
//                startActivity(aboutIntent);
//            }
//        });

//        EnumSet<ProductCategory> all = EnumSet.allOf(ProductCategory.class);
//        List<ProductCategory> arrayCategory = new ArrayList<>();
//        for (ProductCategory s:all){
//            arrayCategory.add(s);
//        }
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayCategory);
//        listView.setAdapter(arrayAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

}