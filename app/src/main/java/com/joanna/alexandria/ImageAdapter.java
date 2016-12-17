package com.joanna.alexandria;

/**
 * Created by Joanna on 16-09-10.
 */

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


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

        //////////////////////////
        final TextView mTextView = (TextView) findViewById(R.id.text);

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(DownloadManager.Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
        ////////////////////////

        if (convertView == null) {

            gridView = new View(mContext);

            gridView = inflater.inflate(R.layout.book_layout, null);

            // set value into textview
            final TextView textView = (TextView) gridView
                    .findViewById(R.id.myImageViewText);
            textView.setText("yo"); //INSERT THE BOOK TITLE AND DEETS HEREEEEEEEEE
            textView.setClickable(true);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    View view = null;

                    builder.setTitle(textView.getText());
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setPositiveButton("Request", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast toast = Toast.makeText(mContext, "You requested a book.", 30);
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
            });

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

