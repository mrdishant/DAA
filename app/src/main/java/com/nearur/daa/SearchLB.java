package com.nearur.daa;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;

public class SearchLB extends AppCompatActivity {

    EditText list,item;
    Button linear,binary;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_lb);
        list=(EditText)findViewById(R.id.editTextlist);
        item=(EditText)findViewById(R.id.editTextitem);
        linear=(Button)findViewById(R.id.buttonlinear);
        binary=(Button)findViewById(R.id.buttonbinary);
        textView=(TextView)findViewById(R.id.textdetails);

        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found=false;
                if(list.getText().toString().length()>0&&item.getText().length()>0){
                    long start=System.currentTimeMillis();
                    String[] listvalues=list.getText().toString().trim().split(" ");
                    int idx=0;
                    for(String x:listvalues){
                        if(x.equals(item.getText().toString())){
                            found=true;
                            break;
                        }
                        idx++;
                    }
                    AlertDialog.Builder builder=new AlertDialog.Builder(SearchLB.this);
                    builder.setTitle("Linear Search");
                    long finish=System.currentTimeMillis();
                    if (found){
                        builder.setMessage("\'"+item.getText().toString()+"\'"+" found at "+(idx+1)+" position "+"\nTime taken "+(finish-start)+" milliseconds");
                    }else{
                        builder.setMessage("\'"+item.getText().toString()+"\'"+" not found"+"\nTime taken "+(finish-start)+" milliseconds");
                    }
                    builder.create().show();
                }else{
                    Toast.makeText(SearchLB.this,"Please enter Valid values",Toast.LENGTH_LONG).show();
                }
            }
        });

        binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found=false;
                if(list.getText().toString().length()>0&&item.getText().length()>0){
                    long start=System.currentTimeMillis();
                    String[] listvalues=list.getText().toString().trim().split(" ");
                    int[] a=new int[listvalues.length];
                    for(int i=0;i<a.length;i++){
                        a[i]=Integer.parseInt(listvalues[i].trim());
                    }
                    Arrays.sort(a);
                    int beg=0,end=a.length-1,mid=0;
                    while (beg<=end){
                        mid=(beg+end)/2;
                        if(a[mid]==Integer.parseInt(item.getText().toString().trim())){
                            found=true;
                            break;
                        }
                        else if(a[mid]<Integer.parseInt(item.getText().toString().trim())){
                            beg=mid+1;
                        }else{
                            end=mid-1;
                        }
                    }
                    AlertDialog.Builder builder=new AlertDialog.Builder(SearchLB.this);
                    builder.setTitle("Binary Search");
                    long finish=System.currentTimeMillis();
                    if (found){
                        builder.setMessage("\'"+item.getText().toString()+"\'"+" found at "+(mid+1)+" position (Sorted List)"+"\nTime taken "+(finish-start)+" milliseconds");
                    }else{
                        builder.setMessage("\'"+item.getText().toString()+"\'"+" not found"+"\nTime taken "+(finish-start)+" milliseconds");
                    }
                    builder.create().show();
                }else{
                    Toast.makeText(SearchLB.this,"Please enter Valid values",Toast.LENGTH_LONG).show();
                }
            }
        });


        binary.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String  buffer="int beg=0,end=a.length-1,mid=0;\n" +
                        "       while (beg<=mid){\n" +
                        "         mid=(beg+end)/2;\n" +
                        "         if(a[mid]==item){\n" +
                        "            found=true;\n" +
                        "            break;\n" +
                        "         }\n" +
                        "         else if(a[mid]<item){\n" +
                        "                beg=mid+1;\n" +
                        "         }else{\n" +
                        "             end=mid-1;\n" +
                        "         }\n" +
                        "       }";
                textView.setText(buffer.toString());
                return false;
            }
        });


        linear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String  buffer="int idx=0;\n" +
                        "   for(int x:listvalues){\n" +
                        "    if(x==item){\n" +
                        "      found=true;\n" +
                        "      break;\n" +
                        "    }\n" +
                        "    idx++;\n" +
                        "   }";
                textView.setText(buffer.toString());
                return false;
            }
        });
    }
}
