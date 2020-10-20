package com.example.mvvmsprint

import androidx.lifecycle.LiveData
import com.example.mvvmsprint.interfaces.MediumDao
import com.example.mvvmsprint.model.MovieEntity

class MovieRepository(private val mediumDao: MediumDao) {
    val allMovies: LiveData<List<MovieEntity>> = mediumDao.getAll()

    suspend fun insert(movie: MovieEntity) {
        mediumDao.insert(movie)
    }
}