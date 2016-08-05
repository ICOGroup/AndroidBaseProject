package com.icogroup.androidbaseproject.util;

import android.content.Context;

import com.icogroup.androidbaseproject.data.entity.User;

/**
 * Created by Ulises.harris on 8/5/16.
 */
public class UserUtil {

    private static String USER_ID_PREFERENCES = "user_id_number";
    private static String USER_EMAIL_PREFERENCES = "user_email";
    private static String USER_NAME_PREFERENCES = "user_name";
    private static String USER_SURNAME_PREFERENCES = "user_surname";

    public static void setUser(Context context, User user) {
        SharedPreferencesUtil.initializeInstance(context);
        SharedPreferencesUtil.getInstance().setValue(user.getId(), USER_ID_PREFERENCES);
        SharedPreferencesUtil.getInstance().setValue(user.getEmail(), USER_EMAIL_PREFERENCES);
        SharedPreferencesUtil.getInstance().setValue(user.getName(), USER_NAME_PREFERENCES);
        SharedPreferencesUtil.getInstance().setValue(user.getSurname(), USER_SURNAME_PREFERENCES);

    }

    public static User getUser(Context context) {
        SharedPreferencesUtil.initializeInstance(context);
        User user = new User();
        user.setId(SharedPreferencesUtil.getInstance().getValueString(USER_ID_PREFERENCES));
        user.setEmail(SharedPreferencesUtil.getInstance().getValueString(USER_EMAIL_PREFERENCES));
        user.setName(SharedPreferencesUtil.getInstance().getValueString(USER_NAME_PREFERENCES));
        user.setSurname(SharedPreferencesUtil.getInstance().getValueString
                (USER_SURNAME_PREFERENCES));

        return user;
    }
}
