package com.example.luizmattos_danielmachado_comp304sec003_lab5_ex1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ListView listView;
    ArrayList<String> typeList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        typeList.add("Italian");
        typeList.add("Greek");
        typeList.add("Chinese");
        typeList.add("Indian");
        typeList.add("Brazilian");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, typeList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("type", typeList.get(position));
        startActivity(intent);

    }


}