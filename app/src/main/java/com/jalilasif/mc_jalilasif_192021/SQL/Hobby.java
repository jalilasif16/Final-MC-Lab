package com.jalilasif.mc_jalilasif_192021.SQL;

public class Hobby {

    String hobby,description;

    public Hobby(String hobby, String description) {
        this.hobby = hobby;
        this.description = description;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}