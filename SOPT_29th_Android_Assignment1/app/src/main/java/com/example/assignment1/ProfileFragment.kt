package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assignment1.BlankFragment1
import com.example.assignment1.BlankFragment2
import com.example.assignment1.R
import com.example.assignment1.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var ProfileFragment: FragmentProfileBinding
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        initTransactionEvent()


        return binding.root
    }

    fun initTransactionEvent() {
        val BlankFragment1 = BlankFragment1()
        val BlankFragment2 = BlankFragment2()


        }
    }

}