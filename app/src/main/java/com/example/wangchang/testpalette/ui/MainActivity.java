package com.example.wangchang.testpalette.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.wangchang.testpalette.adapter.DemoAdapter;
import com.example.wangchang.testpalette.utils.ImageUtil;
import com.example.wangchang.testpalette.R;
import com.example.wangchang.testpalette.utils.MyUrl;
import com.example.wangchang.testpalette.utils.UtilBox;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter = new DemoAdapter());

        adapter.replaceAll(getData());
    }

    /*public ArrayList<String> getData() {
        ArrayList<String> list = new ArrayList<>();
        for (String url : ImageUtil.imageUrls) {
            list.add(url);
        }
        return list;
    }*/
    public ArrayList<String> getData(){
        ArrayList<String> strlist = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        //获取机子型号
        String model= android.os.Build.MODEL;
        if (model==null||model==""||model.length()==0){
            Toast.makeText(this,"不能获取该机型号",Toast.LENGTH_LONG).show();
            return strlist;
        }
        MyUrl.SetUrl();
        UtilBox.showDialog(this,"加载中,请稍后");
    }
}
