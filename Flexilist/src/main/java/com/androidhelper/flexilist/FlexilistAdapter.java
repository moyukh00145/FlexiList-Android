package com.androidhelper.flexilist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.androidhelper.flexilist.FlexiList.ONE_TEXT_VIEW;
import static com.androidhelper.flexilist.FlexiList.TWO_TEXT_VIEW;
import static com.androidhelper.flexilist.FlexiList.ONE_TEXT_VIEW_ONE_IMAGE;
import static com.androidhelper.flexilist.FlexiList.TWO_TEXT_VIEW_ONE_IMAGE;

public class FlexilistAdapter extends RecyclerView.Adapter<com.androidhelper.flexilist.FlexilistAdapter.Flexiholder> {

   Context context;
  private ArrayList<Object>data1;
   private ArrayList<Object>data2;
   private ArrayList<Object>imgurl;
   private int layout;
   private int uniqueId;
    onConnectedWithFlexiList onConnectedWithFlexiList;
    static onLongClicked onlongclicked;

    static FlexilistAdapter adapter_new;




    public FlexilistAdapter(@NonNull Context context) {
       Log.w("First constructor","called");
        this.context=context;
    }


    public FlexilistAdapter(@NonNull Context context,int uniqueId ,int layout_type, @NonNull ArrayList<Object>TextView1Data,onConnectedWithFlexiList onConnectedWithFlexiList) {
        this.context=context;
        this.data1=TextView1Data;
        this.layout=layout_type;
        this.uniqueId=uniqueId;
        this.onConnectedWithFlexiList=onConnectedWithFlexiList;

    }

    public FlexilistAdapter(@NonNull Context context,int uniqueId, int layout_type, @NonNull ArrayList<Object>TextView1Data, @NonNull ArrayList<Object>TextView2Data,onConnectedWithFlexiList onConnectedWithFlexiList) {
        this.context=context;
        this.data1=TextView1Data;
        this.data2=TextView2Data;
        this.layout=layout_type;
        this.uniqueId=uniqueId;
        this.onConnectedWithFlexiList=onConnectedWithFlexiList;
    }

    public FlexilistAdapter(@NonNull Context context,int uniqueId, int layout_type,@NonNull ArrayList<Object>TextView1Data, @NonNull ArrayList<Object>imageUrl, boolean imageContains,onConnectedWithFlexiList onConnectedWithFlexiList) {
        this.context=context;
        this.data1=TextView1Data;
        this.imgurl=imageUrl;
        this.layout=layout_type;
        this.uniqueId=uniqueId;
        this.onConnectedWithFlexiList=onConnectedWithFlexiList;

    }

    public FlexilistAdapter(@NonNull Context context,int uniqueId, int layout_type, @NonNull ArrayList<Object>TextView1Data, @NonNull ArrayList<Object>TextView2Data, @NonNull ArrayList<Object>imageUrl,onConnectedWithFlexiList onConnectedWithFlexiList) {
        this.context=context;
        this.data1=TextView1Data;
        this.data2=TextView2Data;
        this.imgurl=imageUrl;
        this.layout=layout_type;
        this.uniqueId=uniqueId;
        this.onConnectedWithFlexiList=onConnectedWithFlexiList;
    }




    @NonNull
    @Override
    public Flexiholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(layout,parent,false);
        return new Flexiholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Flexiholder holder, int position) {

        switch (uniqueId){
            case ONE_TEXT_VIEW:{
               holder.tv1.setText(data1.get(position).toString());
            }
            break;
            case TWO_TEXT_VIEW:{
                holder.tv2.setText(data1.get(position).toString());
                holder.tv3.setText(data2.get(position).toString());
            }
            break;
            case ONE_TEXT_VIEW_ONE_IMAGE:{
                holder.tv4.setText(data1.get(position).toString());
                Glide.with(context).load(imgurl.get(position)).into(holder.imv1);

            }
            break;
            case TWO_TEXT_VIEW_ONE_IMAGE:{
                holder.tv5.setText(data1.get(position).toString());
                holder.tv6.setText(data2.get(position).toString());
                Glide.with(context).load(imgurl.get(position)).into(holder.imv2);

            }
            break;
        }

    }

    @Override
    public int getItemCount() {

        int size;

        switch (uniqueId){
            case ONE_TEXT_VIEW:{
                size= data1.size();
            }
            break;
            case TWO_TEXT_VIEW:{
                size= Math.min(data1.size(),data2.size());
            }
            break;
            case ONE_TEXT_VIEW_ONE_IMAGE:{
                size= Math.min(data1.size(),imgurl.size());
            }
            break;
            case TWO_TEXT_VIEW_ONE_IMAGE:{
                size= Math.min(data1.size(),Math.min(data2.size(),imgurl.size()));
            }
            break;

            default:
                size=0;
                break;
        }

        return size;

    }

    class Flexiholder extends RecyclerView.ViewHolder{
        TextView tv1,tv2,tv3,tv4,tv5,tv6;
        ImageView imv1,imv2;
        public Flexiholder(@NonNull View itemView) {
            super(itemView);

            switch (uniqueId){
                case ONE_TEXT_VIEW:{
                    tv1=itemView.findViewById(R.id.text_view_one);
                }
                break;
                case TWO_TEXT_VIEW:{

                    tv2=itemView.findViewById(R.id.text2);
                    tv3=itemView.findViewById(R.id.text3);

                }
                break;
                case ONE_TEXT_VIEW_ONE_IMAGE:{
                    imv1=itemView.findViewById(R.id.imv1);
                    tv4=itemView.findViewById(R.id.tv4);
                }
                break;
                case TWO_TEXT_VIEW_ONE_IMAGE:{
                    imv2=itemView.findViewById(R.id.imv2);
                    tv5=itemView.findViewById(R.id.tv5);
                    tv6=itemView.findViewById(R.id.tv6);

                }
                break;
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onConnectedWithFlexiList.onListItemClicked(getAbsoluteAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onlongclicked==null){
                        Log.w("Next check","null-1");
                    }
                    else{
                        onlongclicked.onLongClick(getAbsoluteAdapterPosition(),adapter_new);
                    }
                    return false;
                }
            });

        }
    }

    public void setLongClickListener(onLongClicked onlongclicked,FlexilistAdapter adapter){
        this.onlongclicked=onlongclicked;
        this.adapter_new=adapter;
    }


}
