package com.example.week1.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week1.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding ?: error("Binding is not initialization")
    private val followerAdapter = FollowerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
        addItem()
        initMainAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initMainAdapter() {
        binding.rvFollowerList.adapter = followerAdapter
    }

    private fun addItem() {
        followerAdapter.itemList.addAll(
            listOf<FragmentData>(
                FragmentData("권용민", "1"),
                FragmentData("김세훈", "2"),
                FragmentData("이종찬", "3"),
                FragmentData("이혜빈", "4"),
                FragmentData("최정원", "5")
            )
        )
    }
}
