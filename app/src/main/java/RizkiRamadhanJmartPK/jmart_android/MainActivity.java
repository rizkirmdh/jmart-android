package RizkiRamadhanJmartPK.jmart_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

/**
 * Class ini berfungsi menampilkan MainActivity
 * yang terdiri dari product dan filter
 */

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
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        go = findViewById(R.id.topup);
        num = findViewById(R.id.num);
        search = findViewById(R.id.search);
        add = findViewById(R.id.add);
        aboutMe = findViewById(R.id.account);

        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new Fragment_Product(), "PRODUCT");
        vpAdapter.addFragment(new Fragment_Filter(), "FILTER");
        viewPager.setAdapter(vpAdapter);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_list, new Fragment_Product()).commit();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.add) {
            startActivity(new Intent(MainActivity.this, CreateProductActivity.class));
            finish();
        }
        if (id == R.id.account) {
            startActivity(new Intent(MainActivity.this, AboutMeActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}