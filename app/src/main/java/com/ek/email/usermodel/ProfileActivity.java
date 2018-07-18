package com.ek.email.usermodel;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ek.email.usermodel.storage.UserModel;
import com.ek.email.usermodel.storage.UserPreferences;

public class ProfileActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        button = findViewById(R.id.button);


        final UserPreferences userPreferences = new UserPreferences(this);
        UserModel us = userPreferences.readUser();
        Toast.makeText(this, "token: " + us.getUserToken() + "\n" +
                        "ad: " + us.getName() + "\n" +
                        "soyad: " + us.getSurName() + "\n"
                , Toast.LENGTH_SHORT).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        UserPreferences userPreferences1= new UserPreferences(ProfileActivity.this);
        UserModel userModel=userPreferences1.readUser();
        userModel.setName("Sen kim?");
        userModel.setSurName("Ben mi?");
        userModel.setUserToken("asdasdg54hjd6fg77ghj1mnyu6sy55asd54as54as9gh4j");
        userPreferences1.setUserPreference(userModel);
        startActivity(new Intent(ProfileActivity.this,ProfileActivity.class));
        finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        finish();
    }
}
