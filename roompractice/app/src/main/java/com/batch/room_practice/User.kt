package com.batch.room_practice

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

// テーブル名はなくても大丈夫デフォルトだとクラス名がテーブル名になる
@Entity(tableName = "user_table")
// PrimaryKeyを複数つけたいときは@Entity(primaryKeys = ["id", "name"])
data class User(
    @PrimaryKey
    val id: Int,
    val name: String
//    val createdAt: Date
)