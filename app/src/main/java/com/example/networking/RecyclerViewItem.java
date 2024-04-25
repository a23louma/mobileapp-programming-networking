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

    @Override
    public String toString() {
        return "RecyclerViewItem{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", heightInMeters=" + heightInMeters +
                ", heightInFeet=" + heightInFeet +
                '}';
    }
}
