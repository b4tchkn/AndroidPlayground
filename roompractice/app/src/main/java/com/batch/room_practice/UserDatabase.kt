package com.batch.room_practice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao

//    companion object {
//        private const val dbName = "user.db"
//        private var instance: UserDatabase? = null
//
//        fun getUserDatabase(context: Context): UserDatabase {
//            instance = Room.databaseBuilder(context, UserDatabase::class.java, dbName)
//                .fallbackToDestructiveMigration()
//                .build()
//            return instance
//        }
//    }

    companion object {
        private var instance: UserDatabase? = null
        private const val DB_NAME = "user"
        fun init(context: Context) {
            instance = Room.databaseBuilder(context, UserDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration().build()
        }

        fun getInstance(): UserDatabase {
            return instance!!
        }
    }
}