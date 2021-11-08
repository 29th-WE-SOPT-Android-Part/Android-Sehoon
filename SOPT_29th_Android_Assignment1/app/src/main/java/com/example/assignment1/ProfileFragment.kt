package com.example.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignment1.databinding.FragmentBlank1Binding
import com.example.assignment1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private var position = FIRST_POSITION

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        initTransactionEvent()
        return binding.root

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
       }
   }


    companion object{
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2

    }
}
