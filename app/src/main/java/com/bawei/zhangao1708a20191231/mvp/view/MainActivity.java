package com.bawei.zhangao1708a20191231.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bawei.zhangao1708a20191231.R;
import com.bawei.zhangao1708a20191231.adapter.MyAdapter;
import com.bawei.zhangao1708a20191231.bean.DateBean;
import com.bawei.zhangao1708a20191231.mvp.cinntract.ICpntract;
import com.bawei.zhangao1708a20191231.mvp.presenter.MyPresenter;

import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ICpntract.HomeView {

    private MyPresenter myPresenter;
    String url="http://blog.zhaoliang5156.cn/api/news/smsbak.json";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        myPresenter = new MyPresenter(this);
        String s = "";
        URLEncoder.encode( s );
        myPresenter.getDate( url );
        listView = findViewById( R.id.list_view );
    }

    @Override
    public void Sueecss(DateBean dateBean) {
        List <DateBean.SmsesBean> list = dateBean.getSmses();
        listView.setAdapter( new MyAdapter(list) );
    }

    @Override
    public void Error(Throwable throwable) {

    }
}
