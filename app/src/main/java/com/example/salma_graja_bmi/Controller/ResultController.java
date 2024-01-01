package com.example.salma_graja_bmi.Controller;

public class ResultController {
    private static ResultController instance;
    private double bmiValue;

    private ResultController() {
        // private constructor to ensure singleton pattern
    }

    public static ResultController getInstance() {
        if (instance == null) {
            instance = new ResultController();
        }
        return instance;
    }

    public void setBmiValue(double bmi) {
        this.bmiValue = bmi;
    }

    public double getBmiValue() {
        return bmiValue;
    }
}
