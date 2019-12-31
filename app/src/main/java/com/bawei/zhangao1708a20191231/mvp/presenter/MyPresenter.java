package com.bawei.zhangao1708a20191231.mvp.presenter;

import com.bawei.zhangao1708a20191231.bean.DateBean;
import com.bawei.zhangao1708a20191231.mvp.cinntract.ICpntract;
import com.bawei.zhangao1708a20191231.mvp.model.MyModel;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public class MyPresenter implements ICpntract.HomePresenter {
    private ICpntract.HomeView homeView;
    private final MyModel myModel;

    public MyPresenter(ICpntract.HomeView homeView) {
        this.homeView = homeView;
        myModel = new MyModel();
    }

    @Override
    public void getDate(String url) {
    myModel.getDate( url, new ICpntract.HomeModel.HomeModelCallback() {
        @Override
        public void Sueecss(DateBean dateBean) {
            homeView.Sueecss( dateBean );
        }

        @Override
        public void Error(Throwable throwable) {
       homeView.Error( throwable );
        }
    } );
    }
}
