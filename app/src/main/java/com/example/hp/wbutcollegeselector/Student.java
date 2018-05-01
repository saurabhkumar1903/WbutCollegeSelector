package com.example.hp.wbutcollegeselector;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by hp on 27-07-2017.
 */

public class Student implements Serializable {
    private String name;
    private String gender;
    private String username;
    private String wbroll;
    private String email;
    private String password;
    private String wbrank;

    public Student(String name, String gender, String username, String wbroll, String email, String password,String wbrank) {
        this.name = name;
        this.gender = gender;
        this.username = username;
        this.wbroll = wbroll;
        this.email = email;
        this.password = password;
        this.wbrank = wbrank;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWbrank() {
        return wbrank;
    }

    public void setWbrank(String wbrank) {
        this.wbrank = wbrank;
    }

    public String getGender() {
        return gender;

    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWbroll() {
        return wbroll;
    }

    public void setWbroll(String wbroll) {
        this.wbroll = wbroll;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
