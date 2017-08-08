package com.cheng.cc.lemonman.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by c.c on 2017/2/26.
 * 共享参数类
 */
public class SharedPreferencesUtils {

    private static SharedPreferencesUtils sharedPreferencesUtils = null;


    private SharedPreferences userInfo;
    private SharedPreferences.Editor userInfoEditor;


    private SharedPreferencesUtils(){

    }

    private Context context;
    public static SharedPreferencesUtils getInstance(Context context){
        if (sharedPreferencesUtils == null){
            sharedPreferencesUtils = new SharedPreferencesUtils();
            sharedPreferencesUtils.setContext(context);
        }
        return sharedPreferencesUtils;

    }

    public void setContext(Context context) {
        this.context = context;
    }

    public SharedPreferences getSPUser(){
        userInfo = context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
        return userInfo;
    }

    private SharedPreferences getSPUser(String name) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }


    //取Boolean 型数据
    public boolean getBoolean(String key, boolean defValue) {
        try {
            return getSPUser().getBoolean(key, defValue);
        } catch (NullPointerException exception) {
            Log.d("ex", "" + exception);
            return defValue;
        }
    }

    public boolean getBoolean(String key) {
        try {
            return getSPUser().getBoolean(key, false);
        } catch (NullPointerException exception) {
            Log.d("ex", "" + exception);
            return false;
        }
    }


    //存Boolean 型数据
    public void putBoolean(String key, boolean value) {
        try {
            SharedPreferences.Editor editor = getSPUser().edit();
            editor.putBoolean(key, value);
            editor.commit();
        } catch (NullPointerException exception) {
            Log.d("ex", "" + exception);
        }
    }




    //取Long 型数据
    public long getLong(String key, long defValue) {
        try {
            return getSPUser().getLong(key, defValue);
        } catch (NullPointerException exception) {
            Log.d("ex", "" + exception);
            return defValue;
        }
    }
    //存Long 型数据
    public void putLong(String key, long value) {
        try {
            SharedPreferences.Editor editor = getSPUser().edit();
            editor.putLong(key, value);
            editor.commit();
        } catch (NullPointerException exception) {
            Log.d("ex", "" + exception);
        }
    }



    //取整型
    public int getInt(String key, int defaultValue) {
        try {
            return getSPUser().getInt(key, defaultValue);
        } catch (Exception e) {
            Log.d("ex", "" + e);
            return defaultValue;

        }
    }

    //存整型
    public void putInt(String key, int value) {
        try {
            SharedPreferences.Editor editor = getSPUser().edit();
            editor.putInt(key, value);
            editor.commit();
        } catch (Exception e) {
            Log.d("ex", "" + e);
        }
    }



    //取String
    public String getString(String key, String defValue) {
        try {
            return getSPUser().getString(key, defValue);
        } catch (NullPointerException e) {
            Log.d("ex", "" + e);
            return defValue;
        }
    }

    //存String
    public void putString(String key, String value) {
        try {
            SharedPreferences.Editor editor = getSPUser().edit();
            editor.putString(key, value);
            editor.commit();
        } catch (NullPointerException e) {
            Log.d("ex", "" + e);
        }
    }

    //清除数据
    public void clear() {
        try {
            SharedPreferences.Editor editor = getSPUser().edit();
            editor.clear();
            editor.commit();
        } catch (NullPointerException e) {
            Log.d("ex", "" + e);
        }
    }



}
