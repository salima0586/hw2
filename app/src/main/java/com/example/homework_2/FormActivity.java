package com.example.homework_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private int pos;
    private String title;
    private Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editText = findViewById(R.id.ed_name);
        button = findViewById(R.id.btn_save);
        Intent i = getIntent();
        title = i.getStringExtra("title");
        pos = i.getIntExtra("pos", 0);
        Toast.makeText(this,"posTitle "+ pos ,Toast.LENGTH_SHORT).show();
        editText.setText(title);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    save();
            }
        });
    }


    private void save() {
        title = editText.getText().toString();
        Intent intent = new Intent(FormActivity.this, MainActivity.class);
        intent.putExtra("name",title);
        intent.putExtra("pos",pos);
        setResult(RESULT_OK, intent);
        finish();
    }
}