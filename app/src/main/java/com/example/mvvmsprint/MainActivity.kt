package com.example.mvvmsprint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmsprint.model.MovieEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = MediumListAdapter()

        vm = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        vm.allMovies.observe(this, Observer { items ->
            if (items.isEmpty()) {
                vm.insert(MovieEntity("Movie 1", 2001))
                vm.insert(MovieEntity("Movie 2", 2002))
                vm.insert(MovieEntity("Movie 3", 2003))
            }
            adapter.setMovies(items)
        })

        medium_list.apply {
            layoutManager = LinearLayoutManager(context)
            setAdapter(adapter)
        }
    }
}