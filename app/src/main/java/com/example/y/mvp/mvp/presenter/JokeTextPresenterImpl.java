package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.JokeTextBean;
import com.example.y.mvp.mvp.model.DataListener;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.JokeTextModeImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by y on 2016/5/30.
 */
public class JokeTextPresenterImpl extends Base4ViewPresenterImpl<BaseView.JokeTextView>
        implements Presenter.JokeTextPresenter, DataListener.JokeTextList {

    private final BaseModel.JokeTextListModel jokeListModel;

    public JokeTextPresenterImpl(BaseView.JokeTextView view) {
        super(view);
        this.jokeListModel = new JokeTextModeImpl();
    }

    @Override
    public void requestNetWork(int page, boolean isNull) {
        if (page == 1) {
            mView.showProgress();
        } else {
            if (!isNull) {
                mView.showFoot();
            }
        }
        jokeListModel.netWorkJoke(page, this);
    }

    @Override
    public void onSuccess(List<JokeTextBean.JokeTextInfo> datas) {
        mView.setData(datas);
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
