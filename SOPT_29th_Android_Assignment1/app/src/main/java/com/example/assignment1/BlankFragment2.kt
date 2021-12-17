package com.example.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignment1.databinding.FragmentBlank1Binding
import com.example.assignment1.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {
    private lateinit var userAdapter2: UserAdapter2
    private lateinit var binding : FragmentBlank2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBlank2Binding.inflate(layoutInflater)
        userAdapter2 = UserAdapter2()
        binding.rvRepository.adapter = userAdapter2
        userAdapter2.userList.addAll(
            listOf<UserData>(
                UserData("대호\n레포지토리","과제유"),
                UserData("수빈\n레포지토리","과제입니다"),
                UserData("송현\n레포지토리","과제"),
                UserData("혜빈\n레포지토리","과제과제과제과제과점")
            )
        )
        userAdapter2.notifyDataSetChanged()
        // Inflate the layout for this fragment
        return binding.root
    }
}