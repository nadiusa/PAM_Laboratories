package com.sample.app.movie_select.movieGenres

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R
import com.sample.app.model.Movie

class DetectiveActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detective_list_activity)
//
//        // Create Recycler view layout manager, for simple lists use Linear layout
//        viewManager = LinearLayoutManager(this)
//
//        // Create sample data set of 30 dummy elements
//         viewAdapter = FeedRecyclerViewAdapter(Array(30) {
//            Movie(
//                "Detective film here",
//                "Some description",
//                "https://is2-ssl.mzstatic.com/image/thumb/Purple62/v4/ba/4c/c9/ba4cc94f-51da-3774-95d1-0ec1b562733a/AppIcon-1x_U007emarketing-0-0-GLES2_U002c0-512MB-sRGB-0-0-0-85-220-0-0-0-9.png/1200x630wa.png"
//            )
//        })
//
//        // Find recycler view in hierarchy of elements and set layout manager and adapter
//        recyclerView = findViewById<RecyclerView>(R.id.feed_recycler_view).apply {
//            // use this setting to improve performance if you know that changes
//            // in content do not change the layout size of the RecyclerView
//
//            // use a linear layout manager
//            layoutManager = viewManager
//
//            // specify an viewAdapter (see also next example)
//            adapter = viewAdapter
//        }
    }

}
