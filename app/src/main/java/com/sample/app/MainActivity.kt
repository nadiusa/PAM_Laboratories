package com.sample.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.app.movie_select.MovieSelectActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFindMovie.setOnClickListener {
            startActivity(Intent(this, MovieSelectActivity::class.java))
        }

    }
}
