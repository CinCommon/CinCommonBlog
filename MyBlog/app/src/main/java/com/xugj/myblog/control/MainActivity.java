package com.xugj.myblog.control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.xugj.myblog.R;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final Logger logger = LoggerFactory.getLogger(MainActivity.class);

    private Spinner typeSpinner = null;
    private Spinner dateSpinner = null;
    private TextView textView = null;
    private List<String> typeList = null;
    private List<String> dateList = null;
    ArrayAdapter typeAdapter = null;
    ArrayAdapter dateAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger.debug("debug()方法，看下这里logger的实例是：{}"+logger.getClass());
        logger.info("info()方法，看下这里logger的实例是：{}"+logger.getClass());
        logger.error("error()方法，看下这里logger的实例是：{}"+logger.getClass());


        typeSpinner = (Spinner)findViewById(R.id.type);
        dateSpinner = (Spinner)findViewById(R.id.date);
        textView = (TextView)findViewById(R.id.textView) ;
        //准备数据
        initDates();
        typeAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,typeList);
        typeSpinner.setAdapter(typeAdapter);
        dateAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,dateList);
        dateSpinner.setAdapter(dateAdapter);
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String msg = parent.getItemAtPosition(position).toString();


            };
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
    public void go2Tab(View view){
        Intent intent = new Intent(this,TabActivity.class);
        this.startActivity(intent);

    }

    private void initDates(){
        //TODO
        typeList =new ArrayList<String>();
        typeList.add("原创");
        typeList.add("转载");
        dateList =new ArrayList<String>();
        dateList.add("20180306");
    }



}
