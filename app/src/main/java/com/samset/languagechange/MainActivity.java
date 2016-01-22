package com.samset.languagechange;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ArrayList<String> lang = new ArrayList<>();
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lang.add("English");
        lang.add("Hindi");
        int saveLang = Utilss.getPrefrences(MainActivity.this);
        setLocale(saveLang);
        spinner = (Spinner) findViewById(R.id.spinner1);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        setSpinner();
    }

    public void setSpinner()
  {
      int saveLang = Utilss.getPrefrences(MainActivity.this);
      adapter = new MyCustomAdapter(this, R.layout.item, lang);
      spinner.setAdapter(adapter);
      //setLocale(saveLang);
      spinner.setOnItemSelectedListener(this);

      if (saveLang==0)
      {
          spinner.setSelection(0);

      }else if (saveLang==1)
      {
          spinner.setSelection(1);

      }
  }
    public void setId() {
        findViewById(R.id.txt5);
        findViewById(R.id.txt6);
        findViewById(R.id.txt7);
        findViewById(R.id.txt8);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String language = lang.get(position);

        int saveLang = Utilss.getPrefrences(MainActivity.this);
        Log.e("MainActivity", " onItemSelected");
        if (saveLang != position) {
            Utilss.setPrefrences(MainActivity.this, position);
            setLocale(position);
            Utilss.reLaunch(MainActivity.this);
            Log.e("MainActivity", " not match");
        }else
        {
            Log.e("MainActivity"," match");
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void setLocale(int pos) {

        Log.e("MainActivity"," setLocale");
        String lang = "";
        if (pos == 0) {
            lang = "en";
            Log.e("MainActivity"," En");
        } else if (pos == 1) {
            lang = "hi";
            Log.e("MainActivity"," Hi");
        }
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        MainActivity.this.setContentView(R.layout.activity_main);
        setId();

    }


}
