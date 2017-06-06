package com.example.user.myapplication.MoviePackage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.user.myapplication.MoviePackage.Model.Movie;
import com.example.user.myapplication.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>
{
    private List<Movie> movies;
    private int rowLayout;
    private Context context;
    private static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w342//";

    public MovieAdapter(List<Movie> movies, int rowLayout, Context context)
    {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getRelease_date());
        holder.movieDescription.setText(movies.get(position).getOverview());

        Picasso.with(context).load(IMAGE_URL_BASE_PATH + movies.get(position).getPoster_path()).into(holder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView imageView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            data = (TextView) itemView.findViewById(R.id.description);
            movieDescription = (TextView) itemView.findViewById(R.id.data_new);
            rating = (TextView) itemView.findViewById(R.id.rating);
            imageView = (ImageView) itemView.findViewById(R.id.rating_image);
        }
    }
}
