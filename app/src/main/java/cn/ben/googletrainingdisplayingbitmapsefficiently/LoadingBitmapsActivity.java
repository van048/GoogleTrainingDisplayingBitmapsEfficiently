package cn.ben.googletrainingdisplayingbitmapsefficiently;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class LoadingBitmapsActivity extends AppCompatActivity {

    @SuppressWarnings("FieldCanBeLocal")
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_bitmaps);
        mImageView = (ImageView) findViewById(R.id.iv_display);

        readDimAndType();

        mImageView.setImageBitmap(
                BitmapUtil.decodeSampledBitmapFromResource(getResources(), R.drawable.myimage, 100, 100));
    }

    private void readDimAndType() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.myimage, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;
        Toast.makeText(this, "imageHeight: " + imageHeight
                + "\nimageWidth: " + imageWidth
                + "\nimageType: " + imageType, Toast.LENGTH_SHORT).show();
    }

    public void jump(@SuppressWarnings("UnusedParameters") View view) {
        startActivity(new Intent(this, OffUIThreadActivity.class));
    }
}
