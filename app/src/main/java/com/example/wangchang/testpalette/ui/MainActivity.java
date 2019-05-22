package com.example.wangchang.testpalette.ui;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.wangchang.testpalette.adapter.DemoAdapter;
import com.example.wangchang.testpalette.bean.Pblresources;
import com.example.wangchang.testpalette.bean.RootBean;
import com.example.wangchang.testpalette.R;
import com.example.wangchang.testpalette.utils.MyUrl;
import com.example.wangchang.testpalette.utils.UtilBox;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DemoAdapter adapter;
    ArrayList<Pblresources> list;

    private Handler handler1= new Handler(Looper.getMainLooper());//初始化handler

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
    public ArrayList<Pblresources> getData(){
        ArrayList<Pblresources> strlist = new ArrayList<>();
        //获取机子型号
        String model= android.os.Build.MODEL;
        if (model==null||model==""||model.length()==0){
            Toast.makeText(this,"不能获取该机型号",Toast.LENGTH_LONG).show();
            return strlist;
        }
        MyUrl.SetUrl();
        UtilBox.showDialog(this,"加载中,请稍后");
        OkHttpClient client = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("model",model)
                .build();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(MyUrl.getShowSourceList)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler1.post(new Runnable(){
                    @Override
                    public void run(){
                        UtilBox.dismissDialog();
                        Toast.makeText(MainActivity.this,"网络连接失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = "";
                try{
                    res = response.body().string();
                }catch (Exception ex){
                    return;
                }
                UtilBox.dismissDialog();
                final RootBean bean = new Gson().fromJson(res,RootBean.class);
                if(bean.getCode()==200){
                    for (int i = 0;i < bean.getData().getResource_list().size();i++){
                        Pblresources resources = new Pblresources();//存放取到的资源对象
                        resources.setCoverImg(bean.getData().getResource_list().get(i).getCoverImg());
                        resources.setClassifyname(bean.getData().getResource_list().get(i).getClassifyname());
                        resources.setCompany(bean.getData().getResource_list().get(i).getCompany());
                        resources.setName(bean.getData().getResource_list().get(i).getName());
                        resources.setNickName(bean.getData().getResource_list().get(i).getNickName());
                        resources.setSize(bean.getData().getResource_list().get(i).getSize());
                        resources.setRtype(bean.getData().getResource_list().get(i).getRtype());
                        resources.setCreatetime(bean.getData().getResource_list().get(i).getCreatetime());
                        list.add(resources);
                    }
                }
            }
        });
        return list;
    }
}
