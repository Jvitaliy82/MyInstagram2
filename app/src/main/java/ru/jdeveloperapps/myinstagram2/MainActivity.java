package ru.jdeveloperapps.myinstagram2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = "myLog";

    private DrawerLayout drawer;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        image = findViewById(R.id.main_image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nav_frut:
                image.setVisibility(View.VISIBLE);
                image.setImageResource(R.drawable.fruit);
                Log.d(TAG, "onNavigationItemSelected: fruit");
                break;
            case R.id.nav_vegetables:
                image.setVisibility(View.VISIBLE);
                image.setImageResource(R.drawable.vegetables);
                Log.d(TAG, "onNavigationItemSelected: vegetables");
                break;
            case R.id.nav_nature:
                image.setVisibility(View.VISIBLE);
                image.setImageResource(R.drawable.nature);
                Log.d(TAG, "onNavigationItemSelected: nature");
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
