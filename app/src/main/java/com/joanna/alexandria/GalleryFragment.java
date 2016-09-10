package com.joanna.alexandria;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Joanna on 16-09-10.
 */
public class GalleryFragment extends Fragment{
    public static final String ARG_NAVBAR_ITEM_NUMBER = "item_number";

    GridView gridview;


    public GalleryFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grid_layout, container, false);
        gridview = (GridView) rootView.findViewById(R.id.gridview);
        ImageAdapter i = new ImageAdapter(getActivity());
        gridview.setAdapter(i);
        return rootView;
    }

}
