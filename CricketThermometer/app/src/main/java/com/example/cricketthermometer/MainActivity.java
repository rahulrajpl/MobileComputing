package com.example.cricketthermometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnCalculate;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etChirps.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter number of Chirps", Toast.LENGTH_LONG).show();

                }
                else{
                    int nChirps = Integer.parseInt(etChirps.getText().toString().trim());
                    double temp = (nChirps/3)+4;
                    tvResult.setText(Double.toString(temp) + " degree celcius");
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
