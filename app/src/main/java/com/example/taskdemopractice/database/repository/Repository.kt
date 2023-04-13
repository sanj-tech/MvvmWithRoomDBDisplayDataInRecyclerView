package com.example.taskdemopractice.database.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.taskdemopractice.database.dao.UserDao
import com.example.taskdemopractice.database.db.UserDatabase
import com.example.taskdemopractice.database.entity.User


class Repository(var context: Context)
{
    private val dao: UserDao = UserDatabase.getInstance(context).dao()

    suspend fun saveUser(user: User) {
        dao.saveUser(user)
    }

    suspend fun getUser(): List<User> {
        return dao.getUserData()
    }

    fun getUserByLiveDate(): LiveData<List<User>> {
        return dao.getUserByLiveDate()
    }

    suspend fun updateUser(user: User) {
        dao.updateUserData(user.name, user.number, user.address)
    }

    suspend fun deleteUser(user: User) {
        dao.deleteUser(user.name)
    }

    //Api Calling
//    fun getMovieList(
//    ): LiveData<List<Movie>> {
//        val liveData = MutableLiveData<List<Movie>>()
//        val service = ApiClient.getRetrofitInstance()?.create(ApiService::class.java)
//        val call = service?.getMovieList(
//        )
//        call?.enqueue(object : Callback<List<Movie>> {
//            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
//                if (response.isSuccessful) {
//                    val responseList = response.body()
//                    liveData.postValue(responseList!!)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
//                Log.e("ApiCallingError", t.toString())
//            }
//
//        })
//        return liveData
//    }
//
//    fun saveMovie(movie: Movie) {
//        dao.saveMovie(movie)
//    }
}