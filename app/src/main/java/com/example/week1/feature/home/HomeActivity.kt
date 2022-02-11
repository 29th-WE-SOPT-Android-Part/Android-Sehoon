package com.example.week1.feature.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val homeAdapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickEvent()
        addHomeData()
    }

    private fun clickEvent() {
        binding.btnHomeMygithub.setOnClickListener {
            callWeb()
        }
    }

    private fun callWeb() {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://github.com/s9hn?tab=repositories")
            )
        )
    }

    private fun addHomeData(){
        homeAdapter.homeList.addAll(
            listOf<HomeData>(
                HomeData("김세훈", "25", "ENFJ", "하읭")
            )
        )
    }
}