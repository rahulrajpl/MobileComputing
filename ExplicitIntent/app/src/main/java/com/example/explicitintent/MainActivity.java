package com.example.explicitintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText etName;
    Button btnA2, btnA3;
    TextView tvResults;
    final int ACTIVITY3 = 3; // Request for Activity 3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editText);
        btnA2 = findViewById(R.id.btnA2);
        btnA3 = findViewById(R.id.btnA3);
        tvResults = findViewById(R.id.tvResults);

        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    String name = etName.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this, com.example.explicitintent.Activity2.class);
                    intent.putExtra("name", name);

                    startActivity(intent);

                }

            }
        });

        btnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, com.example.explicitintent.Activity3.class);
            startActivityForResult(intent, ACTIVITY3 );

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY3){
            if (resultCode == RESULT_OK){
                tvResults.setText(data.getStringExtra("surname"));
            }
            if (resultCode == RESULT_CANCELED){
                tvResults.setText("No data received from Activity3");
            }
        }
    }
}
