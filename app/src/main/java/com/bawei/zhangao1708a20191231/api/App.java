package com.bawei.zhangao1708a20191231.api;

import android.app.Application;
import android.content.Context;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
