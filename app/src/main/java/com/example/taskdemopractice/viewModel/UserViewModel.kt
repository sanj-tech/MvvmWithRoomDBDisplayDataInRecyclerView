package com.example.taskdemopractice.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskdemopractice.database.entity.User
import com.example.taskdemopractice.database.repository.Repository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: Repository) : ViewModel() {

    fun saveUser(user: User) {
        viewModelScope.launch {
            repository.saveUser(user)
        }
    }


    fun getUser(): LiveData<List<User>> {
        val userdata = MutableLiveData<List<User>>()
        viewModelScope.launch {
            userdata.postValue(repository.getUser())
        }
        return userdata
    }

    fun getUserByLiveData(): LiveData<List<User>> {
        return repository.getUserByLiveDate()
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            repository.deleteUser(user)
        }
    }
}




