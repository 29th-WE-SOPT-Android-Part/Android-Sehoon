package com.example.week1.feature.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.week1.R
import com.example.week1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
   // private var position = FIRST_POSITION
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
      //  clickEvent()
        dataBinding()
        initTransactionEvent()
    }

//    private fun clickEvent() {
//        binding.btnHomeMygithub.setOnClickListener {
//            callWeb()
//        }
//    }

    private fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.fcv_home_swaplist, followerFragment).commit()

        with(binding){
            btnHomeRepositorylist.setOnClickListener {
                transaction.replace(com.example.week1.R.id.fcv_home_swaplist, repositoryFragment)
            }

            btnHomeFollowerlist.setOnClickListener {
                transaction.replace(com.example.week1.R.id.fcv_home_swaplist, followerFragment)

            }

        }
       //  transaction.commit()
    }

    private fun callWeb() {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://github.com/s9hn?tab=repositories")
            )
        )
    }

    private fun dataBinding() {
        binding.home = HomeData(
            "김세훈",
            "25",
            "ENFJ",
            "우하하하",
            R.drawable.ic_launcher_foreground
        )
    }

//    companion object {
//        const val FIRST_POSITION = 1
//        const val SECOND_POSITION = 2
//    }
}