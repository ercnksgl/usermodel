package com.ek.email.usermodel.storage;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class App extends MultiDexApplication {
    public static App instance = null;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;


    }



    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }
}
