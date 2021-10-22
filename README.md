# Android-Sehun
--------------------------------------------------
## :notebook_with_decorative_cover:1주차 과제 : RecycleView를 활용해 Fragment 전환 구현하기
<img src ="https://user-images.githubusercontent.com/81347125/138463290-bfe39442-d2ac-4463-8d5e-9723773b5f4b.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/138463345-88acd125-193d-4cfa-a937-858e136877da.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/138463353-fd2f1a5a-98bd-4e14-b948-d54e847190d0.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/138463362-49f7c7b1-f0c2-4d6b-9366-31c4173e8cce.png" width = "70%">
<br>

## :notebook_with_decorative_cover: 구현 결과
<img src="https://user-images.githubusercontent.com/81347125/138467490-a5f227a6-4530-4c7c-ac8a-62533dfc00f4.gif" width="40%">        
<br>

## :notebook_with_decorative_cover:과제리뷰
### :pushpin: Follower Fragment & Repository Fragment
Fragment에서의 Binding과 앞서 배운 Activity에서의 Binding하는 방법이 달라 오랜시간 애먹었다.. 

<pre>
<code>
//Follower Fragment
  class BlankFragment1 : Fragment() {
    private lateinit var userAdapter: UserAdapter
    private lateinit var binding : FragmentBlank1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBlank1Binding.inflate(layoutInflater)
        userAdapter = UserAdapter()
        binding.rvFollower.adapter = userAdapter
        userAdapter.userList.addAll(
            listOf<UserData>(
                UserData("김대호","안드레인저 옐로"),
                UserData("김수빈","안드레인저 그린"),
                UserData("김송현","안드레인저 핑크"),
                UserData("이혜빈","안드레인저 레드")
            )
        )
        userAdapter.notifyDataSetChanged()
        // Inflate the layout for this fragment
        return binding.root
    }
}
</code>
</pre>


<pre>
<code>
//Repository Fragment
  class BlankFragment2 : Fragment() {
    private lateinit var userAdapter2: UserAdapter2
    private lateinit var binding : FragmentBlank2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBlank2Binding.inflate(layoutInflater)
        userAdapter2 = UserAdapter2()
        binding.rvRepository.adapter = userAdapter2
        userAdapter2.userList.addAll(
            listOf<UserData>(
                UserData("대호\n레포지토리","과제유"),
                UserData("수빈\n레포지토리","과제입니다"),
                UserData("송현\n레포지토리","과제"),
                UserData("혜빈\n레포지토리","과제과제과제과제과점")
            )
        )
        userAdapter2.notifyDataSetChanged()
        // Inflate the layout for this fragment
        return binding.root
    }
}
</code>
</pre>

<br>
<hr>

### :pushpin: Button Method of HomeActivity

코틀린 문법이 아직 미숙하고, 세미나 실습과 달리 버튼하나 추가 되었을 뿐인데, 꽤 많은 시간을 썼다(줌각작할때 캠끄고 이거 매달리고 있었음)
근데 어쩌다 됐다. 되고 보니 너무 간단해서 어이없었다.

<pre>
<code>
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
</code>
</pre>



