package com.icogroup.androidbaseproject.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ulises.harris on 12/14/15.
 */
public class SharedPreferencesUtil {

    private static final String PREF_NAME = "com.icogroup.netpago.preferences";

    public static final String SENT_TOKEN_TO_SERVER = "sentTokenToServer";
    public static final String REGISTRATION_COMPLETE = "registrationComplete";

    private static SharedPreferencesUtil sInstance;
    private final SharedPreferences mPref;

    private SharedPreferencesUtil(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SharedPreferencesUtil(context);
        }
    }

    public static synchronized SharedPreferencesUtil getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(SharedPreferencesUtil.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setValue(long value, String key) {
        mPref.edit()
                .putLong(key, value)
                .commit();
    }

    public void setValue(int value, String key) {
        mPref.edit()
                .putInt(key, value)
                .commit();
    }

    public void setValue(boolean value, String key) {
        mPref.edit()
                .putBoolean(key, value)
                .commit();
    }

    public void setValue(float value, String key) {
        mPref.edit()
                .putFloat(key, value)
                .commit();
    }

    public void setValue(String value, String key) {
        mPref.edit()
                .putString(key, value)
                .commit();
    }

    public long getValueLong(String key) {
        return mPref.getLong(key, 0);
    }

    public int getValueInt(String key) {
        return mPref.getInt(key, 0);
    }

    public String getValueString(String key) {
        return mPref.getString(key, "");
    }

    public boolean getValueBool(String key) {
        return mPref.getBoolean(key, false);
    }

    public float getValueFloat(String key) {
        return mPref.getFloat(key,0);
    }

    public void remove(String key) {
        mPref.edit()
                .remove(key)
                .commit();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }
}
