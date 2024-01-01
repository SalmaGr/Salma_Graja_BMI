package com.example.salma_graja_bmi.Model;

public class BMIModel {
    public float calculateBMI(float weight, float height) {
        return weight / (height * height);
    }

    public String interpretBMI(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}