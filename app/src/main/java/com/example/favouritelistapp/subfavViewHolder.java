package com.example.favouritelistapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class subfavViewHolder extends RecyclerView.ViewHolder {
    TextView favval;
//it is holder of second activity
    public TextView getFavval() {
        return favval;
    }

    public void setFavval(TextView favval) {
        this.favval = favval;
    }

    public subfavViewHolder(@NonNull View itemView) {
        super(itemView);
        favval=itemView.findViewById(R.id.subfavourite);
    }
}
