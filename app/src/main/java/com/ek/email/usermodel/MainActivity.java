package com.ek.email.usermodel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ek.email.usermodel.base.BaseActivity;
import com.ek.email.usermodel.storage.UserModel;
import com.ek.email.usermodel.storage.UserPreferences;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected Context getContext() {
        return this;
    }

    @Override
    protected void initViews() {

        UserModel userModel = UserPreferences.getInstance().readUser();
        userModel.setFullName("Ercan Köseoğlu");
        userModel.setUserToken("asdlşaflşagalföaöfia54445asdasd");
        UserPreferences.getInstance().setUserPreference(userModel);

    }





    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(MainActivity.this,ProfileActivity.class));
        finish();
    }
}
