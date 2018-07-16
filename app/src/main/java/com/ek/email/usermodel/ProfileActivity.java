package com.ek.email.usermodel;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ek.email.usermodel.base.BaseActivity;
import com.ek.email.usermodel.storage.UserModel;
import com.ek.email.usermodel.storage.UserPreferences;

public class ProfileActivity extends BaseActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_profile;
    }

    @Override
    protected Context getContext() {
        return this;
    }

    @Override
    protected void initViews() {

        UserModel userModel= UserPreferences.getInstance().readUser();
        String name =""+userModel.getFullName();
        String token =""+ userModel.getUserToken();
        Log.d("selam",name);
        Toast.makeText(this, "deneme "+ name , Toast.LENGTH_SHORT).show();

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ProfileActivity.this,MainActivity.class));
        finish();
    }
}
