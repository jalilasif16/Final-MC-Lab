package com.jalilasif.mc_jalilasif_192021.Model;

public class fragmodel {

    private String title;
    private String description;


    public fragmodel(int image, String title, String description) {
        this.title = title;
        this.description = description;

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

}
