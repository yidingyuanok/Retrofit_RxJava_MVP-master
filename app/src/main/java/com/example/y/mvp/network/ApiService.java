package com.example.y.mvp.network;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.mvp.Bean.NewsDetailInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * by y on 2016/5/17.
 */
public interface ApiService {


    @GET(Api.TAB_NEWS)
    Observable<BaseBean.TabNewsBean> getTabNews();


    @GET(Api.TAB_IMG)
    Observable<BaseBean.TabNameBean> getTabName();

    @GET(Api.TAB_NEWS)
//    Observable<String> getTabNames2();
    String getTabNames2();
//    Observable<BaseBean.TabNewsBean> getTabNames2();

    @GET(Api.NEWS_LIST)
    Observable<BaseBean.NewsListBean> getNewsList(@Query("id") int id, @Query("page") int page);


    @GET(Api.NEWS_SHOW)
    Observable<NewsDetailInfo> getNewsDetail(@Query("id") int id);


    @GET(Api.IMAGE_LIST)
    Observable<BaseBean.ImageListBean> getImageList(@Query("id") int id, @Query("page") int page);


    @GET(Api.IMAGE_NEW)
    Observable<BaseBean.ImageNewBean> getImageNews(@Query("id") int id, @Query("rows") int rows);


    @GET(Api.IMAGE_SHOW)
    Observable<BaseBean.ImageDetailBean> getImageDetail(@Query("id") int id);
    
    

}
