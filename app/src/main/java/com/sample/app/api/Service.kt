package com.sample.app.api

import com.sample.app.model.GenresResponse
import com.sample.app.model.MoviesResponse
import com.sample.app.model.TrailerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call <MoviesResponse>

    @GET("genre/movie/list")
    fun getMovieGenres(@Query("api_key") apiKey: String): Call <GenresResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Call <MoviesResponse>

    @GET("movie/{movie_id}/videos")
    fun getMovieTrailer(@Path("movie_id") id: Int, @Query("api_key") apiKey: String): Call <TrailerResponse>

    @GET("movie/{movie_id}/similar")
    fun getSimilarMovies(@Path("movie_id") id: Int, @Query("api_key") apiKey: String): Call <MoviesResponse>

    @GET("movie /now_playing")
    fun getPlayingNowMovies(@Query("api_key") apiKey: String): Call <MoviesResponse>

}