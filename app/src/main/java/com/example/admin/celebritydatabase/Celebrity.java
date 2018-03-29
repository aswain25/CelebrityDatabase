package com.example.admin.celebritydatabase;

import java.io.Serializable;

/**
 * Created by Admin on 3/28/2018.
 */

public class Celebrity implements Serializable{
    int id;
    String firstName;
    String lastName;
    String title;

    public Celebrity(int id, String firstName, String lastName, String title) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int value)
    {
        id = value;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
