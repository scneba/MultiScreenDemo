package com.example.clasence.multiscreendemo;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Neba
 * Adapter for home recyclerview
 */

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MyViewHolder> {

    //activity and arraylist definitions
    private ArrayList<DetailsHelper> recipeList;
    private Activity context;
    private CustomRecyclerOnClick customRecyclerOnClick=null;

    // constructor
    public  DetailsAdapter(Activity context, ArrayList<DetailsHelper> list,CustomRecyclerOnClick customRecyclerOnClick){
        this.context=context;
        this.recipeList=list;
        this.customRecyclerOnClick = customRecyclerOnClick;
    }
    /**
     * Class implementation of viewholder to handle view of recycler*/

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_price;
        public ImageView imv_product_image;
        public RelativeLayout ll;

        public MyViewHolder(View view) {
            super(view);
            tv_price = (TextView) view.findViewById(R.id.tv_price);
            imv_product_image= view.findViewById(R.id.imv_product_img);
            ll = (RelativeLayout) itemView.findViewById(R.id.card_linear_layout);
        }
    }

    /**onclicklisterner for recycler view*/
    public interface CustomRecyclerOnClick{
        void onCustomClick(int position,String product_name, double product_price);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_view_helper, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final DetailsHelper detailsHelper = recipeList.get(position);
        holder.tv_price.setText(String.valueOf(detailsHelper.getPrice()));

        //check if there is an image url



        holder.imv_product_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(customRecyclerOnClick!=null){
                    customRecyclerOnClick.onCustomClick(position,detailsHelper.getName(), 1000.0*position);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

}
