package com.example.mvvn.utils;

import com.example.mvvn.base.ViewModelProviderFactory;
import com.example.mvvn.data.repository.MovieRepository;

public class InjectorUtils {

    private static MovieRepository provideRepository(){
        return MovieRepository.getInstance();
    }

    public static ViewModelProviderFactory providerViewModelProviderFactory(){
        MovieRepository repository = provideRepository();
        return new ViewModelProviderFactory(repository);
    }
}
