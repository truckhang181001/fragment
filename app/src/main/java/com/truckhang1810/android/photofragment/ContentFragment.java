package com.truckhang1810.android.photofragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContentFragment extends Fragment {
    GridView gridView;
    int posMenu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);

        gridView = view.findViewById(R.id.myGridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ImageDetail.class);
                intent.putExtra("PosMenu", posMenu);
                intent.putExtra("PosItem", i);
                startActivity(intent);
            }
        });

        updateFrag(0);

        return view;
    }

    public void updateFrag(int pos)
    {
        posMenu = pos;
        TypedArray images = getResources().obtainTypedArray(R.array.images);
        int contentId = images.getResourceId(posMenu, R.array.ocean);
        gridView.setAdapter(new AdapImg(getActivity(), getResources().getStringArray(contentId)));
        images.recycle();
    }
}