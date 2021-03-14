package com.example.favouritelistapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ViewHolder extends RecyclerView.ViewHolder {
    //its a holder of a simple mainactivity
    TextView t1;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        t1=(TextView)itemView.findViewById(R.id.textView);
    }

    public TextView getT1() {
        return t1;
    }

    public void setT1(TextView t1) {
        this.t1 = t1;
    }
}
