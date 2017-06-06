package com.example.user.myapplication.MoviePackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.user.myapplication.MoviePackage.Model.Movie;
import com.example.user.myapplication.MoviePackage.Model.MovieResults;
import com.example.user.myapplication.R;
import com.example.user.myapplication.MoviePackage.Retrofit.ApiClient;
import com.example.user.myapplication.MoviePackage.Retrofit.ApiInterface;
import com.example.user.myapplication.MoviePackage.adapter.MovieAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
     private  final static String TAG = MainActivity.class.getSimpleName();
     private final static String API_KEY = "Insert Key Here";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResults> call = apiInterface.getTopRatedMovies(API_KEY);

        call.enqueue(new Callback<MovieResults>()
        {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response)
            {
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MovieAdapter(movies, R.layout.activity_main, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t)
            {
                Log.e(TAG, t.toString());
            }
        });
    }
}

