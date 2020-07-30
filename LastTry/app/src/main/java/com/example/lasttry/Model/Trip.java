package com.example.lasttry.Model;

public class Trip {
    private String Title;
    private String Description;
    private int image;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Trip(String title, String description, int image) {
        Title = title;
        Description = description;
        this.image = image;
    }


}
