package com.icogroup.androidbaseproject.util;

import android.util.Patterns;

import java.util.ArrayList;

/**
 * Created by Ulises.harris on 12/10/15.
 */
public class StringUtil {

    private static String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    static String ptVisa = "^4[0-9]{6,}$";
    static String ptMasterCard = "^5[1-5][0-9]{5,}$";
    static String ptAmeExp = "^3[47][0-9]{5,}$";


    public static boolean isValidEmail(String email) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static String getFirstLetterCapitalize(String word) {

        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

}
