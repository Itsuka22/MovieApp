package com.handoyosamsung.movie_retrofit.moviefrag;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MovieViewModel {
    private MutableLiveData<String> mText;

    public MovieViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
