package com.androidhelper.flexilist;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public interface onConnectedWithFlexiList {
     void onListItemClicked(int index);
     void connectElements(View itemviev);
     void setElementsData(RecyclerView.ViewHolder flexholder,int position);
}
