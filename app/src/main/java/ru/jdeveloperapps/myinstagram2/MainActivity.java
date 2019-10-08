package ru.jdeveloperapps.myinstagram2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = "myLog";

    private DrawerLayout drawer;
    private final List<CustModelCard> dataSource = new ArrayList<>();
    final CustRVAdapter adapter = new CustRVAdapter(dataSource);
    private FloatingActionButton fab;
    private RecyclerView rv;
    private DataSourceBuilder dataSourceBuilder;

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

        rv = findViewById(R.id.mRecyclerView);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayout);

        dataSourceBuilder = new DataSourceBuilder(getResources());
        setData(1);
        Log.d(TAG, "onCreate: ");

        adapter.SetOnLongClickListener(new CustRVAdapter.OnLongClickListener() {
            @Override
            public void onLongClick(View view, int position) {
                dataSource.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        rv.setAdapter(adapter);
        rv.setItemAnimator(new DefaultItemAnimator());

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.add(0, new CustModelCard("Картошка", "Картошка будет всегда", R.drawable.nature));
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setData(int n) {
        List<CustModelCard> data = dataSourceBuilder.build(n);
        dataSource.removeAll(dataSource);
        dataSource.addAll(data);
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
                setData(1);
                adapter.notifyDataSetChanged();
                Log.d(TAG, "onNavigationItemSelected: fruit");
                break;
            case R.id.nav_vegetables:
                setData(2);
                adapter.notifyDataSetChanged();
                Log.d(TAG, "onNavigationItemSelected: vegetables");
                break;
            case R.id.nav_nature:
                setData(3);
                adapter.notifyDataSetChanged();
                Log.d(TAG, "onNavigationItemSelected: nature");
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
