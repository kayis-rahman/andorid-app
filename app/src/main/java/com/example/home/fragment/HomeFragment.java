package com.example.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home.MainRecyclerItemDecorator;
import com.example.home.MockData;
import com.example.home.R;
import com.example.home.adapter.MainRecyclerAdapter;

import lombok.NoArgsConstructor;

/**
 * Fragment handler for Home tab
 *
 * @author Kayis Rahman
 * @since 1.0.0
 */
@NoArgsConstructor
public class HomeFragment extends Fragment {
    private Context context;
    private RecyclerView mainRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mainRecycler = view.findViewById(R.id.main_recycler);
        context = view.getContext();

        setMainRecycler();
        return view;
    }

    /**
     *  Initiating mainRecycler layout with vertical RecyclerView.LayoutManager and mapping data with MainRecyclerAdapter.class
     *
     * @author Kayis Rahman
     * @since 1.0.0
     */
    private void setMainRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);

        mainRecycler.setLayoutManager(layoutManager);
        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(context, MockData.ALL_DATA);
        mainRecycler.setAdapter(mainRecyclerAdapter);
        mainRecycler.addItemDecoration(new MainRecyclerItemDecorator(context, 50));
    }
}