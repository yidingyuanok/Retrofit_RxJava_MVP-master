package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.activity.NewsDetailActivity;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.mvp.model.DataListener;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.NewsListModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListPresenterImpl extends Base4ViewPresenterImpl<BaseView.NewsListView>
        implements Presenter.NewsListPresenter, DataListener.NewsListData {

    private final BaseModel.NewsListModel newsListModel;

    public NewsListPresenterImpl(BaseView.NewsListView view) {
        super(view);
        this.newsListModel = new NewsListModelImpl();
    }
    @Override
    public void requestNetWork(int id, int page, boolean isNull) {
        if (page == 1) {
            mView.showProgress();
        } else {
            if (!isNull) {
                mView.showFoot();
            }
        }
        newsListModel.netWorkNewList(id, page, this);
    }
    @Override
    public void onClick(NewsListInfo info) {
        NewsDetailActivity.startIntent(info.getId());
    }

    @Override
    public void onSuccess(List<NewsListInfo> tngou) {
        mView.setData(tngou);
        mView.hideFoot();
        mView.hideProgress();
    }
    @Override
    public void onFail() {
        mView.hideFoot();
        mView.hideProgress();
        mView.netWorkError();
    }

}
