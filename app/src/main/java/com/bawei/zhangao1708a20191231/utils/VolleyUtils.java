package com.bawei.zhangao1708a20191231.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.zhangao1708a20191231.api.App;

/**
 * author: 张奥
 * data: 2019-12-31
 * function:封装网络工具类
 */
public class VolleyUtils {

//     使用单例模式封装网络工具类
    
    private static VolleyUtils volleyUtils;
    private final RequestQueue requestQueue;

    private VolleyUtils(){
        requestQueue = Volley.newRequestQueue( App.getContext() );

    }

    public static VolleyUtils getInstance() {
        if (volleyUtils == null) {
            synchronized (VolleyUtils.class){
                if (volleyUtils == null) {
                     volleyUtils = new VolleyUtils();
                }
            }
        }
        return volleyUtils;
    }

    public interface VolleyCallback{
        void getSuccess(String date);
        void getError(Throwable throwable);
    }

    public void doGet(String url, final VolleyCallback volleyCallback){
        StringRequest stringRequest = new StringRequest( url, new Response.Listener <String>() {
            @Override
            public void onResponse(String response) {
               volleyCallback.getSuccess( response );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             volleyCallback.getError( error );
            }
        } );
        requestQueue.add( stringRequest );
    }
         /*心）封装网络判断的方法，判断有网，无网*/

    public boolean hasNet(Context context){
      ConnectivityManager manager = (ConnectivityManager) context.getSystemService( Context.CONNECTIVITY_SERVICE );
        @SuppressLint("MissingPermission")
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo != null&&activeNetworkInfo.isAvailable()) {
          return true;
        }else{
            return false;
        }
    }

}
