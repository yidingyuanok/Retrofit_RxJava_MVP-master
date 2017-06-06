package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.utils.L;

/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsModelImpl implements BaseModel.TabNewsModel {


    @Override
    public void netWork(final DataListener.TabNewsData tabNewsData) {

        NetWorkRequest.tabNews(new MySubscriber<BaseBean.TabNewsBean>() {
            @Override
            public void onError(Throwable e) {
                tabNewsData.onFail();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.TabNewsBean tabNewsBean) {
                tabNewsData.onSuccess(tabNewsBean.getInfo());
            }
        });

        L.i("NetWorkRequest.getTabNames");

//        NetWorkRequest.getTabNames(new MySubscriber<BaseBean.TabNameBean>() {
//            @Override
//            public void onError(Throwable e) {
//                tabNewsData.onFail();
//            }
//
//            @SuppressWarnings("unchecked")
//            @Override
//            public void onNext(BaseBean.TabNameBean tabNameBean) {
//                tabNewsData.onSuccess(tabNameBean.getInfo());
//            }
//        });


    }
}
