package com.example.salma_graja_bmi.Model;

public class BMIModel {
    public float calculateBMI(float weight, float height) {
        return weight / (height * height);
    }

    public String interpretBMI(float bmi) {
        if (bmi < 18.5) {
            return "Insuffisance pondérale";
        } else if (bmi < 24.9) {
            return "Poids normal";
        } else if (bmi < 29.9) {
            return "Surpoids";
        } else {
            return "Obésité";
        }
    }
}
