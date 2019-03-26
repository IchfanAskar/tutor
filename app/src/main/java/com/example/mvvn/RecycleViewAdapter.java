package com.example.mvvn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvvn.data.model.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<Movie> dataList;
    private Context context;

    public RecycleViewAdapter(List<Movie> dataList, Context context){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        holder.tvjudul.setText(dataList.get(i).getTitle());
        holder.tvrilis.setText(dataList.get(i).getReleaseDate());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvjudul, tvrilis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvjudul = itemView.findViewById(R.id.text_judul);
            tvrilis = itemView.findViewById(R.id.text_rilis);
        }
    }
}
