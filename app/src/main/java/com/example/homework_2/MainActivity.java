package com.example.homework_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    Adapter adapter;
    private boolean toUpdate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.btn_trans);
        recyclerView = findViewById(R.id.rv_recycler);
        ArrayList<Model> list = new ArrayList<>();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toUpdate = false;
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        adapter = new Adapter();
        adapter.setList(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("name");
            adapter.addAdapter(new Model(title));
        }
//        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
//            int pos = data.getIntExtra("pos",0);
//            Toast.makeText(this,"posT"+pos,Toast.LENGTH_SHORT).show();
//            String tit = data.getStringExtra("update");
//            Model model = new Model(tit);
//            adapter.updateItem(model,pos);
//        }
    }

}