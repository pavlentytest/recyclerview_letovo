package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> cities;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = new ArrayList<>(0);
        cities.add("Moscow");
        cities.add("St.Petersburg");
        cities.add("Helsinki");
        cities.add("Riga");
        cities.add("Vilnius");

        RecyclerView recyclerView = findViewById(R.id.cities);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this,cities);
        recyclerView.setAdapter(adapter);

        ExtendedFloatingActionButton btn_add = findViewById(R.id.floatingActionButton);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> items = new ArrayList<>();
                items.add("Paris");
                items.add("Berlin");
                cities.addAll(items);
                adapter.notifyItemRangeInserted(5,items.size());

            }
        });

    }
}
