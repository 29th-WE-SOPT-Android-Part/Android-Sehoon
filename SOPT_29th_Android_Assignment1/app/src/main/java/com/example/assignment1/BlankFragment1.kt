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

        binding.rvSample.adapter = userAdapter

        userAdapter.userList.addAll(
            listOf(
                UserData("김대호","안녕하세요")
            )
        )

        userAdapter.notifyDataSetChanged()


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

}