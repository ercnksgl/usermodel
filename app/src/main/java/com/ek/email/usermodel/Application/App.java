package com.ek.email.usermodel.Application;


import android.content.Context;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDexApplication;
import android.util.Log;


public class App extends MultiDexApplication {

    private final String TAG = "App";
    public static App instance = null;

    @Override
    public void onCreate() {
        super.onCreate();


        instance = this;

    }

    private String getAppVersion(Context context) {
        String result = "";

        try {
            result = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0)
                    .versionName;
            result = result.replaceAll("[a-zA-Z]|-", "");
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }

        return result;
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }
}
