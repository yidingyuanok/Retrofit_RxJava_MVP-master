package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by y on 2016/4/28.
 */
public class ImageListModelImpl implements BaseModel.ImageListModel {

    @Override
    public void netWorkList(int id, final int page, final DataListener.ImageListData imageListData) {

        NetWorkRequest.imageList(id, page, new MySubscriber<BaseBean.ImageListBean>() {
            @Override
            public void onError(Throwable e) {
                imageListData.onFail();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.ImageListBean imageListBean) {
                imageListData.onSuccess(imageListBean.getInfo());
            }
        });
    }


}
