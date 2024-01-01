package com.example.salma_graja_bmi.Controller;

public class HeightAndWeightController {
    private static HeightAndWeightController instance;
    private int height;
    private double weight;

    private HeightAndWeightController() {
        // private constructor to ensure singleton pattern
    }

    public static HeightAndWeightController getInstance() {
        if (instance == null) {
            instance = new HeightAndWeightController();
        }
        return instance;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}