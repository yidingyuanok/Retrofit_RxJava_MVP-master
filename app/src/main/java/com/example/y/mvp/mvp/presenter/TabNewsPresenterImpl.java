package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.TabNewsInfo;
import com.example.y.mvp.mvp.model.DataListener;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.TabNewsModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsPresenterImpl extends Base4ViewPresenterImpl<BaseView.TabNewsView>
        implements Presenter.TabNewsPresenter, DataListener.TabNewsData {

    private final BaseModel.TabNewsModel tabNewsModel;

    public TabNewsPresenterImpl(BaseView.TabNewsView view) {
        super(view);
        this.tabNewsModel = new TabNewsModelImpl();
    }
    @Override
    public void requestNetWork() {
        tabNewsModel.netWork(this);
    }

    @Override
    public void onSuccess(List<TabNewsInfo> newsInfo) {
        mView.setData(newsInfo);
    }
    @Override
    public void onFail() {
        mView.netWorkError();
    }
}
