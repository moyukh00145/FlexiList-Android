package com.androidhelper.flexilist;


import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlexiList{

    public static final int ONE_TEXT_VIEW=0;
    public static final int TWO_TEXT_VIEW=1;
    public static final int ONE_TEXT_VIEW_ONE_IMAGE=2;
    public static final int TWO_TEXT_VIEW_ONE_IMAGE=3;
    public static final int SWIPE_LEFT=ItemTouchHelper.LEFT;
    public static final int SWIPE_RIGHT=ItemTouchHelper.RIGHT;
    public static final int SWIPE_BOTH_LEFT_AND_RIGHT=ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
    private int lay_type;
    Context context;
    private ArrayList<Object> data1;
    private ArrayList<Object> data2;
    private ArrayList<Object> imageUrl;
    boolean check=false;
    private FlexilistAdapter adapter,adapter2,adapter3;
    private RecyclerView recyclerView;
    onFlexlistClicked onFlexlistClicked;
    onSwipeAction onSwipeAction;
    onLongClicked onlongclicked;

    public FlexiList(@NonNull Context context,int layout_type,@NonNull RecyclerView recyclerView){
        this.lay_type=layout_type;
        this.context=context;
        this.recyclerView=recyclerView;

    }

    public void addData_to_ONE_TEXT_VIEW(@NonNull ArrayList<Object> data){
        this.data1=data;
        check=true;
    }

    public void addData_to_TWO_TEXT_VIEW(@NonNull ArrayList<Object> data1,@NonNull ArrayList<Object> data2){
        this.data1=data1;
        this.data2=data2;
        check=true;
    }

    public void addData_to_ONE_TEXT_VIEW_ONE_IMAGE(@NonNull ArrayList<Object> data1,@NonNull ArrayList<Object> imageUrl){
        this.data1=data1;
        this.imageUrl=imageUrl;
        check=true;
    }

    public void addData_to_TWO_TEXT_VIEW_ONE_IMAGE(@NonNull ArrayList<Object> data1,@NonNull ArrayList<Object> data2,@NonNull ArrayList<Object> imageUrl){
        this.data1=data1;
        this.data2=data2;
        this.imageUrl=imageUrl;
        check=true;
    }

    public void setFlexiList() throws Exception {
        if (check==true){

            switch (lay_type){
                case ONE_TEXT_VIEW:{
                    if (data1!=null){
                        if (!data1.isEmpty()){
                            adapter=new FlexilistAdapter(context,lay_type,R.layout.onetextview,data1);
                            setAdapterToRecycleView();
                        }
                        else{

                        }
                    }
                    else{
                        throw new Exception("Arraylist Null Object Reference");
                    }
                }
                    break;
                case TWO_TEXT_VIEW:{
                    if (data1!=null&&data2!=null){
                        if (!data1.isEmpty()&&!data2.isEmpty()){
                            adapter=new FlexilistAdapter(context,lay_type,R.layout.two_textview,data1,data2);
                            setAdapterToRecycleView();
                        }
                        else{

                        }
                    }
                    else{
                        throw new Exception("Arraylist Null Object Reference");
                    }
                }
                    break;
                case ONE_TEXT_VIEW_ONE_IMAGE:{
                    if (data1!=null&&imageUrl!=null){
                        if (!data1.isEmpty()&&!imageUrl.isEmpty()){
                            adapter=new FlexilistAdapter(context,lay_type,R.layout.onetextview_oneimageview,data1,imageUrl,true);
                            setAdapterToRecycleView();
                        }
                        else{

                        }
                    }
                    else{
                        throw new Exception("Arraylist Null Object Reference");
                    }
                }
                    break;
                case TWO_TEXT_VIEW_ONE_IMAGE:{
                    if (data1!=null&&data2!=null&&imageUrl!=null){
                        if (!data1.isEmpty()&&!data2.isEmpty()&&!imageUrl.isEmpty()){
                            adapter=new FlexilistAdapter(context,lay_type,R.layout.twotextview_oneimageview,data1,data2,imageUrl);
                            setAdapterToRecycleView();
                        }
                        else{

                        }
                    }
                    else{

                        throw new Exception("Arraylist Null Object Reference");

                    }
                }
                    break;

            }

        }
        else{
            throw new Exception("Data not set to Flexilist");
        }
    }

    private void setAdapterToRecycleView() throws Exception {

        if (recyclerView!=null){
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(adapter);

        }
        else{
            throw new Exception("Wrong Reference to Recyceler View");
        }

    }


    public void setOnlongclicked(){
        this.onlongclicked=(com.androidhelper.flexilist.onLongClicked) context;
        adapter2=new FlexilistAdapter(context);
        adapter2.setLongClickListener(onlongclicked,adapter);
    }

    public void getSwipeAction(int SwipeType) {
        this.onSwipeAction = (com.androidhelper.flexilist.onSwipeAction) context;
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, SwipeType) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(context, data1.get(viewHolder.getAbsoluteAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();

                onSwipeAction.onSwiped(viewHolder.getAbsoluteAdapterPosition(), adapter);


            }
        };

        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }

    public void setFlexiListClicked(){
        this.onFlexlistClicked= (com.androidhelper.flexilist.onFlexlistClicked) context;
        adapter3=new FlexilistAdapter(context);
        adapter3.setOnFlexlistClicked(onFlexlistClicked);

    }
}
