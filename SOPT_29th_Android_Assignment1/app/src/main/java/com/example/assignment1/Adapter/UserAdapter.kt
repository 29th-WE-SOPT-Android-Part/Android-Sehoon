package com.example.assignment1.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1.Data.UserData
import com.example.assignment1.databinding.ItemFollowerListBinding


class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    val userList = mutableListOf<UserData>()

    class UserViewHolder(private val binding : ItemFollowerListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : UserData){
            binding.tvDh1.text = data.name
            binding.tvDh2.text = data.introduction

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

}