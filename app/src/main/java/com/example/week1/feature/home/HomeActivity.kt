package com.example.week1.feature.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.week1.R
import com.example.week1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        dataBinding()
        initTransactionEvent()
    }

    private fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.fcv_home_swaplist, followerFragment)
            .commit()

        with(binding) {
            btnHomeFollowerlist.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fcv_home_swaplist,
                    followerFragment
                ).commit()
            }

            btnHomeRepositorylist.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fcv_home_swaplist,
                    repositoryFragment
                ).commit()
            }
        }
    }

//    private fun callWeb() {
//        startActivity(
//            Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse("https://github.com/s9hn?tab=repositories")
//            )
//        )
//    }

    private fun dataBinding() {
        binding.home = HomeData(
            "김세훈",
            "25",
            "ENFJ",
            "우하하하",
            R.drawable.ic_launcher_foreground
        )
    }
}
