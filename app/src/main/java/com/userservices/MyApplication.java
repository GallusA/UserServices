package com.userservices;

import android.app.Application;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by gallusawa on 8/14/17.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
}
