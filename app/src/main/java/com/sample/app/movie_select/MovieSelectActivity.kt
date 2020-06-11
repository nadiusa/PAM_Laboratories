package com.sample.app.movie_select

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.app.R
import com.sample.app.movie_select.movieGenres.*
import kotlinx.android.synthetic.main.activity_movie_type_select.*

class MovieSelectActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_type_select)

        btnAction.setOnClickListener{
            val intent = Intent(this, ActionActivity::class.java)
            startActivity(intent)
        }

        btnDetective.setOnClickListener{
            val intent = Intent(this, DetectiveActivity::class.java)
            startActivity(intent)
        }

        btnFantasy.setOnClickListener{
            val intent = Intent(this, FantasyActivity::class.java)
            startActivity(intent)
        }
        btnHorror.setOnClickListener{
            val intent = Intent(this, HorrorActivity::class.java)
            startActivity(intent)
        }

        btnComedy.setOnClickListener{
            val intent = Intent(this, ComedyActivity::class.java)
            startActivity(intent)
        }


        btnDrama.setOnClickListener {
            val intent = Intent(this, DramaActivity::class.java)
            startActivity(intent)
        }


        btnRand.setOnClickListener {
            val intent = Intent(this, RandomActivity::class.java)
            startActivity(intent)
        }
    }
}