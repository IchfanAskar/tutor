package com.example.mvvn.ui;

import com.example.mvvn.base.BaseViewModel;
import com.example.mvvn.data.model.Movie;
import com.example.mvvn.data.repository.MovieRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class MovieViewModel  extends BaseViewModel {
    private MutableLiveData<Boolean>showLoading;

    public MovieViewModel(MovieRepository repository) {
        super(repository);
        showLoading = new MutableLiveData<>();
    }

    public LiveData<List<Movie>>getNowPlayingMovies(){
        showLoading.setValue(true);

        final MediatorLiveData<List<Movie>> mediatorLiveData = new MediatorLiveData<>();

        mediatorLiveData.addSource(getRepository().getNowPlayingMovies(), movies -> {

            mediatorLiveData.setValue(movies);
            showLoading.setValue(false);
        });
        return mediatorLiveData;
    }

    public LiveData<Boolean>getShowLoading(){
        return showLoading;
    }
}
