package com.joanna.alexandria;

/**
 * Created by Joanna on 16-09-10.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // all Images in array
    public Integer[] mThumbIds = {
            R.drawable.book,
            R.drawable.book,
            R.drawable.book,
            R.drawable.book
    };

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(mContext);

            gridView = inflater.inflate(R.layout.book_layout, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.myImageViewText);
            textView.setText("yo"); //INSERT THE BOOK TITLE AND DEETS HEREEEEEEEEE

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.myImageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            imageView.setImageResource(R.drawable.book);
//            imageView.setLayoutParams(new GridView.LayoutParams(RelativeLayout.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

//            String mobile = mobileValues[position];


        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }


//        ImageView imageView = new ImageView(mContext);
////        imageView = (ImageView)  ;
//        imageView.setImageResource(mThumbIds[position]);
}

