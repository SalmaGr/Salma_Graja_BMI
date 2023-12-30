package com.example.salma_graja_bmi.Controller;

import com.example.salma_graja_bmi.Model.BMIModel;

public class BMIController {
    private BMIModel model;

    public BMIController() {
        model = new BMIModel();
    }

    public String calculateAndInterpretBMI(float weight, float height) {
        float bmi = model.calculateBMI(weight, height);
        return model.interpretBMI(bmi);
    }
}
