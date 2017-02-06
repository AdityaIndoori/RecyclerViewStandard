package com.example.aditya.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements recyclerViewAdapter.ListItemClickListener{
    String[]
            Heading = {"Heading 1","Heading 2","Heading 3","Heading 4","Heading 5"},
            SubHeading = {"SubHeading 1","SubHeading 2","SubHeading 3","SubHeading 4","SubHeading 5"};
    private recyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView,recyclerViewV,recyclerViewG;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Horizontal
        recyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new recyclerViewAdapter(Heading,SubHeading,this);
        recyclerView.setAdapter(recyclerViewAdapter);

        //Vertical
        recyclerViewV = (RecyclerView)findViewById(R.id.VerticalRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewV.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new recyclerViewAdapter(Heading,SubHeading,this);
        recyclerViewV.setAdapter(recyclerViewAdapter);

        //Grid
        recyclerViewG = (RecyclerView)findViewById(R.id.GridRecyclerView);
        gridLayoutManager = new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false);//2 = number of columns
        recyclerViewG.setLayoutManager(gridLayoutManager);
        recyclerViewAdapter = new recyclerViewAdapter(Heading,SubHeading,this);
        recyclerViewG.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void onListItemClick(int clickedItemIndex, int viewCode) {
        Log.v("Tag","The viewCode is: " + viewCode);
        if (toast != null)
            toast.cancel();
        if (viewCode == 1)
        {
            toast=Toast.makeText(getApplicationContext(),"The SubHeading number clicked is: " + clickedItemIndex,Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            toast=Toast.makeText(getApplicationContext(),"The number clicked is: " + clickedItemIndex,Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
