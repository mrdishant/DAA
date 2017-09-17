package com.nearur.daa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MergeSort extends AppCompatActivity {

    Button merge;
    TextView result;
    CheckedTextView checkedTextView;
    EditText editText;
    int[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_sort);

        editText=(EditText)findViewById(R.id.editTextmergelist);

        merge=(Button)findViewById(R.id.buttonmerge);
        result=(TextView)findViewById(R.id.textViewmergeresult);
        checkedTextView=(CheckedTextView)findViewById(R.id.checkedTextViewalgo);

        merge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().length()>0){
                    String[] strings=editText.getText().toString().trim().split(",");
                    array=new int[strings.length];
                    for(int i=0;i<array.length;i++){
                        array[i]=Integer.parseInt(strings[i].trim());
                    }
                    mergesort(0,array.length-1);

                    StringBuffer buffer=new StringBuffer();
                    for(int x:array){
                        buffer.append(x+",");
                    }
                    result.setVisibility(View.VISIBLE);
                    result.setText("Sorted List \n"+buffer.toString().substring(0,buffer.length()-1));
                }else{
                    Toast.makeText(MergeSort.this,"Enter Valid List",Toast.LENGTH_LONG).show();
                }
            }
        });
        merge.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                checkedTextView.setVisibility(View.VISIBLE);
                checkedTextView.setText("void mergesort(int s,int f){\n" +
                        "        if(s<f) {\n" +
                        "            int mid = (f+s)/ 2;\n" +
                        "            mergesort(s, mid);\n" +
                        "            mergesort(mid + 1, f);\n" +
                        "            merge(s, mid, f);\n" +
                        "        }return;\n" +
                        "    }\n" +
                        "\n" +
                        "    void merge( int start,int mid,int finish) {\n" +
                        "\n" +
                        "        int s1=mid-start+1;\n" +
                        "        int s2=finish-mid;\n" +
                        "\n" +
                        "        int[] ls=new int[s1];\n" +
                        "        int[] rs=new int[s2];\n" +
                        "\n" +
                        "        for(int i=0;i<s1;i++){\n" +
                        "            ls[i]=array[start+i];\n" +
                        "        }for(int i=0;i<s2;i++){\n" +
                        "            rs[i]=array[mid+1+i];\n" +
                        "        }\n" +
                        "        int i=0,j=0,n=start;\n" +
                        "        while(i<s1 && j<s2){\n" +
                        "            if(ls[i]<=rs[j]){\n" +
                        "                array[n]=ls[i];\n" +
                        "                i++;\n" +
                        "            }else{\n" +
                        "                array[n]=rs[j];\n" +
                        "                j++;\n" +
                        "            }\n" +
                        "            n++;\n" +
                        "        }\n" +
                        "        while(i<s1){\n" +
                        "            array[n]=ls[i];\n" +
                        "            i++;\n" +
                        "            n++;\n" +
                        "        }\n" +
                        "        while(j<s2){\n" +
                        "            array[n]=rs[j];\n" +
                        "            j++;\n" +
                        "            n++;\n" +
                        "        }\n" +
                        "\n" +
                        "    }");
                return false;
            }
        });
    }

    void mergesort(int s,int f){
        if(s<f) {
            int mid = (f+s)/ 2;
            mergesort(s, mid);
            mergesort(mid + 1, f);
            merge(s, mid, f);
        }return;
    }

    void merge( int start,int mid,int finish) {

        int s1=mid-start+1;
        int s2=finish-mid;

        int[] ls=new int[s1];
        int[] rs=new int[s2];

        for(int i=0;i<s1;i++){
            ls[i]=array[start+i];
        }for(int i=0;i<s2;i++){
            rs[i]=array[mid+1+i];
        }
        int i=0,j=0,n=start;
        while(i<s1 && j<s2){
            if(ls[i]<=rs[j]){
                array[n]=ls[i];
                i++;
            }else{
                array[n]=rs[j];
                j++;
            }
            n++;
        }
        while(i<s1){
            array[n]=ls[i];
            i++;
            n++;
        }
        while(j<s2){
            array[n]=rs[j];
            j++;
            n++;
        }

    }
}
