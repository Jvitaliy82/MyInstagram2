package ru.jdeveloperapps.myinstagram2.fragments.fruts;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.jdeveloperapps.myinstagram2.CustModelCard;
import ru.jdeveloperapps.myinstagram2.CustRVAdapter;
import ru.jdeveloperapps.myinstagram2.DataSourceBuilder;
import ru.jdeveloperapps.myinstagram2.R;

public class FragmentFrut3 extends Fragment {

    private final List<CustModelCard> dataSource = new ArrayList<>();
    final CustRVAdapter adapter = new CustRVAdapter(dataSource);
    private RecyclerView rv;
    private DataSourceBuilder dataSourceBuilder;

    public static FragmentFrut3 newInstance() {
        FragmentFrut3 fragment = new FragmentFrut3();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frut1, container, false);

        rv = v.findViewById(R.id.mRecyclerView);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayout);

        dataSourceBuilder = new DataSourceBuilder(getResources());
        setData(3);
        rv.setAdapter(adapter);

        return v;
    }

    private void setData(int n) {
        List<CustModelCard> data = dataSourceBuilder.build(n);
        dataSource.removeAll(dataSource);
        dataSource.addAll(data);
    }
}
