package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
<<<<<<< HEAD
import com.example.assignment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
=======
import android.util.Log
import retrofit2.Call
import com.example.assignment1.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
>>>>>>> 076e762a8a1913dcc88cad246e2767f93e97da06

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val intent = Intent(this, HomeActivity::class.java) // 로그인 시 Home 으로 이동
        val intent2 = Intent(this, SignUpActivity::class.java) // 회원가입 시 SignUp 으로 이동

        binding.btnLogin.setOnClickListener {

<<<<<<< HEAD
            var pwText = binding.edPw.text.toString()
            var idText = binding.edId.text.toString()
=======


            val pwText = binding.edPw.text.toString()
            val idText = binding.edId.text.toString()
>>>>>>> 076e762a8a1913dcc88cad246e2767f93e97da06

            if (pwText.isEmpty() || idText.isEmpty()) {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            } else {
<<<<<<< HEAD
                Toast.makeText(this, "${idText}님 환영합니다", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        binding.btnJoin.setOnClickListener {
=======
                initNetwork()
            }
        }

        binding.tvJoin1.setOnClickListener {
>>>>>>> 076e762a8a1913dcc88cad246e2767f93e97da06
                startActivity(intent2)
        }
        setContentView(binding.root)
    }
<<<<<<< HEAD
=======

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
                   startActivity(Intent(this@SignInActivity,HomeActivity::class.java))
                }
                else{
                    response.body()

                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {

            }

        })
    }
>>>>>>> 076e762a8a1913dcc88cad246e2767f93e97da06
}
