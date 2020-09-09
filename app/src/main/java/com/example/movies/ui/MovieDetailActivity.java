package com.example.movies.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movies.R;
import com.example.movies.adapter.CastAdapter;
import com.example.movies.models.Cast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MovieCoverImage;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        //iniViews
        iniViews();
        //setup list cast
        setupRvCast();


    }




    void iniViews() {
        RvCast = findViewById(R.id.rv_cast);
        play_fab = findViewById(R.id.play_fab);

        play_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieDetailActivity.this,MoviePlayerActivity.class);
                startActivity(intent);
            }
        });
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imageCover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImage = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imageCover).into(MovieCoverImage);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description = findViewById(R.id.detail_movie_desc);


        //setup Animation
        MovieCoverImage.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));

    }



    private void setupRvCast() {

        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name",R.drawable.cast1));
        mdata.add(new Cast("name",R.drawable.cast2));
        mdata.add(new Cast("name",R.drawable.cast3));
        mdata.add(new Cast("name",R.drawable.cast4));
        mdata.add(new Cast("name",R.drawable.cast5));

        castAdapter = new CastAdapter(this,mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

}
