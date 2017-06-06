package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.mvp.model.DataListener;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.NewsDetailModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailPresenterImpl extends Base4ViewPresenterImpl<BaseView.NewsDetailView>
        implements Presenter.NewsDetailPresenter, DataListener.NewsDetailData {

    private final BaseModel.NewsDetailModel newsDetailModel;

    public NewsDetailPresenterImpl(BaseView.NewsDetailView view) {
        super(view);
        newsDetailModel = new NewsDetailModelImpl();
    }

    @Override
    public void requestNetWork(int id) {
        mView.showProgress();
        newsDetailModel.netWorkNewsDetail(id, this);
    }

    @Override
    public void onSuccess(NewsDetailInfo datas) {
        mView.setData(datas);
        mView.hideProgress();
    }


    @Override
    public void onFail() {
        mView.hideProgress();
        mView.netWorkError();
    }
}
