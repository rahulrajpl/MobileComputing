package com.example.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {


    EditText etName;
    Button btnSubmit,btnCancelled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancelled = findViewById(R.id.btnCancelled);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (etName.getText().toString().isEmpty()){
                Toast.makeText(Activity3.this, getString(R.string.enterfields), Toast.LENGTH_SHORT).show();
            }

            else{
                String surname = etName.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("surname",surname);
                setResult(RESULT_OK,intent);
                Activity3.this.finish();
            }
            }
        });

        btnCancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });
    }
}
