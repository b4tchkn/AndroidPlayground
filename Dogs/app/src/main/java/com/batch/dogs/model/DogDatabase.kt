package com.batch.dogs.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DogBreed::class), version = 1)
abstract class DogDatabse: RoomDatabase() {
    abstract fun dogDao(): DogDao

    companion object {
        @Volatile private var instance: DogDatabse? = null
        private val LOCK = Any()

        operator  fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buidDatabase(context).also {
                instance = it
            }
        }
        // test comment
        private fun buidDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DogDatabse::class.java,
            "dogdatabase"
        ).build()
    }
}