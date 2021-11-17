# Android-Sehun
--------------------------------------------------
## :notebook_with_decorative_cover:4주차 과제 : 로그인/회원가입 API 연동
<img src ="https://user-images.githubusercontent.com/81347125/141483451-f730e6d1-f143-4a83-821a-d4d4d37bfbcc.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/141483457-97cacea3-be45-4b69-845d-567932b9ef52.png" width = "70%">
<br>

## :notebook_with_decorative_cover: 구현 결과
<img src="https://user-images.githubusercontent.com/81347125/141486621-2a9ada2a-a15b-44fa-882c-6ff387baf410.gif" width="30%">               <img src="https://user-images.githubusercontent.com/81347125/141486628-d21f5cac-f4ff-4932-ae04-fcbebdd4f768.gif" width="30%">         
　　　　　　　<로그인>　　　　　　　　　　　　　　<회원가입>


<br>

## :notebook_with_decorative_cover:과제리뷰
### :pushpin: RequestData

<pre>
<code>
data class RequestLoginData(
    @SerializedName("email")
    val email: String,
    val password: String
)

data class RequestSignUpData(
    @SerializedName("email")
    val email: String,
    val name: String,
    val password: String
)

</code>
</pre>

### :pushpin: ResponseData

<pre>
<code>
data class ResponseLoginData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
) {
    data class Data (
        val id : Int,
        val name : String,
        val email : String
        )
}

data class ResponseSignUpData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
) {
    data class Data (
        val id : Int,
        val name : String,
        val email : String
    )
}

</code>
</pre>

### :pushpin: retrofit interface

<pre>
<code>
interface Service {
    @Headers("Content-Type: application/json")
    @POST("user/login")
    fun postLogin(
        @Body requestLoginData: RequestLoginData
    ) : Call<ResponseLoginData>
}

interface Service2 {
    @Headers("Content-Type: application/json")
    @POST("user/signup")
    fun postSignUp(
        @Body requestSignUpData: RequestSignUpData
    ) : Call<ResponseSignUpData>
}

</code>
</pre>

### :pushpin: Creator(object)

<pre>
<code>
object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"
    private val retrofit : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service : Service = retrofit.create(Service::class.java)
}

object ServiceCreator2 {
    private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"
    private val retrofit : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service2 : Service2 = retrofit.create(Service2::class.java)
}

</code>
</pre>

### :pushpin: Implementation of SignInActivity

<pre>
<code>
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
                Log.e("NetworkTest","error")
            }
        })
    }
    
</code>
</pre>

### :pushpin: Implementation of SignUpActivity

<pre>
<code>
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
    
</code>
</pre>



<br>
<hr>

