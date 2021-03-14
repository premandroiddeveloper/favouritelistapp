package com.example.favouritelistapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//its main clas to manipulate the data of shared preferences
public class CategoryManager {
    //here we create context because we need it when we have to check that which activity passing the data into shared preferences
    Context macon;
    CategoryManager(Context mon){
        this.macon =mon;
    }
    //Save the data to Shared Preferences
    public void savecategory(Category category){
        //preference manager is used to get the object of sharedpreferenses
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(macon);
        //we create editor to apply change in Shared Preferences
        SharedPreferences.Editor ed1=sharedPreferences.edit();
        HashSet itemnames=new HashSet(category.getItems());
        //putting all the data into editor class of shared Preferences
        ed1.putStringSet(category.getTitle(),itemnames);
        ed1.apply();
    }
    //Retrive the Data From Sharedpreferences
    public ArrayList<Category> RetriveData(){
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(macon);
        //map is use to retrive all the data from the category
        Map<String,?> data=sharedPreferences.getAll();
        ArrayList<Category> finalcategory=new ArrayList<>();
        for(Map.Entry<String,?> entry:data.entrySet()){
            Category finalone=new Category(entry.getKey(),new ArrayList<String>((HashSet)entry.getValue()));
            finalcategory.add(finalone);
        }
        return finalcategory;
    }
}
