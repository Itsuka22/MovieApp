package com.handoyosamsung.movie_retrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.handoyosamsung.movie_retrofit.DetailActivity;
import com.handoyosamsung.movie_retrofit.R;
import com.handoyosamsung.movie_retrofit.model.ResultsItem;


import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<ResultsItem> resultsItems = new ArrayList<>();

    public MovieAdapter(Context context, List<ResultsItem> resultsItems) {
        this.context = context;
        this.resultsItems = resultsItems;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_movie_list, viewGroup, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.judul.setText(resultsItems.get(i).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + resultsItems.get(i).getPosterPath()).override(200, 400)
                .error(R.drawable.ic_launcher_background)
                .into(movieViewHolder.sampul);
        movieViewHolder.vrating.setText(resultsItems.get(i).getVoteAverage());


        movieViewHolder.klick.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("backdrop", "https://image.tmdb.org/t/p/w500" + resultsItems.get(i).getBackdropPath());
            intent.putExtra("detail", resultsItems.get(i).getOverview());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView sampul;
        private TextView judul;
        private CardView klick;
        private TextView vrating;
        public MovieViewHolder(View itemView) {
            super(itemView);

            sampul = itemView.findViewById(R.id.iv_backdrop);
            judul = itemView.findViewById(R.id.tv_judul);
            klick = itemView.findViewById(R.id.cv_klik);
            vrating = itemView.findViewById(R.id.rating);
        }
    }
}