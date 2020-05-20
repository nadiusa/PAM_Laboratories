package com.sample.app.model

data class TrailerResponse (
    val id : Int,
    val results : List<Trailer>
)
{
    constructor():this(
        0,
        listOf()
    )
}