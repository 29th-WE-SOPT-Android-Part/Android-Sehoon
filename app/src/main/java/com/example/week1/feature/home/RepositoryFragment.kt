package com.example.week1.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week1.databinding.FragmentRepositoryBinding

class RepositoryFragment : Fragment() {
    private var _binding: FragmentRepositoryBinding? = null
    private val binding get() = _binding ?: error("Binding is not initialization")
    private val repositoryAdapter = RepositoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)
        addItem()
        initMainAdapter()
        return binding.root
    }

    private fun initMainAdapter() {
        binding.rvRepositoryList.adapter = repositoryAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addItem() {
        repositoryAdapter.itemList.addAll(
            listOf<FragmentData>(
                FragmentData("권용민 과제\n레포지토리", "파트과제1"),
                FragmentData("김세훈 과제\n레포지토리", "파트과제2"),
                FragmentData("이종찬 과제\n레포지토리", "파트과제3"),
                FragmentData("이혜빈 과제\n레포지토리", "파트과제4"),
                FragmentData("최정원 과제\n레포지토리", "파트과제5")
            )
        )
    }
}
