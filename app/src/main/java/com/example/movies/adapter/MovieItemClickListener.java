package com.example.movies.adapter;

import android.widget.ImageView;

import com.example.movies.models.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView);
}
