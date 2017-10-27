package com.nearur.daa;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Knapsack extends AppCompatActivity {


    Button Go,result;
    EditText editText;
    ListView listView;
    MyAdapter myAdapter;
    ArrayList<Item> items;
    int maxvalue,maxweight;
    TextView textView;
    EditText capacity;
    RadioButton ratio,value,weight;
    int option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knapsack);
        editText=(EditText)findViewById(R.id.editTextnum);
        Go=(Button)findViewById(R.id.buttongo);
        result=(Button)findViewById(R.id.buttonresult);
        textView=(TextView)findViewById(R.id.result);
        listView=(ListView)findViewById(R.id.listview);
        capacity=(EditText)findViewById(R.id.capacity);
        ratio=(RadioButton)findViewById(R.id.bt1);
        value=(RadioButton)findViewById(R.id.bt2);
        weight=(RadioButton)findViewById(R.id.bt3);


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    maxvalue=0;
                Comparator<Item> com=new Comparator<Item>() {
                    @Override
                    public int compare(Item item, Item t1) {
                        int i=0;
                        switch (option){
                            case 1:
                                i=item.compareratio(t1);
                                break;
                            case 2:
                                i=item.compareValue(t1);
                                break;
                            case 3:
                                i=item.compareWeight(t1);
                                break;
                        }
                        return i;
                    }
                };

                Collections.sort(items,com);
                int cap=Integer.parseInt(capacity.getText().toString());
                    maxweight=cap;
                for(Item i:items){
                    if(Integer.parseInt(i.weight.getText().toString())<=cap){
                        cap=cap-Integer.parseInt(i.weight.getText().toString());
                        maxvalue+=Integer.parseInt(i.value.getText().toString());
                    }

                }
                    maxweight=maxweight-cap;
                textView.setVisibility(View.VISIBLE);
                textView.setText("Max Value is : "+maxvalue+"\n Total Weight : "+maxweight);
            }catch (Exception e){
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Error : "+e.toString());
            }
            }
        });

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create(Integer.parseInt(editText.getText().toString()));
                editText.setVisibility(View.GONE);
                Go.setVisibility(View.GONE);
                result.setVisibility(View.VISIBLE);
                capacity.setVisibility(View.VISIBLE);
                ratio.setVisibility(View.GONE);
                value.setVisibility(View.GONE);
                weight.setVisibility(View.GONE);
            }
        });
    }


    void create(int n){
        items=new ArrayList<>();
        for(int i=0;i<n;i++){
            items.add(new Item(String.valueOf(i+1),null,null));
        }
        myAdapter=new MyAdapter(getApplicationContext(),R.layout.item,items);
        if(ratio.isChecked()){
            option=1;
        }else if(weight.isChecked()){
            option=3;
        }else{
            option=2;
        }
        listView.setAdapter(myAdapter);
    }
}
