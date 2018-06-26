package adem_bulut.com.popupimage;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import adem_bulut.com.popupimage.CallBacks.CallBack;

public class PopupImage {
    private Bitmap bitmap;
    private Context context;
    private int POPUP_HEIGHT = ViewGroup.LayoutParams.MATCH_PARENT;
    private int POPUP_WIDTH = ViewGroup.LayoutParams.MATCH_PARENT;
    private CallBack callBack;
    private ImageView imageView;

    public ImageView.ScaleType getScaleType() {
        return scaleType;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    private ImageView.ScaleType scaleType;

    public PopupImage(Context context) {
        this.context = context;
    }

    public PopupImage(Context context, CallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    public void ShowPopup(Bitmap bitmap) {
        this.bitmap = bitmap;
        show();
    }

    public void ShowPopup(int drawable) {
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), drawable);
        show();
    }

    public void ShowPopup(String url) {
        Picasso.get().load(url).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap b, Picasso.LoadedFrom from) {
                bitmap = b;
                show();
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                e.printStackTrace();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }

    private void initPopupEvent() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onClick();
            }
        });
    }

    private void show() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.popup, null);
        imageView = v.findViewById(R.id.image_view);
        imageView.setImageBitmap(bitmap);
        Dialog dialog = new Dialog(context);
        dialog.setCancelable(true);
        dialog.setContentView(v);
        ViewGroup.LayoutParams params = v.getLayoutParams();
        params.height = POPUP_HEIGHT;
        params.width = POPUP_WIDTH;
        if (scaleType != null)
            imageView.setScaleType(scaleType);
        if (callBack != null)
            initPopupEvent();
        v.setLayoutParams(params);

        dialog.show();
    }

    public int getPopupHeight() {
        return POPUP_HEIGHT;
    }

    public void setPopupHeight(int popupHeight) {
        POPUP_HEIGHT = popupHeight;
    }

    public int getPopupWidth() {
        return POPUP_WIDTH;
    }

    public void setPopupWidth(int popupWidth) {
        POPUP_WIDTH = popupWidth;
    }


}
