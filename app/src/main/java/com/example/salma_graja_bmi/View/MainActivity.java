package com.example.salma_graja_bmi.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.salma_graja_bmi.Controller.GenderController;
import com.example.salma_graja_bmi.R;
import androidx.appcompat.widget.AppCompatRadioButton;


public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton maleRadioButton, femaleRadioButton;
    private Button nextButton;
    private TextView resultTextView;
    private GenderController genderController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String gender = "";

                if (selectedId == R.id.male) {
                    gender = "Male";
                } else if (selectedId == R.id.female) {
                    gender = "Female";
                }

                if (!gender.isEmpty()) {
                    // Save gender to controller
                    genderController.setGender(gender);

                    // Navigate to next activity
                    Intent intent = new Intent(MainActivity.this, HeightAndWeightActivity.class);
                    startActivity(intent);
                } else {
                    // Show a message if no gender selected
                    resultTextView.setText("Please select your gender.");
                }
            }
        });
    }
    private void init() {
        radioGroup = findViewById(R.id.radioGroup);
        maleRadioButton = findViewById(R.id.male);
        femaleRadioButton = findViewById(R.id.female);
        nextButton = findViewById(R.id.next);
        resultTextView = findViewById(R.id.result);

        // Initialize GenderController
        genderController = GenderController.getInstance();
    }

}