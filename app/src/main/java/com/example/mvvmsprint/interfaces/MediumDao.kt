package com.example.mvvmsprint.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmsprint.model.MovieEntity

@Dao
interface MediumDao {
    @Query("SELECT * FROM movie_items ORDER BY title ASC")
    fun getAll(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg movies: MovieEntity)
}