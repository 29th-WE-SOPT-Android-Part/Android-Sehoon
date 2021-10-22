package com.example.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignment1.databinding.FragmentBlank1Binding

class BlankFragment1 : Fragment() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var binding : FragmentBlank1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {

        binding= FragmentBlank1Binding.inflate(layoutInflater)

        userAdapter = UserAdapter()

        binding.rvFollower.adapter = userAdapter

        userAdapter.userList.addAll(
            listOf<UserData>(
                UserData("김대호","안드레인저 옐로"),
                UserData("김수빈","안드레인저 그린"),
                UserData("김송현","안드레인저 핑크"),
                UserData("이혜빈","안드레인저 레드")
            )
        )

        userAdapter.notifyDataSetChanged()

        // Inflate the layout for this fragment
        return binding.root
    }

}