package com.xuhuawei.stickydemo;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * 粘性标题的listview
 *
 */
public class StickyListViewActivity extends Activity {
    private ListView listView;
    private View layout_bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_list_view);

        listView = findViewById(R.id.listView);
        layout_bar = findViewById(R.id.layout_bar);
        View header = LayoutInflater.from(this).inflate(R.layout.layout_sticky_list_header, null);
        listView.addHeaderView(header);
        View headerBar = LayoutInflater.from(this).inflate(R.layout.layout_sticky_list_bar, null);
        listView.addHeaderView(headerBar);

        String[] names = new String[100];
        for (int i = 0; i < 100; i++) {
            names[i] = "Item-" + i;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.adapter_listview_item, R.id.text_name, names);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(onScrollChangeListener);
    }

    private AbsListView.OnScrollListener onScrollChangeListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }
        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if (firstVisibleItem > 0) {
                layout_bar.setVisibility(View.VISIBLE);
            } else {
                layout_bar.setVisibility(View.GONE);
            }
        }
    };
}
