package com.sample.app.utility
import com.sample.app.model.Movie
import kotlin.random.Random

class Utils {
    fun shuffle(list: MutableList<Movie>): List<Movie> {
        // start from beginning of the list
        for (i in 0 until list.size - 1)
        {
            // get a random index j such that i <= j <= n
            val j = i + Random.nextInt(list.size - i)

            // swap element at i'th position in the list with element at j'th position
            val temp = list[i]
            list[i] = list[j]
            list[j] = temp
        }
        return list
    }


}