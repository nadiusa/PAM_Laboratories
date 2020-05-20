package com.sample.app.model

data class MoviesResponse(
    val page: String,
    val results: List<Movie>,
    val total_results: String,
    val total_pages: String
)
{
    constructor(): this(
        "",
        listOf(),
        "",
        ""

    )
}
