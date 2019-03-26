package com.example.mvvn.base;

import com.example.mvvn.data.repository.MovieRepository;
import com.example.mvvn.ui.MovieViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final MovieRepository repository;

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel Class : " + modelClass);
    }

    public ViewModelProviderFactory(MovieRepository repository){
        this.repository = repository;
    }


}
