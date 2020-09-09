package com.example.movies.utils;

import com.example.movies.R;
import com.example.movies.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {



    public static List<Movie> getPopularMovies() {

        List<Movie> lstMovie = new ArrayList<>();
        lstMovie.add(new Movie("Avengers endgame", R.drawable.avengers_endgame,R.drawable.avengers_endgame));
        lstMovie.add(new Movie("Jumanji",R.drawable.jumanji,R.drawable.jumanji));
        lstMovie.add(new Movie("Mulan",R.drawable.mulan,R.drawable.mulan));
        lstMovie.add(new Movie("Spider man back to home",R.drawable.spider_man_background,R.drawable.spider_man_background));
        lstMovie.add(new Movie("Avengers endgame",R.drawable.avengers_endgame,R.drawable.avengers_endgame));
        lstMovie.add(new Movie("Jumanji",R.drawable.jumanji,R.drawable.jumanji));
        lstMovie.add(new Movie("Mulan",R.drawable.mulan,R.drawable.mulan));
        lstMovie.add(new Movie("Spider man back to home",R.drawable.spider_man_background,R.drawable.spider_man_background));
        lstMovie.add(new Movie("Avengers endgame",R.drawable.avengers_endgame,R.drawable.avengers_endgame));
        lstMovie.add(new Movie("Jumanji",R.drawable.jumanji,R.drawable.jumanji));
        lstMovie.add(new Movie("Mulan",R.drawable.mulan,R.drawable.mulan));
        lstMovie.add(new Movie("Spider man back to home",R.drawable.spider_man_background,R.drawable.spider_man_background));


        return lstMovie;

    }

    public static List<Movie> getWeekMovies() {

        List<Movie> lstMovie = new ArrayList<>();
        lstMovie.add(new Movie("Mulan",R.drawable.mulan,R.drawable.mulan));
        lstMovie.add(new Movie("Spider man back to home",R.drawable.spider_man_background,R.drawable.spider_man_background));
        lstMovie.add(new Movie("Avengers endgame",R.drawable.avengers_endgame,R.drawable.avengers_endgame));
        lstMovie.add(new Movie("Avengers endgame", R.drawable.avengers_endgame,R.drawable.avengers_endgame));
        lstMovie.add(new Movie("Jumanji",R.drawable.jumanji,R.drawable.jumanji));
        lstMovie.add(new Movie("Mulan",R.drawable.mulan,R.drawable.mulan));
        lstMovie.add(new Movie("Spider man back to home",R.drawable.spider_man_background,R.drawable.spider_man_background));
        lstMovie.add(new Movie("Avengers endgame",R.drawable.avengers_endgame,R.drawable.avengers_endgame));
        lstMovie.add(new Movie("Jumanji",R.drawable.jumanji,R.drawable.jumanji));
        lstMovie.add(new Movie("Mulan",R.drawable.mulan,R.drawable.mulan));
        lstMovie.add(new Movie("Spider man back to home",R.drawable.spider_man_background,R.drawable.spider_man_background));


        return lstMovie;

    }

}
