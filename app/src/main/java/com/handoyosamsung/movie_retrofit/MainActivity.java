package com.handoyosamsung.movie_retrofit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.handoyosamsung.movie_retrofit.favoritefrag.FavoriteFragment;
import com.handoyosamsung.movie_retrofit.moviefrag.MovieFragment;
import com.handoyosamsung.movie_retrofit.tvshowfrag.TvShowFragment;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    TextView PindahHalaman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigation = findViewById(R.id.bottom_nav);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_tv_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_movie_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_favorite_24));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()) {
                    case 1:
                        fragment = new TvShowFragment();
                        break;
                    case 2:
                        fragment = new MovieFragment();
                        break;
                    case 3:
                        fragment = new FavoriteFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });

        bottomNavigation.setCount(1, "10");
        bottomNavigation.show(2, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext()
                        , "-_-"
                        , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment, MainActivity.class.getSimpleName())
                .commit();

    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this) ;
        builder.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        builder.setTitle("Setuju Keluar");
        builder.setMessage("Apakah Kamu ingin Keluar?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Batal",null);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



}