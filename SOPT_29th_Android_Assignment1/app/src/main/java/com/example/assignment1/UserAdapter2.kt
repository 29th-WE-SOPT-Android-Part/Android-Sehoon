package com.example.assignment1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1.databinding.ItemRepositoryListBinding


class UserAdapter2 : RecyclerView.Adapter<UserAdapter2.UserViewHolder>(){
    val userList = mutableListOf<UserData>()


    class UserViewHolder(private val binding : ItemRepositoryListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : UserData){
            binding.tvRp.text = data.name
            binding.tvRp2.text = data.introduction



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

}