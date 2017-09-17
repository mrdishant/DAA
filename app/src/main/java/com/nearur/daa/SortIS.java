package com.nearur.daa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SortIS extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {

    Button insertion,selection;
    TextView result;
    EditText editText;
    int[] array;
    CheckedTextView checkedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_is);


        insertion=(Button)findViewById(R.id.buttoni);
        selection=(Button)findViewById(R.id.buttons);

        editText=(EditText)findViewById(R.id.editTextlist);
        result=(TextView)findViewById(R.id.textViewresult);

        checkedTextView=(CheckedTextView)findViewById(R.id.checkedTextViewdetails);

        insertion.setOnClickListener(this);
        selection.setOnClickListener(this);

        insertion.setOnLongClickListener(this);
        selection.setOnLongClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(editText.getText().toString().length()>0) {

            result.setText("");
            String[] strings = editText.getText().toString().split(",");
            array = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                array[i] = Integer.parseInt(strings[i].trim());
            }
            if (id == R.id.buttoni) {
                long start = System.currentTimeMillis();
                Toast.makeText(this, "Insertion Sort", Toast.LENGTH_LONG).show();
                for (int i = 1; i < array.length; i++) {
                    int p = i - 1;
                    int temp = array[i];
                    while (p >= 0 && temp < array[p]) {
                        array[p + 1] = array[p];
                        p--;
                    }
                    array[p + 1] = temp;
                }
                StringBuffer buffer = new StringBuffer();
                for (int j = 0; j < array.length; j++) {
                    buffer.append(array[j] + ",");
                }
                result.setVisibility(View.VISIBLE);
                result.setText("Insertion Sort \n" + buffer.toString().substring(0, buffer.length() - 1) + "\nTime Taken " + (System.currentTimeMillis() - start) + " milliseconds");

            } else if (id == R.id.buttons) {
                long start = System.currentTimeMillis();
                Toast.makeText(this, "Selection Sort", Toast.LENGTH_LONG).show();
                for (int i = 0; i < array.length; i++) {
                    int s = i;
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[s] > array[j]) {
                            s = j;
                        }
                    }
                    if (s != i) {
                        array[i] = array[s] + array[i];
                        array[s] = array[i] - array[s];
                        array[i] = array[i] - array[s];
                    }
                }
                StringBuffer buffer = new StringBuffer();
                for (int j = 0; j < array.length; j++) {
                    buffer.append(array[j] + ",");
                }
                result.setVisibility(View.VISIBLE);
                result.setText("Selection Sort \n" + buffer.toString().substring(0, buffer.length() - 1) + "\nTime Taken " + (System.currentTimeMillis() - start) + " milliseconds");

            }
        }else{
            Toast.makeText(this,"Enter Valid List",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onLongClick(View view) {
        int id=view.getId();

        if(id==R.id.buttoni){
            checkedTextView.setVisibility(View.VISIBLE);
            checkedTextView.setText("for(int i=1;i<array.length;i++){\n" +
                    "  int p=i-1;\n" +
                    "  int temp=array[i];\n" +
                    "  while(p>=0 &&temp<array[p] ){\n" +
                    "   array[p+1]=array[p];\n" +
                    "   p--;\n" +
                    "   }\n" +
                    "  array[p+1]=temp;\n" +
                    "  }");

        }else{
            checkedTextView.setVisibility(View.VISIBLE);
            checkedTextView.setText("for(int i=0;i<array.length;i++){\n" +
                    " int s=i;\n" +
                    " for(int j=i+1;j<array.length;j++){\n" +
                    "  if(array[s]>array[j]){\n" +
                    "  s=j;\n" +
                    "  }\n" +
                    " }\n" +
                    " if(s!=i){\n" +
                    "  array[i]=array[s]+array[i];\n" +
                    "  array[s]=array[i]-array[s];\n" +
                    "  array[i]=array[i]-array[s];\n" +
                    "  }\n" +
                    " }");
        }

        return false;
    }
}
