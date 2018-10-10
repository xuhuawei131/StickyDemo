package com.xuhuawei.stickydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btn_listview=findViewById(R.id.btn_listview);
        btn_listview.setOnClickListener(clickListener);

        View btn_scrollview=findViewById(R.id.btn_scrollview);
        btn_scrollview.setOnClickListener(clickListener);

    }
    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.btn_listview){
                startActivity(new Intent(MainActivity.this,StickyListViewActivity.class));
            }else if (v.getId()==R.id.btn_scrollview){
                startActivity(new Intent(MainActivity.this,StickyScrollViewActivity.class));
            }
        }
    };
}
