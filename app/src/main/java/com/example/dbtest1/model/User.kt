package com.example.dbtest1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    val name:String,
    val age:Int
){
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null
}
