package com.example.hp.wbutcollegeselector;

import java.io.Serializable;

/**
 * Created by hp on 27-07-2017.
 */

public class Admin implements Serializable{

private String name;

    private String email;

    public Admin(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
