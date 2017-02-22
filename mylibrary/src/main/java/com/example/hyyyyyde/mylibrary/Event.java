package com.example.hyyyyyde.mylibrary;


import java.io.Serializable;

/**
 * ただのValue Object
 */
public class Event implements Serializable {
    private String number;

    public String getNumber() {
        return number;
    }

    void setNumber(String number) {
        this.number = number;
    }
}
