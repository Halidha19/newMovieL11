package com.example.newmovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;
    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource,objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitleR);
        TextView tvGenre = rowView.findViewById(R.id.tvGenreR);
        TextView tvYear = rowView.findViewById(R.id.tvYearR);
        ImageView ivRating = rowView.findViewById(R.id.ivRatingR);
        // Obtain the Android Version information based on the position
        Movie currentItem = movieList.get(position);

        tvTitle.setText(currentItem.getTitle());
        tvGenre.setText(currentItem.getGenre());
        tvYear.setText(String.valueOf(currentItem.getYear()));

        if (currentItem.getRating().equals("G")){
            ivRating.setImageResource(R.drawable.rating_g);
        } else if (currentItem.getRating().equals("M18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if (currentItem.getRating().equals("NC16")){
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if (currentItem.getRating().equals("PG")){
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if (currentItem.getRating().equals("PG13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if (currentItem.getRating().equals("R21")){
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}
