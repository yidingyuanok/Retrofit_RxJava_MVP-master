package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.view.BaseView;

/**
 * by y on 2016/6/12.
 */
public class ToolBarItemPresenterImpl extends Base4ViewPresenterImpl<BaseView.ToolBarItemView>
        implements Presenter.ToolBarItemPresenter {

    public ToolBarItemPresenterImpl(BaseView.ToolBarItemView view) {
        super(view);
    }


    @Override
    public void switchId(int id) {
        switch (id) {
            case R.id.toolbar_item_share:
                mView.switchShare();
                break;
        }
    }
}
