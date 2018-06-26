# Image Popup for Android
# It is now much simpler to use image popup

#Step 1 : Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
#Step 2 : Add the dependency

    dependencies {
	        implementation 'com.github.adembulut:PopupImage:0.52'
	}

 #Step 3:
 
        PopupImage popupImage = new PopupImage(MainActivity.this, new CallBack() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "click Test",Toast.LENGTH_SHORT).show();
                    }
                });
               /* popupImage.setPopupHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                popupImage.setPopupWidth(ViewGroup.LayoutParams.MATCH_PARENT);*/
                popupImage.setPopupHeight(600);
                popupImage.setPopupWidth(600);
                popupImage.setScaleType(ImageView.ScaleType.FIT_XY);
                popupImage.ShowPopup("https://i2.wp.com/beebom.com/wp-content/uploads/2016/01/Reverse-Image-Search-Engines-Apps-And-Its-Uses-2016.jpg");
                //with Picasso or
                popupImage.ShowPopup(YourBitmapFile);
                //or
                popupImage.ShowPopup(Your Drawable File (R.drawable.cat));

# Features!

  - Set Popup Width and Height
  -             PopupImage popupImage = new PopupImage(mContext);
                popupImage.setPopupHeight(600);
                popupImage.setPopupWidth(600);
                popupImage.showPopup("http://via.placeholder.com/400x400");
                //or 
                popupImage.setPopupHeight(LayoutParams.WRAP_CONTENT);
                // default value: Height and Width => MATCH_PARENT
    -Set Image ScaleType
                
                 popupImage.setScaleType(ImageView.ScaleType.FIT_XY);
    -Set Click CallBack
                
                PopupImage popupImage = new PopupImage(MainActivity.this, new CallBack() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "click Test", Toast.LENGTH_SHORT).show();
                    }
                });
              popupImage.showPopup(bitmapObject);
  

  # That is all. Happy codes :)
  
  --
Please let me know if you have any problems.

