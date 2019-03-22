package com.example.fragmentsintro;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {


    TextView tvDesc;
    String [] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDesc = findViewById(R.id.tvDesc);

        descriptions = getResources().getStringArray(R.array.descriptions);

        // The phone is in portrait mode..
        if(findViewById(R.id.layout_portrait)!=null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.DetailsFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

        //The phone is in landscape mode.
        if(findViewById(R.id.layout_land)!=null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.DetailsFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        tvDesc.setText(descriptions[index]);
        //Phone in portrait mode.
        if(findViewById(R.id.layout_portrait)!=null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.DetailsFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
