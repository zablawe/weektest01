package com.bawei.zhangao1708a20191231.mvp.cinntract;

import com.bawei.zhangao1708a20191231.bean.DateBean;

/**
 * author: 张奥
 * data: 2019-12-31
 * function:使用契约统一管理MVP接口
 */
public interface ICpntract {
        public interface HomeModel{
            void  getDate(String url,HomeModelCallback homeModelCallback);
            interface HomeModelCallback{
                void Sueecss(DateBean dateBean);
                void Error(Throwable throwable);
            }

        }

         /*）封装网络响应接口回调，在回调中封装响应成功和响应失败的方法*/
        public interface HomeView{
               void Sueecss(DateBean dateBean);
               void Error(Throwable throwable);
        }

        public interface HomePresenter{
            void  getDate(String url);
        }
}
