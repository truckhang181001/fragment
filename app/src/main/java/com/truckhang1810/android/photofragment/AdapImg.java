package com.truckhang1810.android.photofragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

public class AdapImg extends BaseAdapter {

    private Context context;

    private String[] images;

    public AdapImg(@NonNull Context context, @NonNull String[] objects) {
        images = objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.gridview_item, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.myImage);
        Picasso.get().load(images[position]).resize(350, 350).centerCrop().into(imageView);
        return convertView;
    }
}