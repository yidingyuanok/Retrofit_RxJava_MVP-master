package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.ImageDetailInfo;
import com.example.y.mvp.mvp.Bean.ImageListInfo;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.mvp.Bean.JokeTextBean;
import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.mvp.Bean.TabNameInfo;
import com.example.y.mvp.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * 网络请求数据的接口回调
 */
public interface DataListener<T> {

    void onSuccess(List<T> datas);
    void onFail();


    interface ImageDetailData extends DataListener<ImageDetailInfo> {
    }

    interface ImageListData extends DataListener<ImageListInfo> {
    }

    interface ImageNewData extends DataListener<ImageNewInfo> {
    }

    interface NewsListData extends DataListener<NewsListInfo> {
    }

    interface NewsDetailData {
        void onSuccess(NewsDetailInfo datas);
        void onFail();
    }

    interface TabNewsData extends DataListener<TabNewsInfo> {
    }

    interface TabNameData extends DataListener<TabNameInfo> {
    }

    interface JokeTextList extends DataListener<JokeTextBean.JokeTextInfo> {
    }

    interface JokePicList extends DataListener<JokePicBean.JokePicInfo> {
    }
}
