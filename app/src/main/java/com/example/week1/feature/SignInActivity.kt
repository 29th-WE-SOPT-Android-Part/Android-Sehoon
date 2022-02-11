package com.example.week1.feature

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.databinding.ActivitySignInBinding
import com.example.week1.util.shortToast

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickEvent()

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {result ->
            if(result.resultCode == Activity.RESULT_OK){
                val myData: Intent? = result.data
                val stringData = myData?.getStringExtra("dataName")
            }
        }

        fun openSomeActivityForResult(){
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }

    }

    private fun clickEvent() {
        with(binding) {

            btnSigninLogin.setOnClickListener {
                var etId = etSigninId.text.toString()
                var etPw = etSigninPw.text.toString()

                if (etId.isEmpty() || etPw.isEmpty()) {
                    shortToast("로그인 실패")
                } else {
                    shortToast("${etId}님 환영합니다")
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                }
            }

            btnSigninSignup.setOnClickListener {
                startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
            }
        }
    }
}