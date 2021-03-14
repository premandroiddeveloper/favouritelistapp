package com.example.favouritelistapp;

import java.io.Serializable;
import java.util.ArrayList;
//this is clSS WHICH Used to Store the data in Shared Preference
public class Category implements Serializable {
    //title its initial name of list
    public String title;
    //its all items which contain inside this list#sublist
    public ArrayList<String> items;

    public Category(String title, ArrayList<String> items) {
        this.title = title;
        this.items = items;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getItems() {
        return items;
    }
}
