package com.example.favouritelistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class subfavAdapter extends RecyclerView.Adapter<subfavViewHolder> {
    //in the second activity we add subcategory item into main category
    public Category ctgr;
    subfavAdapter(Category ch1){
        this.ctgr=ch1;
    }
    @NonNull
    @Override
    public subfavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutforsecondone,parent,false);
        return new subfavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull subfavViewHolder holder, int position) {
        //here we add the new item(subfavlist) in main category
holder.favval.setText(String.valueOf(ctgr.getItems().get(position)));
    }

    @Override
    public int getItemCount() {
        return ctgr.getItems().size();
    }
}
