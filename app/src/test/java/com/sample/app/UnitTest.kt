package com.sample.app

import android.content.Context
import com.sample.app.adapter.GenresAdapter
import com.sample.app.model.Genre
import org.junit.Assert.assertEquals
import org.junit.Test


class UnitTest(
    var genresList: List<Genre>,
    var mContext: Context
) {

    @Test
    fun test_getItemCount() {
        val adapter = GenresAdapter(mContext, genresList)

        //initial state
        val countExpected = 20
        val countActual: Int = adapter.itemCount
        assertEquals(countExpected, countActual)
    }
}