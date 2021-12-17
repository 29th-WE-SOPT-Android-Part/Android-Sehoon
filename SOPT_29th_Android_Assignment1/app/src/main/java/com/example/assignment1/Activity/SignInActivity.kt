package com.example.assignment1.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import android.util.Log
import com.example.assignment1.*
import com.example.assignment1.Data.RequestLoginData
import com.example.assignment1.Data.ResponseLoginData
import com.example.assignment1.Util.ServiceCreator
import com.example.assignment1.Util.SharedPreferences
import com.example.assignment1.Util.shortToast
import retrofit2.Call
import com.example.assignment1.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val intent = Intent(this, HomeActivity::class.java) // 로그인 시 Home 으로 이동
        val intent2 = Intent(this, SignUpActivity::class.java) // 회원가입 시 SignUp 으로 이동

        binding.btnLogin.setOnClickListener {

            val pwText = binding.edPw.text.toString()
            val idText = binding.edId.text.toString()

            if (pwText.isEmpty() || idText.isEmpty()) {
                shortToast("로그인 실패")
            } else {
                initNetwork()
            }

        }

        binding.tvJoin1.setOnClickListener {
                startActivity(intent2)

        }

        initClickEvent()
        isAutoLogin()

        setContentView(binding.root)
    }

    private fun initClickEvent(){
        binding.ibAutoLogin.setOnClickListener{
            binding.ibAutoLogin.isSelected = !binding.ibAutoLogin.isSelected

            SharedPreferences.setAutoLogin(this, binding.ibAutoLogin.isSelected)
        }
    }

    private fun isAutoLogin() {
        if(SharedPreferences.getAutoLogin(this)){
            shortToast("자동로그인 완료")
            startActivity(Intent(this, HomeActivity::class.java))
                finish()
        }
    }

    private fun initNetwork(){
        val requestLoginData = RequestLoginData(
            binding.edId.text.toString(),
            binding.edPw.text.toString()
        )

        val call : Call<ResponseLoginData> = ServiceCreator.service.postLogin(requestLoginData)

        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ){
                if(response.isSuccessful){
                   Toast.makeText(this@SignInActivity,"${response.body()?.data?.name}님 반갑습니다", Toast.LENGTH_SHORT).show()
                   startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                }
                else{
                    response.body()
                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkTest","error")
            }

        })
    }
}