package com.nearur.daa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuickSort extends AppCompatActivity {

    Button merge;
    TextView result;
    CheckedTextView checkedTextView;
    EditText editText;
    int[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_sort);

        editText=(EditText)findViewById(R.id.editTextquicklist);

        merge=(Button)findViewById(R.id.buttonquick);
        result=(TextView)findViewById(R.id.textViewquickresult);
        checkedTextView=(CheckedTextView)findViewById(R.id.checkedTextViewalgoquick);

        merge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().length()>0){
                    String[] strings=editText.getText().toString().trim().split(",");
                    array=new int[strings.length];
                    for(int i=0;i<array.length;i++){
                        array[i]=Integer.parseInt(strings[i].trim());
                    }
                    sort(0,array.length-1);

                    StringBuffer buffer=new StringBuffer();
                    for(int x:array){
                        buffer.append(x+",");
                    }
                    result.setVisibility(View.VISIBLE);
                    result.setText("Sorted List \n"+buffer.toString().substring(0,buffer.length()-1));
                }else{
                    Toast.makeText(QuickSort.this,"Please Enter Valid List",Toast.LENGTH_LONG).show();
                }
            }
        });


        merge.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                checkedTextView.setVisibility(View.VISIBLE);
                checkedTextView.setText("void sort(int start,int end) {\n" +
                        "        if(start<end) {\n" +
                        "\n" +
                        "            int q=partition(start, end);\n" +
                        "\n" +
                        "            partition(start, q);\n" +
                        "\n" +
                        "            partition(q+1, end);\n" +
                        "\n" +
                        "        }return;\n" +
                        "    }\n" +
                        "\n" +
                        "    int partition( int p, int r)\n" +
                        "    {\n" +
                        "        int i, pivot, temp;\n" +
                        "        pivot = array[r];\n" +
                        "        i = p;\n" +
                        "        for(int j=p;j<r;j++) {\n" +
                        "            if(array[j]<pivot) {\n" +
                        "                temp=array[i];\n" +
                        "                array[i]=array[j];\n" +
                        "                array[j]=temp;\n" +
                        "                i++;\n" +
                        "            }\n" +
                        "        }\n" +
                        "        temp=array[i];\n" +
                        "        array[i]=array[r];\n" +
                        "        array[r]=temp;\n" +
                        "        return i;\n" +
                        "    }\n");
                return false;
            }
        });
    }

    void sort(int start,int end) {
        if(start<end) {

            int q=partition(start, end);

            sort(start, q-1);

            sort(q+1, end);

        }return;
    }

    int partition( int p, int r)
    {
        int i, pivot, temp;
        pivot = array[r];
        i = p;
        for(int j=p;j<r;j++) {
            if(array[j]<pivot) {
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
            }
        }
        temp=array[i];
        array[i]=array[r];
        array[r]=temp;
        return i;
    }

}
