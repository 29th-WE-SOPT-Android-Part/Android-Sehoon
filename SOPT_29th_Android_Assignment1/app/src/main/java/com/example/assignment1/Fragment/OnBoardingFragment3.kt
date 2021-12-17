package com.example.assignment1.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.assignment1.Activity.OnBoardingActivity
import com.example.assignment1.R
import com.example.assignment1.Activity.SignInActivity
import com.example.assignment1.databinding.FragmentOnBoarding3Binding

class OnBoardingFragment3 : Fragment() {
    private lateinit var binding : FragmentOnBoarding3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoarding3Binding.inflate(inflater)
        val intent = Intent(activity, SignInActivity::class.java)

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment3_to_signInActivity)

            (activity as OnBoardingActivity).finish()
        }
        return binding.root
    }
}