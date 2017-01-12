package cn.ben.googletrainingdisplayingbitmapsefficiently;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ImageGridActivity extends AppCompatActivity {

    private static final String IMAGE_GRID_FRAG_TAG = "image_grid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().findFragmentByTag(IMAGE_GRID_FRAG_TAG) == null)
            fragmentTransaction.add(R.id.container, new ImageGridFragment(), IMAGE_GRID_FRAG_TAG).commit();
    }
}
