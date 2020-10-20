package com.example.mvvmsprint.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_items")
data class MovieEntity(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "year") var year: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}