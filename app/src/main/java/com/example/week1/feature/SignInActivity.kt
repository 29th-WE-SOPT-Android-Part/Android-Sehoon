package com.example.week1.feature

import android.content.Intent
import android.os.Bundle
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