package ru.jdeveloperapps.myinstagram2.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.jdeveloperapps.myinstagram2.R;
import ru.jdeveloperapps.myinstagram2.fragments.fruts.FragmentBottomFrut1;
import ru.jdeveloperapps.myinstagram2.fragments.fruts.FragmentBottomFrut2;


public class Fragment2 extends Fragment {

    private final String TAG = "myLog";
    private FragmentBottomFrut1 fragmentBottomFrut1;
    private FragmentBottomFrut2 fragmentBottomFrut2;
    private FragmentManager fragmentManager;

    public static Fragment2 newInstance() {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frut2, container, false);
        fragmentBottomFrut1 = FragmentBottomFrut1.newInstance();
        fragmentBottomFrut2 = FragmentBottomFrut2.newInstance();

        fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerFrame, fragmentBottomFrut1);
        fragmentTransaction.commit();

        BottomNavigationView bnv = v.findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_frut_sibiria:
                        Log.d(TAG, "onNavigationItemSelected: sib");
                        FragmentTransaction fragmentTransaction1Sib = fragmentManager.beginTransaction();
                        fragmentTransaction1Sib.replace(R.id.containerFrame, fragmentBottomFrut1);
                        fragmentTransaction1Sib.commit();
                        return true;
                    case R.id.menu_frut_tropic:
                        Log.d(TAG, "onNavigationItemSelected: trop");
                        FragmentTransaction fragmentTransactionTropic = fragmentManager.beginTransaction();
                        fragmentTransactionTropic.replace(R.id.containerFrame, fragmentBottomFrut2);
                        fragmentTransactionTropic.commit();
                        return true;
                }
                return false;
            }
        });
        return v;
    }

}
