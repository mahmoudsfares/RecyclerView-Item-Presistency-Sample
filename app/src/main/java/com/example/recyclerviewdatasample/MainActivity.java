package com.example.recyclerviewdatasample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> things = new ArrayList<>();
        things.add("Jason Momoa");
        things.add("Poland");
        things.add("Islam");
        things.add("Running");
        things.add("Hair");
        things.add("Apostrophe");
        things.add("Ethnic");
        things.add("Ribery");
        things.add("HAM");
        things.add("Computers");
        things.add("Sing");
        things.add("Asia");
        things.add("Coffee");
        things.add("Keyboard");
        things.add("Red car");
        things.add("Shoes");
        things.add("Pineapple");
        things.add("Table");
        things.add("Dance floor");
        things.add("lagging");
        things.add("bathroom");
        things.add("doctors");
        things.add("Black");
        things.add("roses");
        things.add("java");
        things.add("narcissism");
        things.add("rock");

        RecyclerView rv = findViewById(R.id.recyclerview);
        Button btn = findViewById(R.id.button);
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), new SimpleAdapter.ItemClickListener() {
            @Override
            public void onItemClickListener(int clickedPosition) {
                Toast.makeText(MainActivity.this, ""+clickedPosition, Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);

        adapter.setAdapterData(things);
        rv.setAdapter(adapter);
        rv.setLayoutManager(manager);
    }
}