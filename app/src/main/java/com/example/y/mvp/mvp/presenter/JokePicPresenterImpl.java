package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.mvp.model.DataListener;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.JokePicModeImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by y on 2016/5/30.
 */
public class JokePicPresenterImpl extends Base4ViewPresenterImpl<BaseView.JokePicView>
        implements Presenter.JokePicPresenter, DataListener.JokePicList {

    private final BaseModel.JokePicListModel jokePicListModel;


    public JokePicPresenterImpl(BaseView.JokePicView view) {
        super(view);
        jokePicListModel = new JokePicModeImpl();
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
        jokePicListModel.netWorkJoke(page, this);
    }

    @Override
    public void onSuccess(List<JokePicBean.JokePicInfo> datas) {
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
