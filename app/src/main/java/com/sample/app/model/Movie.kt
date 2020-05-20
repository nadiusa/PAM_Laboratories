package com.sample.app.model

data class Movie(
    val poster_path: String,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_title: String,
    val original_language: String,
    val title: String,
    val backdrop_path: String,
    val popularity : Double,
    val vote_count : Int,
    val video : Boolean,
    val vote_average : Double
    )
{
    constructor(): this(
        "https://image.tmdb.org/t/p/w500",
        false,
        "",
        "",
        listOf(),
        0,
        "",
        "",
        "",
        "",
        0.0,
        0,
        false,
        0.0
    )
}
