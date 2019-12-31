package com.bawei.zhangao1708a20191231.mvp.model;

import android.util.Log;

import com.bawei.zhangao1708a20191231.bean.DateBean;
import com.bawei.zhangao1708a20191231.mvp.cinntract.ICpntract;
import com.bawei.zhangao1708a20191231.utils.VolleyUtils;
import com.google.gson.Gson;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public class MyModel  implements ICpntract.HomeModel {
    @Override
    public void getDate(String url, final HomeModelCallback homeModelCallback) {
        VolleyUtils.getInstance().doGet( url, new VolleyUtils.VolleyCallback() {
            @Override
            public void getSuccess(String date) {
                /*使用Log输出请求成功后的数据*/
                DateBean dateBean = new Gson().fromJson( date, DateBean.class );
                Log.i( "tag", "getSuccess: " +dateBean);
                homeModelCallback.Sueecss( dateBean );
            }

            @Override
            public void getError(Throwable throwable) {
               homeModelCallback.Error( throwable );
            }
        } );
    }
}
