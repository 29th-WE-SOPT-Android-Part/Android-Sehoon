package com.example.assignment1.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.assignment1.R
import com.example.assignment1.Util.SharedPreferences
import com.example.assignment1.databinding.FragmentProfileBinding
import com.example.assignment1.Util.shortToast

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private var position = FIRST_POSITION

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        initTransactionEvent()
        initImage()
        initClickEvent()
        return binding.root
    }

    private fun initClickEvent(){
        binding.ivAutoLoginFalse.setOnClickListener{
            requireContext().shortToast("자동로그인 해제")
            SharedPreferences.removeAutoLogin(requireContext())
            SharedPreferences.clearStorage(requireContext())
        }
    }

    private fun initImage(){
        Glide.with(this)
            .load(R.drawable.profiles)
            .circleCrop()
            .into(binding.ivProfiles)
    }

    private fun initTransactionEvent(){
       val blankFragment1 = BlankFragment1()
       val blankFragment2 = BlankFragment2()

      childFragmentManager.beginTransaction().add(R.id.container_main, blankFragment1).commit()
       binding.btnRepository.setOnClickListener {
           val transaction = childFragmentManager.beginTransaction()
           when (position) {
               FIRST_POSITION -> {
                   transaction.replace(R.id.container_main, blankFragment2)
                   position = SECOND_POSITION
               }
           }
           transaction.commit()
           binding.btnRepository.isSelected = !binding.btnRepository.isSelected
           binding.btnFollower.isSelected = false
       }
       binding.btnFollower.setOnClickListener {
           val transaction = childFragmentManager.beginTransaction()
           when (position){
               SECOND_POSITION ->{
                   transaction.replace(R.id.container_main, blankFragment1)
                   position = FIRST_POSITION
               }
           }
           transaction.commit()
           binding.btnFollower.isSelected = !binding.btnFollower.isSelected
           binding.btnRepository.isSelected = false


       }
   }


    companion object{
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2

    }
}
