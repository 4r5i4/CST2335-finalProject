package com.example.cst2335.finalproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import model.DataItem;


public class DataItemAdapterListView extends ArrayAdapter<DataItem> {

    List<DataItem> mDataItems;
    LayoutInflater mInflater;

    public DataItemAdapterListView(Context context, List<DataItem> objects) {
        super(context, R.layout.list_item, objects);
        mDataItems = objects;
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.listtextview);
        ImageView iv = (ImageView) convertView.findViewById(R.id.listimageView);
        DataItem item = mDataItems.get(position);
        String imageFile = item.getImage();
        InputStream inputStream = null;
        try {
            inputStream = getContext().getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            iv.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        tv.setText(item.getItemName());


        return convertView;
    }
}
