package com.example.salma_graja_bmi.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.salma_graja_bmi.Controller.HeightAndWeightController;
import com.example.salma_graja_bmi.Controller.ResultController;
import com.example.salma_graja_bmi.Model.BMIModel;
import com.example.salma_graja_bmi.R;

public class ResultActivity extends AppCompatActivity {

    private ImageButton retourButton;
    private TextView bmiTextView;
    private ImageView curseurImageView;
    private TextView reponseTextView;
    private ResultController resultController;
    private BMIModel bmiModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        init();

        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retour à l'activité précédente
                finish();
            }
        });

        // Calculer le BMI et afficher les résultats
        double weight = HeightAndWeightController.getInstance().getWeight();
        int height = HeightAndWeightController.getInstance().getHeight();
        double bmiValue = bmiModel.calculateBMI((float) weight, height / 100.0f);
        String bmiInterpretation = bmiModel.interpretBMI((float) bmiValue);

        // Enregistrer le BMI dans le contrôleur
        resultController.setBmiValue(bmiValue);

        bmiTextView.setText(String.format("Your BMI: %.2f", bmiValue));
        reponseTextView.setText(String.format("Your weight is %s", bmiInterpretation));
    }

    private void init() {
        retourButton = findViewById(R.id.retour1);
        bmiTextView = findViewById(R.id.BMICalcul);
        curseurImageView = findViewById(R.id.curseur);
        reponseTextView = findViewById(R.id.Reponse);
        // Initialiser les contrôleurs
        resultController = ResultController.getInstance();
        bmiModel = new BMIModel();
    }
}
