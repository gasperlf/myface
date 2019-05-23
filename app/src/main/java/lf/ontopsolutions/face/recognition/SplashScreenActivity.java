package lf.ontopsolutions.face.recognition;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = "SplashScreenActivity";
    private Handler mWaitHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mWaitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    Log.d(TAG, "run: time to delay splash");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 6000);

        Log.d(TAG, "onCreate: executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWaitHandler.removeCallbacks(null);
        Log.d(TAG, "onDestroy: executed");
    }
}
