package com.ek.email.usermodel;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ek.email.usermodel.storage.UserModel;
import com.ek.email.usermodel.storage.UserPreferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

UserPreferences userPreferences=new UserPreferences(this);
        UserModel userModel = userPreferences.readUser();
        userModel.setUserToken("asdasd");
        userModel.setName("Ercan");
        userModel.setSurName("Köseoğlu");
       userPreferences.setUserPreference(userModel);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        finish();
    }
}
