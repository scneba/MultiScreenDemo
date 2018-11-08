package com.example.clasence.multiscreendemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MasterListFragment.RecyclerClickListerner, DetailsFragment.DetailsRecyclerOnclick{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = MasterAdapter.getFirstName();
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putDouble("price", 100*0.1);
        detailsFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_detail, detailsFragment)
                .commit();
    }



    @Override
    public void onRecyclerClick(int price) {
      showDetailsDialog();
    }

    @Override
    public void onCustomClick(int position, String name, double price) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putDouble("price", price);
        detailsFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_detail, detailsFragment)
                .commit();

    }



    public void showDetailsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = getLayoutInflater();

        View customView = layoutInflater.inflate(R.layout.custom_popup, null);
        // reference the textview of custom_popup_dialog
        //TextView tv = (TextView) customView.findViewById(R.id.tvpopup)
        builder.setView(customView);
        builder.create();
        builder.show();

    }
}
