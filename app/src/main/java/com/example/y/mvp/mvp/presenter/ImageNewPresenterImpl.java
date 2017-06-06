package com.example.y.mvp.mvp.presenter;


import android.text.TextUtils;
import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.model.DataListener;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.ImageNewModelImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageNewPresenterImpl extends Base4ViewPresenterImpl<BaseView.ImageNewView>
        implements Presenter.ImageNewPresenter, DataListener.ImageNewData {

    private final BaseModel.ImageNewModel imageNewModel;


    public ImageNewPresenterImpl(BaseView.ImageNewView view) {
        super(view);
        this.imageNewModel = new ImageNewModelImpl();
    }


    @Override
    public void requestNetWork(String id, String rows) {

        if (TextUtils.isEmpty(id)) {
            mView.hideProgress();
            Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.image_new_id), Toast.LENGTH_LONG).show();
        } else {
            if (TextUtils.isEmpty(rows)) {
                rows = "20";
            }
            ActivityUtils.offKeyboard();
            mView.showProgress();
            imageNewModel.netWorkNew(Integer.valueOf(id), Integer.valueOf(rows), this);
        }
    }

    @Override
    public void onClick(ImageNewInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }

    @Override
    public void onSuccess(List<ImageNewInfo> imageNewInfo) {
        mView.setData(imageNewInfo);
        mView.hideProgress();
    }

    @Override
    public void onFail() {
        mView.hideProgress();
        mView.netWorkError();
    }
}
