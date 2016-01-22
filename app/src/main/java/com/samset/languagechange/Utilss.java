package com.samset.languagechange;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by karamjeetsingh on 19/01/16.
 */
public class Utilss {


    public static String PREFRENCES="pref";
    public static String SELECTED_LANG="lang";






    public static void setPrefrences(AppCompatActivity act,int pos)
    {
        SharedPreferences sp = act.getSharedPreferences(PREFRENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(SELECTED_LANG, pos);
        editor.commit();
    }

    public static int getPrefrences(AppCompatActivity act)
    {
        SharedPreferences sp = act.getSharedPreferences(PREFRENCES, Context.MODE_PRIVATE);
        int ii=sp.getInt(SELECTED_LANG, 0);
        return ii;
    }

    public static void reLaunch(AppCompatActivity act) {
        Intent i = new Intent(act, MainActivity.class);//context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        act.startActivity(i);


    }


}
