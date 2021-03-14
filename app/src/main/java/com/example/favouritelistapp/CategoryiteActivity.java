package com.example.favouritelistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
//it is activity like mainactivity for second activity
public class CategoryiteActivity extends AppCompatActivity {
RecyclerView rlc;
    Category newcat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryite);
//collect the data from the intent
    newcat =(Category)getIntent().getSerializableExtra(MainActivity.CATEGORY_KEY);
        setTitle(newcat.getTitle());
        FloatingActionButton f1 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaycontent(newcat);
            }
        });
        rlc=findViewById(R.id.recyclerView);

        rlc.setLayoutManager(new LinearLayoutManager(CategoryiteActivity.this));
        rlc.setAdapter(new subfavAdapter(newcat));


    }
    public void displaycontent(final Category maincat){
        final EditText ed1=new EditText(this);
        ed1.setInputType(InputType.TYPE_CLASS_TEXT);
        new AlertDialog.Builder(this).
                setTitle("write subItem").setView(ed1).setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String itemname=ed1.getText().toString();
                //here we add the items in the itemslit of list
                maincat.getItems().add(itemname);
                //create reference of adapter to get change in adapter
                subfavAdapter adv=(subfavAdapter)rlc.getAdapter();
                //here we update the adapter to tell them one item you have to reflect
                adv.notifyItemInserted(maincat.getItems().size()-1);
                dialog.dismiss();
            }
        }).create().show();
    }
//its call when we tap back button
    @Override
    public void onBackPressed() {
        //here we create classs that contain all the data
        Bundle bl=new Bundle();
        //we save the data into b1 and give key as CATEGORY_KEY to collect the data further
        bl.putSerializable(MainActivity.CATEGORY_KEY,newcat);
        //here we create intent to go back to main activity to data
        Intent sec=new Intent();
        //send the data to previus activity
        sec.putExtras(bl);
        //here we use this resultok as a result code
        setResult(Activity.RESULT_OK,sec);
        super.onBackPressed();
    }
}