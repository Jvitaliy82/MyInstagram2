package ru.jdeveloperapps.myinstagram2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import ru.jdeveloperapps.myinstagram2.fragments.Fragment1;
import ru.jdeveloperapps.myinstagram2.fragments.Fragment2;
import ru.jdeveloperapps.myinstagram2.fragments.Fragment3;
import ru.jdeveloperapps.myinstagram2.ui.main.SectionPagerAdapter;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String EXTRA_THEME = "EXTRA_THEME";
    private int themeNumber;

    private DrawerLayout drawer;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            themeNumber = savedInstanceState.getInt(EXTRA_THEME);

            switch (themeNumber) {
                case 0:
                    setTheme(R.style.AppTheme_NoActionBar_Purple);
                    break;
                case 1:
                    setTheme(R.style.AppTheme_NoActionBar_Green);
                    break;
            }
        }

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.open_drawer,
                R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragmentFrut_1 = Fragment1.newInstance();
        Fragment fragmentFrut_2 = Fragment2.newInstance();
        Fragment fragmentFrut_3 = Fragment3.newInstance();

        SectionPagerAdapter pagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        pagerAdapter.add(fragmentFrut_1, "фрукты");
        pagerAdapter.add(fragmentFrut_2, "овощи");
        pagerAdapter.add(fragmentFrut_3, "природа");

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_purple:
                themeNumber = 0;
                break;
            case R.id.action_green:
                themeNumber = 1;
                break;
        }
        recreate();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nav_frut:
                viewPager.setCurrentItem(0);
                break;
            case R.id.nav_vegetables:
                viewPager.setCurrentItem(1);
                break;
            case R.id.nav_nature:
                viewPager.setCurrentItem(2);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_THEME, themeNumber);
    }
}
