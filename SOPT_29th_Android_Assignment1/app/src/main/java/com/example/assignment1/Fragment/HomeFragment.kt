package com.example.assignment1.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignment1.Adapter.ViewPagerAdapter2
import com.example.assignment1.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewPagerAdapter2: ViewPagerAdapter2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        initAdapter()
        initTabLayout()
        return binding.root
    }

    private fun initAdapter(){
        val fragmentList = listOf(fragment_following(), fragment_follower())
        viewPagerAdapter2 = ViewPagerAdapter2(this)
        viewPagerAdapter2.fragmentList.addAll(fragmentList)

        binding.vpHome.adapter = viewPagerAdapter2
    }

    private fun initTabLayout(){
        val tabLabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.tlHome, binding.vpHome){
            tab, position -> tab.text = tabLabel[position]
        }.attach()
    }
}
