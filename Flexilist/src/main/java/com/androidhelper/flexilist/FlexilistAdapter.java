package com.androidhelper.flexilist;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlexilistAdapter extends RecyclerView.Adapter<FlexilistAdapter.Flexiholder> {

    ArrayList<Object>dataList;
    Context context;
    onConnectedWithFlexiList connectionView;
    int listLayout;

    public FlexilistAdapter( Context context,ArrayList<Object> dataList,int LayoutFile) {
        this.dataList = dataList;
        this.context = context;
        this.listLayout=LayoutFile;
        connectionView= (onConnectedWithFlexiList) context;
    }

    @NonNull
    @Override
    public Flexiholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(listLayout,parent,false);
        return new Flexiholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Flexiholder holder, int position) {
        connectionView.setElementsData(holder,position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class Flexiholder extends RecyclerView.ViewHolder{

        public Flexiholder(@NonNull View itemView) {
            super(itemView);
            connectionView.connectElements(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    connectionView.onListItemClicked(getAbsoluteAdapterPosition());
                }
            });
        }
    }
}
