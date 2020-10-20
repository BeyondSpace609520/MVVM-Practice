package com.example.mvvmsprint.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmsprint.interfaces.MediumDao
import com.example.mvvmsprint.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class GalleryDatabase: RoomDatabase() {
    abstract fun movieDao(): MediumDao

    companion object {
        @Volatile
        private var INSTANCE: GalleryDatabase? = null

        fun getInstance(context: Context): GalleryDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(GalleryDatabase::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GalleryDatabase::class.java,
                    "movie_database"
                )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}