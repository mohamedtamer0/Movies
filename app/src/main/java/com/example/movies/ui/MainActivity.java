package com.example.movies.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.movies.models.Movie;
import com.example.movies.adapter.MovieAdapter;
import com.example.movies.adapter.MovieItemClickListener;
import com.example.movies.R;
import com.example.movies.models.Slide;
import com.example.movies.adapter.SliderPagerAdapter;
import com.example.movies.utils.DataSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV,moviesRVWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();


    }

    private void iniWeekMovies() {

        MovieAdapter weekMoviesAdapter = new MovieAdapter(this, DataSource.getWeekMovies(),this);
        moviesRVWeek.setAdapter(weekMoviesAdapter);
        moviesRVWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniPopularMovies() {
        //Recylerview SetUp
        //ini Data

        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(),this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }


    private void iniSlider() {


        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1, "Mulan"));
        lstSlides.add(new Slide(R.drawable.slide2, "Avengers endgame"));
        lstSlides.add(new Slide(R.drawable.slide3, "Spider man back to home"));
        lstSlides.add(new Slide(R.drawable.slide4, "Jumanji"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);

        indicator.setupWithViewPager(sliderpager,true);
        //SetUp Timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);



    }


    private void iniViews() {
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);
        moviesRVWeek = findViewById(R.id.rv_movies_week);

        
    }



    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        Intent intent = new Intent(this,MovieDetailActivity.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

        ActivityOptions options = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                                                        movieImageView,"shareName");
        }

        startActivity(intent,options.toBundle());


        Toast.makeText(this, "Item Clicked : " + movie.getTitle(), Toast.LENGTH_SHORT).show();


    }


    class SliderTimer extends TimerTask {


        @Override
        public void run() {

           MainActivity.this.runOnUiThread(new Runnable() {
               @Override
               public void run() {
                   if (sliderpager.getCurrentItem() < lstSlides.size()-1) {
                       sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                   }
                   else
                       sliderpager.setCurrentItem(0);
               }
           });

        }

    }

}
