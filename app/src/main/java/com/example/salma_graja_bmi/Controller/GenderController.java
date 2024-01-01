package com.example.salma_graja_bmi.Controller;

public class GenderController {
    private static GenderController instance;
    private String selectedGender;

    private GenderController() {
        // private constructor to ensure singleton pattern
    }

    public static GenderController getInstance() {
        if (instance == null) {
            instance = new GenderController();
        }
        return instance;
    }

    public void setGender(String gender) {
        this.selectedGender = gender;
    }

    public String getGender() {
        return selectedGender;
    }

}
