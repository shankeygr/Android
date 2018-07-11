package com.gotution.app.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

import com.gotution.app.utils.CommonLib;
import com.gotution.gotution.R;

import java.util.Map;
import java.util.UUID;

public class goTutionApp  extends Application {
    private static final String LOG_TAG = goTutionApp.class.getSimpleName();

    private static Context mContext;
    private static Application mApplication;
    private static String density;
    private static Typeface typefaceRegular;
    private static Typeface typefaceMedium;
    private static Typeface typeFaceLight;
    private static Typeface typefaceIconFont;
    private static Typeface typefaceBold;
    private boolean isAPKLoadingDone;
    public static boolean isPopUpShown = false;
    public static boolean locationCheckAtHome;
    public static String sessionKey;

    private static int screenHeight;
    private static int screenWidth;
    private static float dpHeight;
    private static float dpWidth;
    private static float screenHeightInInch;
    private static float screenDensity;
    private static int screenDensityDpi;


    public void onCreate() {
        super.onCreate ();
        initialise ();
        calculateScreenMetrics ();
        setupUIParams ();
    }

    private void initialise() {
        mContext = getApplicationContext ();
        mApplication = this;
        sessionKey = UUID.randomUUID().toString();
    }



    private void calculateScreenMetrics() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenDensity = displayMetrics.density;
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
        screenDensityDpi = displayMetrics.densityDpi;

        dpHeight = screenHeight / displayMetrics.density;
        dpWidth = screenWidth / displayMetrics.density;

        double x = Math.pow((double) displayMetrics.widthPixels / (double) displayMetrics.densityDpi, 2);
        double y = Math.pow((double) displayMetrics.heightPixels / (double) displayMetrics.densityDpi, 2);
        screenHeightInInch = (float) Math.sqrt(x + y);

        if (screenWidth <= 480)
            density = "480px";
        else if (screenWidth <= 580)
            density = "580px";
        else if (screenWidth <= 650)
            density = "650px";
        else if (screenWidth <= 700)
            density = "700px";
        else if (screenWidth <= 750)
            density = "750px";
        else if (screenWidth <= 800)
            density = "800px";
        else if (screenWidth <= 920)
            density = "920px";
        else if (screenWidth <= 1000)
            density = "1000px";
        else
            density = "1080px";
    }

    private void setupUIParams() {
        typefaceBold = CommonLib.getTypeFaceBold(getApplicationContext());
        typefaceRegular = CommonLib.getTypeFaceRegular(getApplicationContext());
        typefaceMedium = CommonLib.getTypeFaceMedium(getApplicationContext());
        typeFaceLight = CommonLib.getTypeFaceLight(getApplicationContext());
        typefaceIconFont = CommonLib.getTypeFaceCustomFont(getApplicationContext());

    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    public static Application getApplication() {
        return mApplication;
    }

    public static Context getContext() {
        return mContext;
    }


    public static String getDensityString() {
        return density;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static float getDpHeight() {
        return dpHeight;
    }

    public static float getDpWidth() {
        return dpWidth;
    }

    public static float getScreenHeightInInch() {
        return screenHeightInInch;
    }

    public static float getScreenDensity() {
        return screenDensity;
    }

    public static int getScreenDensityDpi() {
        return screenDensityDpi;
    }

    public static Typeface getTypefaceBold() {
        return typefaceBold;
    }

    public static Typeface getTypeFaceRegular() {
        return typefaceRegular;
    }

    public static Typeface getTypeFaceMedium() {
        return typefaceMedium;
    }

    public static Typeface getTypeFaceLight() {
        return typeFaceLight;
    }

    public static Typeface getTypefaceIconFont() {
        return typefaceIconFont;
    }

}