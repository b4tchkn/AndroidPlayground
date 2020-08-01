package com.batch.room_practice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao

    companion object {
        private const val dbName = "user.db"
        private var instance: UserDatabase? = null

        fun getUserDatabase(context: Context): UserDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, UserDatabase::class.java, dbName)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return requireNotNull(instance)
        }
    }
}