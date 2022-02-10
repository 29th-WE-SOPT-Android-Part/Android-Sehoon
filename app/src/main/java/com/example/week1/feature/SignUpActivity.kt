package com.example.week1.feature

import android.content.Intent
import android.os.Bundle
import android.view.Gravity.apply
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.databinding.ActivitySignUpBinding
import com.example.week1.util.shortToast

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickEvent()


    }

    private fun clickEvent() {
        with(binding) {
            btnSignupDone.setOnClickListener {
                var etName = etSignupName.text.toString()
                var etId = etSignupId.text.toString()
                var etPw = etSignupPw.text.toString()
                val mIntent = Intent(this@SignUpActivity, SignInActivity::class.java).apply{
                    putExtra(SignInActivity., "Good")
                }
                setResult(RESULT_OK, mIntent)




                if (etId.isEmpty() || etPw.isEmpty() || etName.isEmpty()) {
                    shortToast("입력되지 않은 정보가 있습니다")
                } else {
                    shortToast("회원가입이 완료되었습니다")
                    finish()

                }
            }
        }
    }
}