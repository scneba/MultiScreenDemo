package com.example.clasence.multiscreendemo;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Neba.
 * Adapter for home recyclerview
 */

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.MyViewHolder> {

    //activity and arraylist definitions
    private Activity context;
    private CustomRecyclerOnClick customRecyclerOnClick=null;
    private static ArrayList<String> list;

    // constructor
    public  MasterAdapter(Activity context, ArrayList<String> in_list, CustomRecyclerOnClick customRecyclerOnClick){
        this.context=context;
        this.list=in_list;
        this.customRecyclerOnClick = customRecyclerOnClick;
    }
    /**
     * Class implementation of viewholder to hangle view of recycler*/

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name;
        public RelativeLayout ll;

        public MyViewHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.recipe_name);
            ll = (RelativeLayout) itemView.findViewById(R.id.card_linear_layout);
        }
    }

    /**onclicklisterner for recycler view*/
    public interface CustomRecyclerOnClick{
        void onCustomClick(int position, String name, double price);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.master_recycler_helper, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

            final String choice = list.get(position);
            holder.tv_name.setText( choice);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customRecyclerOnClick.onCustomClick(position, choice, position>0?100*position: 100*0.1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  String getFirstName(){
        return list.get(0);
    }

}
