package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdaptor.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button btnAdd;

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvList);
        btnAdd = findViewById(R.id.btnAdd);


        recyclerView.setHasFixedSize(true);// Recycler view is changing as per size of the items in it.
//        layoutManager = new LinearLayoutManager(this);
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        layoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Rahul", "Raj", "bus"));
        people.add(new Person("Paru", "Pa", "plane"));
        people.add(new Person("Kiran", "Yoo", "bus"));
        people.add(new Person("Tom", "Keeto", "plane"));
        people.add(new Person("Some", "Minum", "plane"));

        myAdapter = new PersonAdaptor(this, people);// goes to PerAdapter and set it to myadapter

        recyclerView.setAdapter(myAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Test", "Name","bus"));
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Clicked on Item:"+ Integer.toString(index+1), Toast.LENGTH_SHORT).show();
    }
}
