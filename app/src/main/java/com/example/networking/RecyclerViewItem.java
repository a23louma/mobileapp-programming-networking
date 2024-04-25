package com.example.networking;

import com.google.gson.annotations.SerializedName;

public class RecyclerViewItem {
    @ SerializedName ("name")
    private String title;
    private String location;
    @ SerializedName ("size")
    private int heightInMeters;
    @ SerializedName ("cost")
    private int heightInFeet;

    public RecyclerViewItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getHeightInMeters() {
        return heightInMeters;
    }

    public int getHeightInFeet() {
        return heightInFeet;
    }

    @Override
    public String toString() {
        return "Namn: " + title + "\n" +
                "Plats: " + location + "\n" +
                "Höjd i meter: " + heightInMeters + "\n" +
                "Höjd i feet: " + heightInFeet + "\n";
    }
}
