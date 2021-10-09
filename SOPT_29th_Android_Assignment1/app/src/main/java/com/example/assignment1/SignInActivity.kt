package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import com.example.assignment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val intent = Intent(this, HomeActivity::class.java) // 로그인 시 Home 으로 이동
        val intent2 = Intent(this, SignUpActivity::class.java) // 회원가입 시 SignUp 으로 이동

        binding.btnLogin.setOnClickListener {

            var pwText = binding.edPw.text.toString()
            var idText = binding.edId.text.toString()

            if (pwText.isEmpty() || idText.isEmpty()) {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "${idText}님 환영합니다", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        binding.btnJoin.setOnClickListener {
                startActivity(intent2)
        }
        setContentView(binding.root)
    }
}
