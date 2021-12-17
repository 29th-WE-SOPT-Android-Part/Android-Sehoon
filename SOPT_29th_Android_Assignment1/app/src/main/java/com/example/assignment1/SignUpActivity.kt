package com.example.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.widget.Toast
import com.example.assignment1.databinding.ActivityMainBinding
import com.example.assignment1.databinding.ActivitySignUpBinding
=======
import android.util.Log
import android.widget.Toast
import com.example.assignment1.databinding.ActivityMainBinding
import com.example.assignment1.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
>>>>>>> 076e762a8a1913dcc88cad246e2767f93e97da06

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoined.setOnClickListener {

            var nmText = binding.edName.text.toString()
            var pwText = binding.edPw2.text.toString()
            var idText = binding.edId2.text.toString()

            if (pwText.isEmpty() || idText.isEmpty() || nmText.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
<<<<<<< HEAD
                Toast.makeText(this, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
                finish();
            }
        }
    }
=======
            initNetwork()

            }
        }
    }

    private fun initNetwork(){
        val requestSignUpData = RequestSignUpData(
            binding.edName.text.toString(),
            binding.edId2.text.toString(),
            binding.edPw2.text.toString()

        )

        val call : Call<ResponseSignUpData> = ServiceCreator2.service2.postSignUp(requestSignUpData)

        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ){
                if(response.isSuccessful){
                    Toast.makeText(this@SignUpActivity,"${response.body()?.data?.name}님 반갑습니다", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignUpActivity,SignInActivity::class.java))
                }
                else{
                    response.body()

                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.e("NetworkTest","error")

            }

        })
    }
>>>>>>> 076e762a8a1913dcc88cad246e2767f93e97da06
}

