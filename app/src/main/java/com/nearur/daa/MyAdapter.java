package com.nearur.daa;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrdis on 10/17/2017.
 */

public class MyAdapter extends ArrayAdapter {
    Context context; int resource; ArrayList<Item> objects;


    public MyAdapter(Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= LayoutInflater.from(context).inflate(resource,parent,false);
        TextView textView=(TextView)v.findViewById(R.id.srno);
        EditText editTextvalue=(EditText)v.findViewById(R.id.value);
        EditText editTextweight=(EditText)v.findViewById(R.id.weight);

        textView.setText(objects.get(position).name+"");

        objects.get(position).value=editTextvalue;
        objects.get(position).weight=editTextweight;


        return v;
    }
}
