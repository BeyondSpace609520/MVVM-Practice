package com.example.mvvmsprint

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmsprint.database.GalleryDatabase
import com.example.mvvmsprint.model.MovieEntity
import kotlinx.coroutines.launch

class MovieViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MovieRepository
    val allMovies: LiveData<List<MovieEntity>>

    init {
        val movieDao = GalleryDatabase.getInstance(application).movieDao()
        repository = MovieRepository(movieDao)
        allMovies = repository.allMovies
    }

    fun insert(movie: MovieEntity) = viewModelScope.launch {
        repository.insert(movie)
    }
}