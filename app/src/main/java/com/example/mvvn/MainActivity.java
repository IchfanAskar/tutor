package com.example.mvvn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvn.base.ViewModelProviderFactory;
import com.example.mvvn.data.model.Movie;
import com.example.mvvn.ui.MovieViewModel;
import com.example.mvvn.utils.InjectorUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView movieRV;
    private RecycleViewAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieRV = findViewById(R.id.card_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        movieRV.setLayoutManager(mLayoutManager);


        ViewModelProviderFactory factory = InjectorUtils.providerViewModelProviderFactory();
        MovieViewModel viewModel = ViewModelProviders.of(this, factory).get(MovieViewModel.class);

        viewModel.getNowPlayingMovies().observe(this, movies -> {
            movieAdapter = new RecycleViewAdapter(movies, this);
            movieRV.setAdapter(movieAdapter);
        });



        viewModel.getShowLoading().observe(this, aBoolean -> showLoading(aBoolean));
    }

    private void showLoading(Boolean aBoolean) {
        if (aBoolean) {
            Log.d(TAG, "show loading");
        } else {
            Log.d(TAG, "hide loading");
        }
    }
}
