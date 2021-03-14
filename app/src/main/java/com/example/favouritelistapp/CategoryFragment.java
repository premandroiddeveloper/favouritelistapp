package com.example.favouritelistapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment implements newadapter.clicking{
//fragments are include charachter of activity
    //its having same lifecycle as activity in which they included
    //we get very flexibility by using of fragments
private RecyclerView r1;
    CategoryManager ct;

    @Override
    public void onAttach(@NonNull Context context) {
        if(context instanceof useclickeventofrecyclerview){
            clickka=(useclickeventofrecyclerview)context;
            ct=new CategoryManager(context);
            //here we retrive the data from shared preferences which are previusly stored by user so when user destroy app and run again he/she can able
            //to see all the datas on recyclerview

        }
        super.onAttach(context);
    }

    @Override
    public void viewisclicked(Category category) {
        clickka.clicktomain(category);
    }

    public void addCategoryToManager(Category ctl1) {
        ct.savecategory(ctl1);
        newadapter nlp=(newadapter) r1.getAdapter();
        nlp.addnote(ctl1);
    }

    public void saveCategory(Category serializableExtra) {
        ct.savecategory(serializableExtra);
        ArrayList<Category> mk1=ct.RetriveData();
        r1.setAdapter(new newadapter(mk1,this));
    }

    interface useclickeventofrecyclerview{
       void clicktomain(Category category);
   }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        ArrayList<Category> as1=ct.RetriveData();
        r1=(RecyclerView)getView().findViewById(R.id.Category_list);
        if(getView()!=null){
        r1.setLayoutManager(new LinearLayoutManager(getActivity()));
        //here as second argument we passing the context of the activity which is used my interface to know which activity is that
        r1.setAdapter(new newadapter(as1, (newadapter.clicking) this));}

        super.onActivityCreated(savedInstanceState);
    }

    private useclickeventofrecyclerview clickka;
    public CategoryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance() {
            return  new CategoryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}