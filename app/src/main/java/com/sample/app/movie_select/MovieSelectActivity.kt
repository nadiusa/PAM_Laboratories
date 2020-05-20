package com.sample.app.movie_select

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.app.R
import com.sample.app.movie_select.movieGenres.*
import com.sample.app.tabs_screens.tabs.TabsActivity
import kotlinx.android.synthetic.main.activity_movie_type_select.*
import java.util.concurrent.ThreadLocalRandom

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
            for (i in 0..0) {
            val rand = ThreadLocalRandom.current().nextInt(1, 17)

            if (rand == 0) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 1) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 2) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 3) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 4) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 5) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 6) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 7) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 8) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 9) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 10) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 11) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 12) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 13) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 14) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 15) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 16) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            if (rand == 17) {
                val intent = Intent(this, TabsActivity::class.java)
                startActivity(intent)
            }
            }
        }
    }
}