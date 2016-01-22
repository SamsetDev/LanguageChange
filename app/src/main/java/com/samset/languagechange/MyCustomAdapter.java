package com.samset.languagechange;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by karamjeetsingh on 19/01/16.
 */
public class MyCustomAdapter extends ArrayAdapter<String> {

    private Context activity;
    private ArrayList<String> data;
    LayoutInflater inflater;

    /*************  CustomAdapter Constructor *****************/
    public MyCustomAdapter(Context activitySpinner,int textViewResourceId,ArrayList<String> objects)
    {        super(activitySpinner, textViewResourceId, objects);

        /********** Take passed values **********/
        activity = activitySpinner;
        data     = objects;


        /***********  Layout inflator to call external xml layout () **********************/
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        View row = inflater.inflate(R.layout.item, parent, false);

        /***** Get each Model object from Arraylist ********/

        TextView label        = (TextView)row.findViewById(R.id.items);

            label.setText(data.get(position));




        return row;
    }




}
