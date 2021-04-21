package com.example.nestedrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyAdapter myAdapter;
    ArrayList<ParentItem> parentItemArrayList;
    ArrayList<ChildItem> childItemArrayList;
    RecyclerView RVparent;
    String name;
    int trywe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RVparent = findViewById(R.id.RVparent);

        String[] orderID = {"ZCD25374DEA","DCF25354DEA","FRW26544DEA","FRE25874DEA"};
        String[] itemName = {"Burger","Manchurian","Sandwich"};
        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
        parentItemArrayList = new ArrayList<>();
        childItemArrayList = new ArrayList<>();

        for (int i=0 ; i<orderID.length; i++ ){

            ParentItem parentItem = new ParentItem(orderID[i],String.valueOf(i+14),String.valueOf(i*43),imageId[i]);
            parentItemArrayList.add(parentItem);

            //Child Item Object
            if (i < itemName.length) {
                ChildItem childItem = new ChildItem(itemName[i], String.valueOf(i + 5), String.valueOf(i * 15),imageId[i]);
                childItemArrayList.add(childItem);
            }

        }

        myAdapter = new MyAdapter(this,parentItemArrayList,childItemArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RVparent.setLayoutManager(layoutManager);
        RVparent.setAdapter(myAdapter);

    }


}