package com.example.user.myapplication.MoviePackage.Retrofit;

import com.example.user.myapplication.MoviePackage.Model.MovieResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface
{
    @GET("movie/top_rated")
    Call<MovieResults> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResults> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
