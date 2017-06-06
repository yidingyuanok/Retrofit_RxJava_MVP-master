package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailModelImpl implements BaseModel.ImageDetailModel {


    @Override
    public void netWorkDetail(int id, final DataListener.ImageDetailData imageDetailData) {

        NetWorkRequest.imageDetail(id, new MySubscriber<BaseBean.ImageDetailBean>() {

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                imageDetailData.onFail();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.ImageDetailBean imageDetailBean) {
                super.onNext(imageDetailBean);
                imageDetailData.onSuccess(imageDetailBean.getList());
            }
        });
    }


}
