package adem_bulut.com.sample_popupimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import adem_bulut.com.popupimage.CallBacks.CallBack;
import adem_bulut.com.popupimage.PopupImage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupImage popupImage = new PopupImage(MainActivity.this, new CallBack() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "click Test", Toast.LENGTH_SHORT).show();
                    }
                });
               /* popupImage.setPopupHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                popupImage.setPopupWidth(ViewGroup.LayoutParams.MATCH_PARENT);*/
                popupImage.setPopupHeight(600);
                popupImage.setPopupWidth(600);
                popupImage.setScaleType(ImageView.ScaleType.FIT_XY);
                popupImage.ShowPopup("https://i2.wp.com/beebom.com/wp-content/uploads/2016/01/Reverse-Image-Search-Engines-Apps-And-Its-Uses-2016.jpg");
            }
        });
    }
}
