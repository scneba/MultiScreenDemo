package com.example.clasence.multiscreendemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by clasence on 06,November,2018
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */
public class MasterListFragment extends Fragment implements MasterAdapter.CustomRecyclerOnClick {
    private ArrayList<String> list = new ArrayList<>();
    //define recycler
    private RecyclerView recyclerView;
    private MasterAdapter masterAdapter;
    private RecyclerClickListerner recyclerClickListerner;

    //recycler manager
    RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.master_recycler, container, false);

       //fill dummy data
        for(int i=0; i<10; i++){
            list.add("Product "+i);
        }
        recyclerView = (RecyclerView) rootView.findViewById(R.id.detail_view_recycler);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        masterAdapter = new MasterAdapter(getActivity(),list,MasterListFragment.this);
        recyclerView.setAdapter(masterAdapter);

        return rootView;


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        try {
            recyclerClickListerner = (RecyclerClickListerner) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement CustomRecyclerOnClick");
        }
    }

    @Override
    public void onCustomClick(int position, String name, double price) {
        recyclerClickListerner.onCustomClick(position,name,price);
    }

    /**onclicklisterner for recycler view*/
    public interface RecyclerClickListerner{
        void onCustomClick(int position, String name, double price);
    }

}
