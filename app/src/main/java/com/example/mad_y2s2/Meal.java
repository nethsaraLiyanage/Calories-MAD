package com.example.mad_y2s2;

public class Meal {



    private String uid;
    private String meal_type;
    private String food_name;
    private int gram_;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private int calories_;
    private String date;
    private Integer cabohydrate;
    private Integer protine;
    private Integer fat;
    private String key;

    public Meal() {

    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(String meal_type) {
        this.meal_type = meal_type;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getGram_() {
        return gram_;
    }

    public void setGram_(int gram_) {
        this.gram_ = gram_;
    }

    public int getCalories_() {
        return calories_;
    }

    public void setCalories_(int calories_) {
        this.calories_ = calories_;
    }

    public Integer getCabohydrate() {
        return cabohydrate;
    }

    public void setCabohydrate(Integer cabohydrate) {
        this.cabohydrate = cabohydrate;
    }

    public Integer getProtine() {
        return protine;
    }

    public void setProtine(Integer protine) {
        this.protine = protine;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }


}
