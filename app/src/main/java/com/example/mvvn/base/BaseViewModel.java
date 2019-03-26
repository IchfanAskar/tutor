package com.example.mvvn.base;

import com.example.mvvn.data.model.Movie;
import com.example.mvvn.data.repository.MovieRepository;

import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {

    private MovieRepository repository;

    public BaseViewModel(MovieRepository repository){
        this.repository = repository;
    }

    protected MovieRepository getRepository(){
        return repository;
    }
}
