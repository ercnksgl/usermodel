package com.ek.email.usermodel.base;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


/**
 * Base Activity tüm activity sınıflarından extends edilebilecek şekilde oluşturulmuş soyut sınıftır.
 * Gerekli olan metodları kod tekrarı olmaması için buradan çağırarak kullanılmıştır.
 */
public abstract class BaseActivity extends AppCompatActivity implements FailureView {
    public static final String TAG = "BaseActivity";


    /**
     * Dönen yükleme diyaloğunu tutar.
     */


    /**
     * Her Activity'nin ait olan layoutların id si Activity'lerde override edilmiştir. Activity'lerde
     * Layout kimliğini döndürür.
     *
     * @return Activity Layout kimliği
     */
    protected abstract int getLayoutResourceId();

    /**
     * Açık Activity'nin Context'ini metodu çağırana gönderir.
     *
     * @return açık Activity Context'i
     */
    protected abstract Context getContext();

    /**
     * Activity'nin görünümlerini başlatır.
     */
    protected abstract void initViews();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        isActivityRunning = true;

    }

    /**
     * Mesaj içeren bir SnackBar görüntüler.
     *
     * @param msg gösterilen mesaj
     */


    /**
     * Verilen ListView içerisinde verilen konumda bulunan görünümü gönderir.
     *
     * @param pos      Görünümü içeren pozisyon
     * @param listView Görünümü içeren ListView
     * @return         istenen görünüm
     */
    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;
        if (pos < firstListItemPosition || pos > lastListItemPosition) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

    /**
     * Başka Activity başlatıcısıdır.
     *
     * @param thisContext Açık olan Activity Context'i
     * @param nextClass   Başlatılacak Activity
     */
    public void goToAnotherActivity(Context thisContext, Class nextClass) {
        Intent intent = new Intent(thisContext, nextClass);
        startActivity(intent);
        finish();
    }

    /**
     * Güncel görünümü alır ve broadcast bağlantısını kontrol eder.
     *
     * @param currentViewId Güncel görünüm kimliği
     */


    /**
     * Dönen yükleme diyaloğu gösterir.
     */


    /**
     * Önceden oluşturulmuş yükleme diyaloğu varsa gizler.
     *

     */


    /**
     * Kullanıcıların telefon numaraları için uzunluk format sınırı koyar.
     *
     * @param countryCode     Kullanıcının bulunduğu ülke kodu
     * @param userPhoneNumber Kullanıcının girdiği telefon numarası
     */
    public void setLength(String countryCode, EditText userPhoneNumber) {
        int lengthNumber;

        if (countryCode.equalsIgnoreCase("IQ")
                || countryCode.equalsIgnoreCase("SA")
                || countryCode.equalsIgnoreCase("EG")
                || countryCode.equalsIgnoreCase("TR")) {
            lengthNumber = 10;
        } else if (countryCode.equalsIgnoreCase("JO")
                || countryCode.equalsIgnoreCase("AE")
                || countryCode.equalsIgnoreCase("SY")
                || countryCode.equalsIgnoreCase("IL")
                || countryCode.equalsIgnoreCase("YE")
                || countryCode.equalsIgnoreCase("MA")
                || countryCode.equalsIgnoreCase("DZ")
                || countryCode.equalsIgnoreCase("SD")) {
            lengthNumber = 9;
        } else if (countryCode.equalsIgnoreCase("QA")
                || countryCode.equalsIgnoreCase("KW")
                || countryCode.equalsIgnoreCase("BH")
                || countryCode.equalsIgnoreCase("OM")) {
            lengthNumber = 8;
        } else {
            lengthNumber = 12;
        }
        userPhoneNumber.setText("");
        userPhoneNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(lengthNumber)});
    }

    Dialog errorDialog; // Birden fazla hata durumunda tek dialog gosterme kontrolu icin
    /**
     * Sayfa yenileme butonu içeren hata diyaloğu gösterir.
     */




    protected boolean isActivityRunning;
    @Override
    protected void onStop() {
        super.onStop();
        isActivityRunning = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (errorDialog != null) errorDialog.dismiss();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}