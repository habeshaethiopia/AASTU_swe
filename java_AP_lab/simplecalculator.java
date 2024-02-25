package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtFirstValue, txtSecondValue, txtResult;
    Button btnAdd, btnSubtract, btndivide, btnmulti;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFirstValue = (EditText) findViewById(R.id.txtFirstValue);
        txtSecondValue = (EditText) findViewById(R.id.txtSecondValue);
        txtResult = (EditText) findViewById(R.id.txtResult);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtruct);

    }
    public void Add(android.view.View parameter){
        int firstValue = Integer.valueOf(txtFirstValue.getText().toString());
        int secondValue =Integer.valueOf(txtSecondValue.getText().toString());
        int result = firstValue + secondValue;  

        txtResult.setText(String.valueOf(result));
    }
    public void Subtract(android.view.View parameter){
        int firstValue = Integer.valueOf(txtFirstValue.getText().toString());
        int secondValue =Integer.valueOf(txtSecondValue.getText().toString());
        int result = firstValue - secondValue;

        txtResult.setText(String.valueOf(result));
    }

}