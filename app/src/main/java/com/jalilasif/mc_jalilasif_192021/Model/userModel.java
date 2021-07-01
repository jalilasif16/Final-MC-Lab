package com.jalilasif.mc_jalilasif_192021.Model;

public class userModel {
    String Name,Email,Password,Gender;

    public userModel(String name, String email, String password, String gender) {
        Name = name;
        Email = email;
        Password = password;
        Gender = gender;
    }

    public userModel() {
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getGender() {
        return Gender;
    }
}
