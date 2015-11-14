package com.example.ironman.point;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class point extends Activity {
    public String[] data={"品学楼A101","品学楼A102","品学楼A103","品学楼A104",
            "品学楼B101","品学楼B102","品学楼B103","品学楼B104",
            "品学楼C101","品学楼C102","品学楼C103","品学楼C104",
            "立人楼A101","立人楼A102","立人楼A103","立人楼A104",
            "立人楼B101","立人楼B102","立人楼B103","立人楼B104",
            "立人楼C101","立人楼C102","立人楼C103","立人楼C104"};
    public String newdata[]={"品学楼A101","品学楼A102","品学楼A103","品学楼A104",
            "品学楼B101","品学楼B102","品学楼B103","品学楼B104",
            "品学楼C101","品学楼C102","品学楼C103","品学楼C104",
            "立人楼A101","立人楼A102","立人楼A103","立人楼A104",
            "立人楼B101","立人楼B102","立人楼B103","立人楼B104",
            "立人楼C101","立人楼C102","立人楼C103","立人楼C104"};
    public String[] choose1={"请选择楼","品学楼","立人楼"},choose2={"请选择栋","A","B","C"};
    public int i=0,j=0;
    private Spinner spinner,spinner2;
    public ArrayAdapter<String>adapter,adapter1,adapter2;
    String sspinner;
    String sspinner2;
    Button buttontest;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        buttontest = (Button) findViewById(R.id.button);
        System.arraycopy(data, 0, newdata, 0, 4);
        adapter=new ArrayAdapter<String>(point.this,android.R.layout.simple_list_item_1,newdata);
        final ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        buttontest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                i=0;
                j=0;
                for(i=0;i<=23;i++){
                    int result=data[i].indexOf(sspinner);
                    int result1=data[i].indexOf(sspinner2);
                    if(result>=0&&result1>=0){
                        newdata[j]=data[i];
                        j+=1;
                    }
                }
                for(int m=j;m<=23;m++)
                {
                    newdata[m]="";
                }
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

        });
        listView.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?>parent,View view,int position,long id){
                String text=listView.getItemAtPosition(position)+"";
                if(text!=""){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(point.this);
                    dialog.setTitle("确认对话框");
                    dialog.setMessage("是否占用"+text+"教室？");
                    dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(point.this,and.class);
                            startActivity(intent);
                        }
                    });
                    dialog.setNegativeButton("取消", null);
                    AlertDialog show = dialog.create();//获取show
                    show.show();//显示对话框
                }
            }

        });

        spinner=(Spinner)findViewById(R.id.spinner);
        spinner2=(Spinner)findViewById(R.id.spinner2);

        adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,choose1);//设置数组适配器
        adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,choose2);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //下拉列表样式
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter1);//加载适配器
        spinner2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                sspinner = choose1[arg2];
                arg0.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        spinner2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                sspinner2 = choose2[arg2];
                arg0.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }
}
