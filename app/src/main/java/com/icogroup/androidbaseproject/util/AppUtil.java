package com.icogroup.androidbaseproject.util;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Ulises.harris on 4/29/16.
 */
public class AppUtil {

    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context
                    .INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getApplicationWindowToken(), 0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
