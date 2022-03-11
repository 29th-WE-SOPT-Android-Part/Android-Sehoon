package com.example.week1.feature.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.databinding.ItemFollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    val itemList = mutableListOf<FragmentData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    class FollowerViewHolder(
        private val binding: ItemFollowerListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: FragmentData) {
            binding.follower = data
            itemView.setOnClickListener() {
                val name = binding.tvFollowerName.text.toString()
                val icon = binding.ivFollowerProfile.toy12



                val followerToDetailIntent =
                    Intent(itemView.context, DetailActivity::class.java)
                followerToDetailIntent.putExtra("name",name)
                ContextCompat.startActivity(itemView.context, followerToDetailIntent, null)
            }
        }
    }
}