package com.ek.email.usermodel.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ek.email.usermodel.Utils.FinalString;
import com.google.gson.Gson;


/**
 * Kullannıcı modelinin cihaza kaydedilmesini kontrol eder.
 */
public class UserPreferences {

    //private static UserPreferences instance = new UserPreferences();
    private static final String SP_LOG = "User Preference";
    private SharedPreferences sharedPreferences;


    public UserPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(FinalString.USER_KEY, Context.MODE_PRIVATE);

    }

    public static UserPreferences getInstance() {

        return null;
    }

    public void setUserPreference(UserModel userModel) {

        try {
            Log.i(SP_LOG, "user:" + userModel.toString());
            Gson gson = new Gson();
            String stringUser = gson.toJson(userModel);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(FinalString.USER_KEY, stringUser);
            boolean result = editor.commit();
            if (result) {
                Log.i(SP_LOG, "user kayıt yapıldı");
            } else {
                Log.i(SP_LOG, "user kayıt yapılamadı!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public UserModel readUser() {

        try {
            Gson gson = new Gson();
            String json = sharedPreferences.getString(FinalString.USER_KEY, FinalString.EMPTY_STRING);
            Log.i(SP_LOG, "" + json);
            return gson.fromJson(json, UserModel.class);
        } catch (Exception e) {
            Log.e(SP_LOG, "readUser");
            e.printStackTrace();
        }
        return null;
    }


}


// // feedback bir kere verilmesi icin
//    public void setMissedCallFeedback(boolean isFedBack) {
//        try {
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putBoolean("missed_call_feedback", isFedBack);
//            boolean result = editor.commit();
//            if (result) {
//                Log.i(SP_LOG, "missed call isfedback yapıldı");
//            } else {
//                Log.i(SP_LOG, "missed call isfedback kaydedilemedi!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean isMissedCallFedback() {
//        try {
//            return sharedPreferences.getBoolean("missed_call_feedback", false);
//        } catch (Exception e) {
//            Log.e(SP_LOG, "readListenlyDetail");
//            e.printStackTrace();
//        }
//        return false;
//    }