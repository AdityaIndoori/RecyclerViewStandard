package com.example.aditya.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by aditya on 2/5/2017.
 */

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolderClass> {
    //Create List Data Arrays here:
    private String[] HeadingArray, SubHeadingArray;
    private int NumberOfItems;
    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex, int viewCode);
    }

    //Add further List Data in the form of arrays here:
    recyclerViewAdapter(String[] HeadingArray, String[] SubHeadingArray, ListItemClickListener listener){
        this.HeadingArray=HeadingArray;
        this.SubHeadingArray=SubHeadingArray;
        NumberOfItems = HeadingArray.length;
        mOnClickListener = listener;
    }

    @Override
    public ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolderClass viewHolder;
        View view;
        LayoutInflater layoutInflater;
        Context context;

        context = parent.getContext();
        layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.list_view_item,parent,false);
        viewHolder = new ViewHolderClass(view);
        return viewHolder;
        //OR
        //You can just implement this one line: return new ViewHolderClass(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolderClass holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return NumberOfItems;
    }

    //The ViewHolder Class:
    class ViewHolderClass extends RecyclerView.ViewHolder {
        //Instantiate the various view elements here:
        TextView Heading, SubHeading;
        ViewHolderClass(View view){
            super(view);
            //Initialize those view Instances Here:
            Heading = (TextView)view.findViewById(R.id.Heading);
            SubHeading = (TextView)view.findViewById(R.id.SubHeading);

            SubHeading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickedPosition = getAdapterPosition();
                    mOnClickListener.onListItemClick(clickedPosition, 1);
                }
            });
        }

        void bind(int Position){
            //Assign the data to those view Instances Here:
            Heading.setText(HeadingArray[Position]);
            SubHeading.setText(SubHeadingArray[Position]);
        }

    }
}
