package com.gotution.app.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.gotution.app.application.goTutionApp;
import com.gotution.app.utils.ListUtils;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBWrapper {
    public static String LOG_TAG = DBWrapper.class.getSimpleName();

    private volatile static DBWrapper instance;

    private volatile static SharedPreferences.Editor editor;

    private volatile static SharedPreferences sharedPreferences ;

    public static DBWrapper getInstance(){
        if(instance == null){
            synchronized (DBWrapper.class) {
                instance = new DBWrapper();
                Context context = goTutionApp.getContext();
                sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
            }
        }
        instance.open();
        return instance;
    }

    private String getArray(StackTraceElement[] arrayStr){
        StringBuilder builder = new StringBuilder();
        for (StackTraceElement element: arrayStr) {
            builder.append(" ");
            builder.append(element.getClassName());
            builder.append(" ");
            builder.append(element.getMethodName());
        }
        return builder.toString();
    }

    private DBWrapper open(){
        return this;
    }

    public void close(){
        editor.apply();
    }

    public DBWrapper save(String key, String value){
        editor.putString(key, value);
        return this;
    }

    public static String get(String key, String defaultValue){
        getInstance();
        return sharedPreferences.getString(key, defaultValue);
    }

    public DBWrapper save(String key, String[] value){
        editor.putStringSet(key, new HashSet<> (Arrays.asList(value)));
        return this;
    }

    public DBWrapper save(String key, List<String> value){
        editor.putStringSet(key, ListUtils.convertListToSet(value));
        return this;
    }

    public static String[] getStringArray(String key, String[] defaultValue){
        getInstance();
        Set<String> valueSet = sharedPreferences.getStringSet(key, (defaultValue == null) ? null : new HashSet<>(Arrays.asList(defaultValue)));
        if (valueSet != null)
            return valueSet.toArray(new String[valueSet.size()]);
        else
            return null;
    }

    public static Set<String> getStringSet(String key, HashSet<String> defaultValue){
        getInstance();
        return sharedPreferences.getStringSet(key, defaultValue);
    }

    public DBWrapper save(String key, boolean value){
        editor.putBoolean(key, value);
        return this;
    }

    public static boolean getBoolean(String key, boolean defaultValue){
        getInstance();
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public DBWrapper save(String key, float value){
        editor.putFloat(key, value);
        return this;
    }

    public static float getFloat(String key, float defaultValue){
        getInstance();
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public DBWrapper save(String key, int value){
        editor.putInt(key, value);
        return this;
    }

    public static int getInt(String key, int defaultValue){
        getInstance();
        return sharedPreferences.getInt(key, defaultValue);
    }

    public DBWrapper save(String key, long value){
        editor.putLong(key, value);
        return this;
    }

    public static long getLong(String key, long defaultValue){
        getInstance();
        return sharedPreferences.getLong(key, defaultValue);
    }

    public DBWrapper save(String key, Object value){
        Gson gson = new Gson();
        editor.putString(key, gson.toJson(value));
        return this;
    }

    public static <T>T getObject(String key, Type classType , T defaultValue){
        getInstance();
        Gson gson = new Gson();
        String jsonString = sharedPreferences.getString(key, null);
        if(TextUtils.isEmpty(jsonString))
            return defaultValue;
        else
            return gson.fromJson(jsonString, classType);
    }

    public static <T>T getObject(String key, Class<T> className , T defaultValue){
        getInstance();
        Gson gson = new Gson();
        String jsonString = sharedPreferences.getString(key, null);
        if(TextUtils.isEmpty(jsonString))
            return defaultValue;
        else
            return gson.fromJson(jsonString, className);
    }

    public static boolean keyFound(String key){
        getInstance();
        return sharedPreferences.contains(key);
    }

    public DBWrapper delete(String key){
        editor.remove(key);
        return this;
    }
}
