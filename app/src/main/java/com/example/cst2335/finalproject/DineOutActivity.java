package com.example.cst2335.finalproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import model.DataItem;
import sample.SampleDataProvider;

public class DineOutActivity extends AppCompatActivity {

    TextView tvOut;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//
//        tvOut = (TextView) findViewById(R.id.groceryItem);
//        tvOut.setText("");
//
//        Collections.sort(dataItemList, new Comparator<DataItem>() {
//            @Override
//            public int compare(DataItem o1, DataItem o2) {
//                return o1.getItemName().compareTo(o2.getItemName());
//            }
//        });

//        for (DataItem item : dataItemList) {
////            tvOut.append(item.getItemName() + "\n");
//            itemNames.add(item.getItemName());
//
//        }

//        Collections.sort(itemNames);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                itemNames
//                );

        DataItemAdapterListView adapter = new DataItemAdapterListView(this, dataItemList);

        ListView listView = (ListView) findViewById(R.id.groceryListListview);
        listView.setAdapter(adapter);
    }//end onCreate

}//end GroceryListActivity
