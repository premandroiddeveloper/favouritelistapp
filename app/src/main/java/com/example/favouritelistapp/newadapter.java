package com.example.favouritelistapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
//it is the adapter for MAIN Activity
public class newadapter extends RecyclerView.Adapter<ViewHolder> {
    //here we create Arraylist of category because we have to collect all the data of category title and items also
ArrayList<Category> cats=new ArrayList<>();
//initialization of cllickinfg interface
public clicking cl1;
//we create this because we want to get notufy when user click any category from the recyclerview and we can not get direct reference of main activity
    //from this class so we create interface so we can get the referense of mainactivity by implimenting this interface in mainactivity
    public interface  clicking{
        void viewisclicked(Category category);
    }

    public newadapter(ArrayList<Category> cats,/*here we get the referense of mainactivity to notify click event*/clicking cliks) {
        this.cats = cats;
        this.cl1=cliks;


    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ll1=LayoutInflater.from(parent.getContext());
        View view=ll1.inflate(R.layout.layout_1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
holder.getT1().setText(cats.get(position).getTitle());
Log.i("printitn",cats.get(position).getTitle());
//its call when user tap on any itemview(category) from the recyclerview
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //this viewisclicked method called and which is implimenting on mainactivity
        cl1.viewisclicked(cats.get(position));
    }
});
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public void addnote(Category ctl1) {
        cats.add(ctl1);
      notifyItemInserted(cats.size()-1);
    }
}
