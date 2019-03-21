package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button equals;
    private Button clear;
    private Button divide;
    private Button multiply;
    private Button add;
    private Button sub;
    private TextView control;
    private TextView result;
    private char ACTION;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = '=';

    private double val1 = Double.NaN; // for result text view
    private double val2; //for control text view


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetupUIViews();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Compute();
                ACTION = ADDITION;

                result.setText(String.valueOf(val1) + '+');
                control.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Compute();
                ACTION = SUBTRACTION;

                result.setText(String.valueOf(val1) + '-');
                control.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Compute();
                ACTION = MULTIPLICATION;

                result.setText(String.valueOf(val1) + '*');
                control.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Compute();
                ACTION = DIVISION;

                result.setText(String.valueOf(val1) + '/');
                control.setText(null);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compute();
                ACTION = EQUAL;

                //5 + 4 = 9
                result.setText(result.getText().toString() + String.valueOf(val2) + '=' + String.valueOf(val1));
                control.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().length() > 0){
                    CharSequence name = control.getText().toString();
                    control.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    control.setText(null);
                    result.setText(null);
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 0);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 1);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 2);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + 9);
            }
        });
    }

    private void Compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(control.getText().toString());
            switch (ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQUAL:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(control.getText().toString());

        }
    }

    private void SetupUIViews(){
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        clear = (Button)findViewById(R.id.btn_clear);
        equals = (Button)findViewById(R.id.btn_eql);
        divide = (Button)findViewById(R.id.btn_divide);
        multiply = (Button)findViewById(R.id.btn_multiply);
        add = (Button)findViewById(R.id.btn_add);
        sub = (Button)findViewById(R.id.btn_sub);
        control = (TextView)findViewById(R.id.txt_control);
        result = (TextView)findViewById(R.id.txt_result);
    }
}
