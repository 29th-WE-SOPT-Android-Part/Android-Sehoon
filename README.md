# Android-Sehun
--------------------------------------------------
## :notebook_with_decorative_cover:3주차 과제 : 과제에 디자인 적용하기
<img src ="https://user-images.githubusercontent.com/81347125/139589093-b4ac6833-c0a6-486d-898c-e72cbc52557e.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/139589096-c0517ebe-3dff-405f-8757-88973a5ec993.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/139589100-e836e8ef-e7df-407e-8038-1c31e77fab2d.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/139589102-36c60ff1-dbfc-4935-9d27-1075fae08806.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/139589104-d092dac1-e24c-4163-a484-f27ad6bf3d6c.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/139589107-46397e8e-5644-4a61-b42f-6d9f165945ce.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/139589112-775453df-1226-403e-97d8-ba43290d1a1a.png" width = "70%">
<img src ="https://user-images.githubusercontent.com/81347125/139589114-74c7a8a7-758f-4275-bb39-f4d70f529134.png" width = "70%">
<br>


## :notebook_with_decorative_cover:과제리뷰
### :pushpin: Design by Figma


<pre>
<code>
//rectangle_fill_gray
  ?xml version="1.0" encoding="utf-8"?>
shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    corners android:radius="5dp"/>
    solid android:color="#F2F2F2"/>
    stroke android:width="1dp" android:color="#D0D0D0"/>
shape>
</code>
</pre>


<pre>
<code>
//rectangle_fill_pink
 ?xml version="1.0" encoding="utf-8"?>
shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
corners android:radius="5dp"/>
    solid android:color="@color/Pink"/>
    stroke android:width="1dp" android:color="@color/Pink"/>
shape>

</code>
</pre>


<pre>
<code>
//selector
?xml version="1.0" encoding="utf-8"?>
selector xmlns:android="http://schemas.android.com/apk/res/android">
    item android:drawable="@drawable/rectangle_fill_white_border_pink" android:state_focused="true" />
    item android:drawable="@drawable/rectangle_fill_gray" android:state_focused="false" />


selector>
</code>
</pre>

<br>
<hr>

