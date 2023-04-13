package com.example.taskdemopractice.database.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.taskdemopractice.database.entity.User


@Dao
interface UserDao {
    //To save Data
    @Insert
    suspend fun saveUser(user: User)

    @Query("SELECT * FROM User")
    suspend fun getUserData(): List<User>

    @Query("SELECT * FROM User")
    fun getUserByLiveDate(): LiveData<List<User>>

    @Query("Update User set number=:number,address=:address where name=:name")
    suspend fun updateUserData(name: String, number: String, address: String)

    @Query("Delete from User where name=:name")
    suspend fun deleteUser(name: String)

}