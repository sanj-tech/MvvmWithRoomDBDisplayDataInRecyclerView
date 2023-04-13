package com.example.taskdemopractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskdemopractice.R
import com.example.taskdemopractice.database.entity.User

class UserRecyclerViewAdapter(var context: Context, var userList: List<User>) :
    RecyclerView.Adapter<UserRecyclerViewAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.customlayout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.number.text = userList[position].number
        holder.name.text = userList[position].name
        holder.address.text = userList[position].address
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var number = itemView.findViewById<TextView>(R.id.txtid)
        var name = itemView.findViewById<TextView>(R.id.txtName)
        var address = itemView.findViewById<TextView>(R.id.txtAddress)

    }
}