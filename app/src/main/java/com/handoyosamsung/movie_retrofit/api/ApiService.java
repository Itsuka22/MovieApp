package com.handoyosamsung.movie_retrofit.api;




import com.handoyosamsung.movie_retrofit.model.MovieRootModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("movie/now_playing?api_key=0dde3e9896a8c299d142e214fcb636f8")
    Call<MovieRootModel> ambilData();

}
