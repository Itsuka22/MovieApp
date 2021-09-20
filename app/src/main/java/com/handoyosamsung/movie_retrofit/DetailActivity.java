package com.handoyosamsung.movie_retrofit;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.handoyosamsung.movie_retrofit.R;



public class DetailActivity extends AppCompatActivity {

    private ImageView actDetail;
    private TextView textDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String backdropPath = getIntent().getStringExtra("backdrop");
        String detail = getIntent().getStringExtra("detail");

        Glide.with(DetailActivity.this).load(backdropPath).override(512, 512).error(R.drawable.ic_launcher_background).into(actDetail);
        textDetail.setText(detail);



    }

    private void initView() {
        actDetail = findViewById(R.id.atc_Detail);
        textDetail = findViewById(R.id.txt_detail);
    }
}