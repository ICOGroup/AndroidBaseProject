package com.icogroup.androidbaseproject.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Ulises.harris on 4/28/16.
 */
public class FontUtil {

    public final static int SANSPRO_BLACK = 0;
    public final static int SANSPRO_BLAC_ITALIC = 1;
    public final static int SANSPRO_BOLD = 2;
    public final static int SANSPRO_BOLD_ITALIC = 3;
    public final static int SANSPRO_EXTRA_LIGHT = 4;
    public final static int SANSPRO_EXTRA_LIGHT_ITALIC = 5;
    public final static int SANSPRO_ITALIC = 6;
    public final static int SANSPRO_LIGHT = 7;
    public final static int SANSPRO_LIGHT_ITALIC = 8;
    public final static int SANSPRO_REGULAR = 9;
    public final static int SANSPRO_SEMI_BOLD = 10;
    public final static int SANSPRO_SEMI_BOLD_ITALIC = 11;

    public static Typeface getTypeFace(Context context, int type) {
        switch (type) {
            case SANSPRO_BLACK:
                return Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Black" +
                        ".ttf");

            case SANSPRO_BLAC_ITALIC:
                return Typeface.createFromAsset(context.getAssets(),
                        "fonts/SourceSansPro-BlackItalic.ttf");

            case SANSPRO_BOLD:
                return Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Bold" +
                        ".ttf");

            case SANSPRO_BOLD_ITALIC:
                return Typeface.createFromAsset(context.getAssets(),
                        "fonts/SourceSansPro-BoldItalic.ttf");

            case SANSPRO_EXTRA_LIGHT:
                return Typeface.createFromAsset(context.getAssets(),
                        "fonts/SourceSansPro-ExtraLight.ttf");

            case SANSPRO_EXTRA_LIGHT_ITALIC:
                return Typeface.createFromAsset(context.getAssets(),
                        "fonts/SourceSansPro-ExtraLightItalic.ttf");

            case SANSPRO_ITALIC:
                return Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Italic" +
                        ".ttf");

            case SANSPRO_LIGHT:
                return Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Light" +
                        ".ttf");

            case SANSPRO_LIGHT_ITALIC:
                return Typeface.createFromAsset(context.getAssets(),
                        "fonts/SourceSansPro-LightItalic.ttf");

            case SANSPRO_REGULAR:
                return Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Regular" +
                        ".ttf");

            case SANSPRO_SEMI_BOLD:
                return Typeface.createFromAsset(context.getAssets(),
                        "fonts/SourceSansPro-Semibold.ttf");

            case SANSPRO_SEMI_BOLD_ITALIC:
                return Typeface.createFromAsset(context.getAssets(),
                        "fonts/SourceSansPro-SemiboldItalic.ttf");

            default:
                return Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Regular" +
                        ".ttf");
        }

    }
}
