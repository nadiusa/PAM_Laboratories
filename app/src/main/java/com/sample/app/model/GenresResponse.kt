package com.sample.app.model

data class GenresResponse(
    val genres: List<Genre>

)
{
    constructor(): this(
        listOf()
    )


}