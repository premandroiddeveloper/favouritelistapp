package com.example.favouritelistapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CategoryFragment.useclickeventofrecyclerview{
   // private RecyclerView r1;
FloatingActionButton fab;
ArrayList<Category> as1;
private CategoryFragment mcategoryfragment=CategoryFragment.newInstance();
//CategoryManager ct;
public static final String CATEGORY_KEY="10000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frames,mcategoryfragment).commit();
      /*  ct=new CategoryManager(MainActivity.this);
        //here we retrive the data from shared preferences which are previusly stored by user so when user destroy app and run again he/she can able
        //to see all the datas on recyclerview
       as1=ct.RetriveData();
        r1=(RecyclerView)findViewById(R.id.Category_list);
        r1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //here as second argument we passing the context of the activity which is used my interface to know which activity is that
        r1.setAdapter(new newadapter(as1, (newadapter.clicking) MainActivity.this));*/
        fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           fabtapped();
            }
        });
    }
//we inflate our option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    //now create the alert view when fab is tapped
    public void fabtapped(){
        AlertDialog.Builder alerts=new AlertDialog.Builder(this);
        alerts.setTitle("Enter Your New Favourite Thing");
        final EditText ed1=new EditText(this);
        ed1.setInputType(InputType.TYPE_CLASS_TEXT);
        alerts.setView(ed1);
        alerts.setPositiveButton("create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //here ae start to save the data to category class my calling it
                //also here we passing empty arraylist because we dont need any sublit at this time
                Category ctl1=new Category(ed1.getText().toString(),new ArrayList<String>());
                //and we save this categories into sharedpreferences
                mcategoryfragment.addCategoryToManager(ctl1);
               /* newadapter al1=(newadapter)r1.getAdapter();
                al1.addnote(ctl1);
                dialog.dismiss();*/
                //whenever we enter new category by alert diologue its all and pass all the data to next activity and we goto the next activity of sublist
                dataShares(ctl1);
                Toast.makeText(MainActivity.this,"Its done/new Item Added",Toast.LENGTH_SHORT).show();
            }
        });
        alerts.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                dialog.dismiss();
                Toast.makeText(MainActivity.this,"you Tapped Cancel no new thing is Added",Toast.LENGTH_SHORT).show();
            }
        });
        alerts.create().show();


    }
    public void dataShares(Category cat){
        Intent i1=new Intent(MainActivity.this,CategoryiteActivity.class);
        i1.putExtra(CATEGORY_KEY,cat);
        startActivityForResult(i1,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1000 && resultCode== Activity.RESULT_OK){
            if(data!=null){
                //we first save the items which newly added
                /*ct.savecategory((Category)data.getSerializableExtra(CATEGORY_KEY));*/
                //then we retrive all the data fromcategory manager and update our recycler view using setAdapter tech
                //ArrayList<Category> mk1=ct.RetriveData();
               // r1.setAdapter(new newadapter(mk1,this));
                mcategoryfragment.saveCategory((Category)data.getSerializableExtra(CATEGORY_KEY));


            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void clicktomain(Category category) {
        dataShares(category);
    }
    //here we use method of interface which  we used to get reference of main activity
    //and this method called dataShares method ,which  transist from mainactivity to second activity to add the sublit element of category
    /*public void viewisclicked(Category category) {
dataShares(category);
    }*/

}