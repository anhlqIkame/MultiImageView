# MultiImageView
Create Chat Head Image Like FaceBook Messenger


<img src= "https://github.com/anhlqIkame/MultiImageView/blob/master/Screenshot_2018-05-22-14-23-55-994_com.ikame.junittest.png" width="350" height="650">
</img>


- Cách khởi tạo: 

Cách 1: Sử dụng trong file XML:

<code>
<com.anhlq.multiimageview.MultiImageView
android:id="@+id/mimv_activity_main__avatarGroup"
android:layout_width="100dp"
android:layout_height="100dp"/>
</code>
       
<code>
MultiImageView multiImageView = findViewById(R.id.mimv_activity_main__avatarGroup);
multiImageView.setShape(MultiImageView.Shape.CIRCLE);
</code>


Cách 2: New View:

<code>
BaseMultiImageView multiImageView = new BaseMultiImageView(context);
multiImageView.setShape(BaseMultiImageView.Shape.CIRCLE);
</code>

- Thêm ảnh mới (tối đa 4 ảnh):

<code>
 multiImageView.addImage(Bitmap bitmap);
 </code>
 
 - Chọn kiểu bo viền:
 
 <code>
 multiImageView.setShape(MultiImageView.Shape.CIRCLE); // bo tròn
 
 multiImageView.setShape(MultiImageView.Shape.RECTANGLE); // bo góc
 
 multiImageView.setShape(MultiImageView.Shape.NONE); // không bo
 </code>
 
 - Chỉnh Khoảng trống giữa các ảnh:
 
 <code>
 multiImageView.setDividerWidth(float width);
 </code>
 
 - Chỉnh màu khoảng trống giữa các ảnh:
 
 <code>
 multiImageView.setDividerColor(int color);
 </code>
 
 
 - Xóa toàn bộ ảnh:
 
  <code>
  multiImageView.clear();
  </code>
 
 
 - Các hàm getter:
 <code>
 multiImageView.getDividerColor(); // lấy màu của khoảng trống
 
 multiImageView.getDividerWidth(); // lấy chiều rộng khoảng trống
 
 multiImageView.getMultiDrawable(); // lấy ảnh hiện tại dưới dạng drawable
 
 multiImageView.getShape(); // lấy kiểu bo hiện tại.

</code>
