package com.retrofit.recyitemtouchhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.LinearLayout;

import com.retrofit.recyitemtouchhelper.adapter.MoveAdapter;
import com.retrofit.recyitemtouchhelper.callback.IHCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected RecyclerView mRecyclerView;
    private MoveAdapter moveAdapter;
    private ItemTouchHelper.Callback ihCallback;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        moveAdapter = new MoveAdapter(this);
        ihCallback = new IHCallback(moveAdapter);
        moveAdapter.setData(getData());
        mRecyclerView.setAdapter(moveAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        itemTouchHelper = new ItemTouchHelper(ihCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    private List<String> getData() {
        List<String> dataList = new ArrayList<>();
        dataList.add("西安");
        dataList.add("榆林");
        dataList.add("渭南");
        dataList.add("延安");
        dataList.add("铜川");
        dataList.add("宝鸡");
        dataList.add("汉中");
        dataList.add("安康");
        dataList.add("商洛");
        return dataList;
    }
}
