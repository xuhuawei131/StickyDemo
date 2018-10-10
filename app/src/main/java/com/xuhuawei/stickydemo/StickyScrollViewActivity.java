package com.xuhuawei.stickydemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.xuhuawei.stickydemo.view.ObservableScrollView;

public class StickyScrollViewActivity extends Activity {
    private ObservableScrollView scrollView;
    private LinearLayout layout_sticky_list_bar;
    private LinearLayout layout_sticky_list_fake_bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_scroll_view);
        scrollView=findViewById(R.id.scrollView);
        layout_sticky_list_bar=findViewById(R.id.layout_sticky_list_bar);
        layout_sticky_list_fake_bar=findViewById(R.id.layout_sticky_list_fake_bar);
        scrollView.setMyScrollViewListener(onScrollChangeListener);
    }

    private ObservableScrollView.ScrollViewListener onScrollChangeListener=new ObservableScrollView.ScrollViewListener(){
        @Override
        public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
            int topPosition=layout_sticky_list_bar.getTop();
            Log.v("xhw","topPosition:"+topPosition+" y:"+y+" oldy:"+oldy);
            if (topPosition>y){
                layout_sticky_list_fake_bar.setVisibility(View.GONE);
            }else{
                layout_sticky_list_fake_bar.setVisibility(View.VISIBLE);
            }
        }
    };
}
