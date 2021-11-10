package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.assignment1.databinding.ActivityHomeBinding
import com.example.assignment1.databinding.ActivitySignUpBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        initAdapter()
        initBottomNavi()
        setContentView(binding.root)
    }

    private fun initAdapter(){

        val fragmentList = listOf(ProfileFragment(),HomeFragment(),CameraFragment())
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpMain.adapter = viewPagerAdapter
    }

    private fun initBottomNavi(){
        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.bnvMenu.menu.getItem(position).isChecked = true
            }
        })

        binding.bnvMenu.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu_profile -> {
                    binding.vpMain.currentItem = FIRST_POSITION
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_home -> {
                    binding.vpMain.currentItem = SECOND_POSITION
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    binding.vpMain.currentItem = THIRD_POSITION
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }
    }

    companion object{
        const val FIRST_POSITION = 0
        const val SECOND_POSITION = 1
        const val THIRD_POSITION = 2
    }
}

