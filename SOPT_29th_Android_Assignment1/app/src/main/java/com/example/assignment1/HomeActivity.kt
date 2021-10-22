package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment1.databinding.ActivityHomeBinding
import com.example.assignment1.databinding.ActivitySignUpBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var position = FIRST_POSITION


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        initTransactionEvent()


        setContentView(binding.root)
    }

    private fun initTransactionEvent(){
        val blankFragment1 = BlankFragment1()
        val blankFragment2 = BlankFragment2()

        supportFragmentManager.beginTransaction().add(R.id.container_main, blankFragment1).commit()

        binding.btnRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position) {

                FIRST_POSITION -> {
                    transaction.replace(R.id.container_main, blankFragment2)
                    position = SECOND_POSITION
                }
            }
            transaction.commit()
        }

        binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

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

