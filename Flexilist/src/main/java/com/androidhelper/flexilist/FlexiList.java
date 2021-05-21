package com.androidhelper.flexilist;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlexiList  {

    RecyclerView viewContainer;
    ArrayList<Object> data;
    Context context;
    int layout;
    RecyclerView.LayoutManager layoutManager;
    public FlexiList(Context context, RecyclerView container, ArrayList<Object> arrayList, int rowlayout, RecyclerView.LayoutManager layoutManager) {
        this.data=arrayList;
        this.viewContainer=container;
        this.context=context;
        this.layoutManager=layoutManager;
        this.layout=rowlayout;
    }

    public void getReadyAdapter(){

        FlexilistAdapter adapter=new FlexilistAdapter(context,data,layout);
        viewContainer.setAdapter(adapter);
        viewContainer.setLayoutManager(layoutManager);

    }

}
