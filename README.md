# Android-Sehun
--------------------------------------------------
## :notebook_with_decorative_cover:7주차 과제 : 온보딩, 자동로그인, 패키징 구현
<img src ="https://user-images.githubusercontent.com/81347125/146560839-e602c125-9fb3-4475-a19d-2797fb9fcba0.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/146560842-53cd3055-4ca0-40a7-ae97-192505eeeec3.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/146560822-c3713ded-4982-46d9-81c3-0c0def21cea8.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/146560829-19b73300-338d-442e-8d17-2da42dcb6b58.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/146560831-85cf9e07-076a-45d9-8935-3430e4cc4369.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/146560832-93e3fe20-170c-4efa-971c-6302be70b3ef.png" width = "70%">
<br>

## :notebook_with_decorative_cover: 구현 결과
<img src="https://user-images.githubusercontent.com/81347125/146560834-ece3db41-e5eb-4cbd-827a-bf40f085b275.gif" width="30%">               <img src="https://user-images.githubusercontent.com/81347125/146561185-01639604-7703-475e-a5db-1b05f5b6b16f.PNG" width="30%">         
　　　　　　


<br>

## :notebook_with_decorative_cover:과제리뷰
### :pushpin: OnBoarding1,2

<pre>
<code>
 binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment1_to_onBoardingFragment2)
        }
</code>
</pre>

### :pushpin: OnBoarding3
<pre>
<code>
 val intent = Intent(activity, SignInActivity::class.java)
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment3_to_signInActivity)

            (activity as OnBoardingActivity).finish()
        }
</code>
</pre>

### :pushpin: SharedPreferences

<pre>
<code>
object SharedPreferences {
    private const val STORAGE_KEY = "USER_AUTH"
    private const val AUTO_LOGIN = "AUTO_LOGIN"
    fun getAutoLogin(context: Context) : Boolean {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        return preferences.getBoolean(AUTO_LOGIN, false)
    }

    fun setAutoLogin(context: Context, value : Boolean) {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        preferences.edit()
            .putBoolean(AUTO_LOGIN, value)
            .apply()
    }

    fun removeAutoLogin(context: Context) {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        preferences.edit()
            .remove(AUTO_LOGIN)
            .apply()
    }

    fun clearStorage(context: Context) {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        preferences.edit()
            .clear()
            .apply()
    }
}
</code>
</pre>

### :pushpin: 자동로그인 

<pre>
<code>
 private fun isAutoLogin() {
        if(SharedPreferences.getAutoLogin(this)){
            shortToast("자동로그인 완료")
            startActivity(Intent(this, HomeActivity::class.java))
                finish()
        }
    }
    
</code>
</pre>

### :pushpin: 자동로그인 해제

<pre>
<code>
private fun initClickEvent(){
        binding.ivAutoLoginFalse.setOnClickListener{
            requireContext().shortToast("자동로그인 해제")
            SharedPreferences.removeAutoLogin(requireContext())
            SharedPreferences.clearStorage(requireContext())
        }
    }
</code>
</pre>

### :pushpin: util 클래스

<pre>
<code>
fun Context.shortToast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
</code>
</pre>



<br>
<hr>

