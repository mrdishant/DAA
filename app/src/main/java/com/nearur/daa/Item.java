package com.nearur.daa;

import android.widget.EditText;

/**
 * Created by mrdis on 10/17/2017.
 */

public class Item {

    String name;
    EditText value,weight;
    public Item(String name, EditText value, EditText weight) {
        super();
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    int compareWeight(Item x) {
        if(Integer.parseInt(x.weight.getText().toString())>=Integer.parseInt(weight.getText().toString())) {
            return -1;
        }return 1;
    }

    int compareValue(Item x) {
        if(Integer.parseInt(x.value.getText().toString())>=Integer.parseInt(value.getText().toString())) {
            return 1;
        }return -1;
    }

    int compareratio(Item x) {
        int v=Integer.parseInt(x.value.getText().toString());
        int w=Integer.parseInt(x.weight.getText().toString());

        int v1=Integer.parseInt(value.getText().toString());
        int w1=Integer.parseInt(weight.getText().toString());
        if(v/w>=v1/w1) {
            return 1;
        }return -1;
    }

}
