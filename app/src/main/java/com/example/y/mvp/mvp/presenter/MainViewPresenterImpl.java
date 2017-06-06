package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.R;
import com.example.y.mvp.mvp.view.BaseView;

/**
 * by 12406 on 2016/5/1.
 */
public class MainViewPresenterImpl extends Base4ViewPresenterImpl<BaseView.MainView>
        implements Presenter.MainViewPresenter {


    public MainViewPresenterImpl(BaseView.MainView view) {
        super(view);
    }

    @Override
    public void switchId(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                mView.switchNews();
                break;
            case R.id.navigation_item_image_classification:
                mView.switchImageClassification();
                break;
            case R.id.navigation_item_new_image:
                mView.switchNewImage();
                break;
            case R.id.navigation_item_joke:
                mView.switchJoke();
                break;
            case R.id.navigation_about:
                mView.switchAbout();
                break;
        }
    }
}

