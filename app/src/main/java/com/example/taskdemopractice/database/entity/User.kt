package com.example.taskdemopractice.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(val name:String,val number:String,val address:String){
    @PrimaryKey(autoGenerate = true)
    var columnId: Int = 0
}
