package com.example.salma_graja_bmi.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.salma_graja_bmi.Controller.HeightAndWeightController;
import com.example.salma_graja_bmi.R;

public class HeightAndWeightActivity extends AppCompatActivity {

    private ImageButton retourButton;
    private SeekBar heightSeekBar;
    private EditText weightEditText;
    private ImageView filleImageView;
    private Button resultButton;
    private TextView heightValueTextView;  // Ajout de la déclaration

    private HeightAndWeightController hwController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_and_weight);

        init();

        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retour à l'activité précédente
                finish();
            }
        });

        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged " + progress);
                // Affichage dans le Log de Android Studio pour voir les changements détectés sur le SeekBar
                heightValueTextView.setText(String.valueOf("Height : " + progress));
                // Mise à jour du TextView par la valeur : progress à chaque changement
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekbar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer la taille et le poids
                int height = heightSeekBar.getProgress();
                double weight;

                try {
                    weight = Double.parseDouble(weightEditText.getText().toString());
                } catch (NumberFormatException e) {
                    // Afficher un Toast indiquant que le poids doit être un nombre valide
                    Toast.makeText(HeightAndWeightActivity.this, "Please enter a valid weight", Toast.LENGTH_SHORT).show();
                    return;  // Quitter la méthode onClick si le poids n'est pas valide
                }

                // Vérifier si la taille est égale à 0
                if (height == 0) {
                    // Afficher un Toast indiquant que la taille doit être supérieure à 0
                    Toast.makeText(HeightAndWeightActivity.this, "Please select a height greater than 0", Toast.LENGTH_SHORT).show();
                    return;  // Quitter la méthode onClick si la taille est égale à 0
                }

                // Enregistrer la taille et le poids dans le contrôleur
                hwController.setHeight(height);
                hwController.setWeight(weight);

                // Passer à l'activité suivante (ResultActivity)
                Intent intent = new Intent(HeightAndWeightActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        retourButton = findViewById(R.id.retour);
        heightSeekBar = findViewById(R.id.seekBarHeight);
        weightEditText = findViewById(R.id.weight);
        filleImageView = findViewById(R.id.fille);
        resultButton = findViewById(R.id.result);
        heightValueTextView = findViewById(R.id.heightValueTextView);  // Initialisation de la référence

        // Initialiser le contrôleur
        hwController = HeightAndWeightController.getInstance();

        // Définir la progression maximale pour le SeekBar
        heightSeekBar.setMax(220);
    }
}
