package com.sample.app.model

data class Genre (
    val id : Int,
    val name : String
)
{
    constructor() : this(
    0,
    ""
    )
}