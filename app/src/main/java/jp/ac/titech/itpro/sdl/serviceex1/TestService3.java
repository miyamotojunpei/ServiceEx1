package jp.ac.titech.itpro.sdl.serviceex1;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class TestService3 extends IntentService {
    private final static String TAG = "TestService3";
    public final static String EXTRA_MYARG = "MYARG";

    TestService3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        try {
            Intent broadcastIntent = new Intent();
            broadcastIntent.putExtra("message", "TestService3");
            broadcastIntent.setAction("toast");
            getBaseContext().sendBroadcast(broadcastIntent);
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}