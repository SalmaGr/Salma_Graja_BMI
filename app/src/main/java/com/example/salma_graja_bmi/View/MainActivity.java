package com.example.salma_graja_bmi.View;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.salma_graja_bmi.Controller.BMIController;
import com.example.salma_graja_bmi.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private Button btnCalculate;
    private TextView textViewResult;


    private BMIController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.Weight);
        editTextHeight = findViewById(R.id.Height);
        btnCalculate = findViewById(R.id.btnCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        controller = new BMIController();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndDisplayBMI();
            }
        });
    }

    private void calculateAndDisplayBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr);

            String result = controller.calculateAndInterpretBMI(weight, height);

            displayResult(result);
        } else {
            textViewResult.setText("Veuillez entrer le poids et la taille.");
        }
    }

    private void displayResult(String result) {
        textViewResult.setText("Interprétation: " + result);
    }
}
