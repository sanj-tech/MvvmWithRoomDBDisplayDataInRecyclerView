package com.example.taskdemopractice.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskdemopractice.viewModel.UserViewModel
import com.example.taskdemopractice.database.repository.Repository

class ViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(Repository(context)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
