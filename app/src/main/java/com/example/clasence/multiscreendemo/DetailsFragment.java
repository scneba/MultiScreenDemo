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
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by clasence on 06,November,2018
 */
public class DetailsFragment extends Fragment implements DetailsAdapter.CustomRecyclerOnClick {
    private ArrayList<DetailsHelper> list = new ArrayList<>();
    //define recycler
    private RecyclerView recyclerView;
    private DetailsAdapter detailsAdapter;
    private DetailsRecyclerOnclick detailsRecyclerOnclick;
    //recycler manager
    RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.detail_recycler, container, false);

        String productName="";
        double price = 0.0;
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            productName = bundle.getString("name");
            price = bundle.getDouble("price");
        }
        //fill dummy data
        for(int i=0; i<10; i++){
            DetailsHelper detailsHelper = new DetailsHelper(i,productName+" "+i, price*(i+1));
            list.add(detailsHelper);
        }
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_details);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        detailsAdapter = new DetailsAdapter(getActivity(),list,DetailsFragment.this);
        recyclerView.setAdapter(detailsAdapter);

        return rootView;


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        try {
            detailsRecyclerOnclick = (DetailsRecyclerOnclick) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement CustomRecyclerOnClick");
        }
    }


    /**onclicklisterner for recycler view*/
    public interface DetailsRecyclerOnclick{
        void onRecyclerClick(int price);
    }


    @Override
    public void onCustomClick(int position, String product_name, double product_price) {
        detailsRecyclerOnclick.onRecyclerClick(position);
    }



}
