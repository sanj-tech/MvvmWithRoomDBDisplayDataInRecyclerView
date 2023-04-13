package com.example.taskdemopractice.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdemopractice.R
import com.example.taskdemopractice.adapter.UserRecyclerViewAdapter


import com.example.taskdemopractice.utils.ViewModelFactory
import com.example.taskdemopractice.viewModel.UserViewModel
import com.example.taskdemopractice.database.entity.User
import kotlinx.android.synthetic.main.activity_roomexample.*

class RoomExampleActivity : AppCompatActivity() {


    private lateinit var adapter: UserRecyclerViewAdapter
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roomexample)
        viewModel = ViewModelProvider(
            this, ViewModelFactory(this)
        )[UserViewModel::class.java]

        btInsert.setOnClickListener {
            val name = etName.text.toString()
            val number = etNumber.text.toString()
            val address = etAddress.text.toString()

            val user = User(name, number, address)
            viewModel.saveUser(user)
        }

        btDelete.setOnClickListener {
            val name = etName.text.toString()
            val number = etNumber.text.toString()
            val address = etAddress.text.toString()

            val user = User(name, number, address)
            viewModel.deleteUser(user)
        }
//
        btUpdate.setOnClickListener {
            val name = etName.text.toString()
            val number = etNumber.text.toString()
            val address = etAddress.text.toString()

            val user = User(name, number, address)
            viewModel.updateUser(user)
        }

        btGet.setOnClickListener {
            viewModel.getUser().observe(this) { userList ->
                adapter = UserRecyclerViewAdapter(this, userList)
                findViewById<RecyclerView>(R.id.rv).adapter = adapter
            }
        }
        viewModel.getUserByLiveData().observe(this) {userList->
            adapter = UserRecyclerViewAdapter(this,userList)
            findViewById<RecyclerView>(R.id.rv).adapter=adapter

        }

    }


}

