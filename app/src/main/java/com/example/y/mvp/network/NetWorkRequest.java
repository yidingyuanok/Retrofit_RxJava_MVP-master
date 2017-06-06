package com.example.y.mvp.network;

import android.support.annotation.Nullable;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.mvp.Bean.JokeTextBean;
import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.mvp.Bean.TabNameInfo;
import com.example.y.mvp.utils.L;
import com.example.y.mvp.utils.RxUtils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/5/6.
 */
public class NetWorkRequest {

    public static void getTabNames(Subscriber<BaseBean.TabNameBean> subscriber){

       Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl(Api.BASE_API_TNGOU)
                 .client(new OkHttpClient.Builder().addInterceptor(new Network.LogInterceptor()).build())
//                 .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                 .build();
        ApiService apiService = retrofit.create(ApiService.class);
        L.i("getTabNames apiService : " + apiService );
//        java.lang.IllegalArgumentException: Unable to create converter for class java.lang.String
//        for method ApiService.getTabNames2
        String tabNames2 = apiService.getTabNames2();
        L.i("apiService.getTabNames2() : "+  tabNames2);

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        })
        .map(new Func1<String, BaseBean.TabNameBean>() {
            @Override
            public BaseBean.TabNameBean call(String s) {
                return getTabNameBean(s);
            }
        })
         .subscribeOn(Schedulers.io())
//         .unsubscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(subscriber);


    }

    public static void tabNews(Subscriber<BaseBean.TabNewsBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getApiService().getTabNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    @Nullable
    private static BaseBean.TabNameBean getTabNameBean(String s) {
        L.i("TabNames json : " + s);
        Gson gson = new Gson();
        BaseBean.TabNameBean tabNameBean11 = gson.fromJson(s, BaseBean.TabNameBean.class);
        L.i("gson tabNameBean.getInfo().size() : " + tabNameBean11.getInfo().size());

        BaseBean<Object> baseBean = new BaseBean<>();
        BaseBean.TabNameBean tabNameBean =  baseBean.new TabNameBean();
        ArrayList<TabNameInfo> tabNameInfos = new ArrayList<>();

        try {

           JSONArray jsonArray =   new JSONObject(s).optJSONArray("tngou");

            for (int i = 0; i < jsonArray.length(); i++) {
                TabNameInfo tabNameInfo = new TabNameInfo();
                JSONObject  jsonObject = (JSONObject) jsonArray.get(i);
                int id = jsonObject.optInt("id");
                tabNameInfo.setId(id);
                tabNameInfo.setName(jsonObject.optString("name"));
                tabNameInfos.add(tabNameInfo);

            }
            tabNameBean.setInfo(tabNameInfos);
            return tabNameBean;
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static void newsDetail(int id, Subscriber<NewsDetailInfo> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getApiService().getNewsDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void newsList(int id, int page, Subscriber<BaseBean.NewsListBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getApiService().getNewsList(id, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }



    public static void imageDetail(int id, Subscriber<BaseBean.ImageDetailBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getApiService().getImageDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageList(int id, int page, Subscriber<BaseBean.ImageListBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getApiService().getImageList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageNew(int id, int rows, Subscriber<BaseBean.ImageNewBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getApiService().getImageNews(id, rows)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabName(Subscriber<BaseBean.TabNameBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getApiService().getTabName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /////////////////////////////////////////////////////////////

    public static void jokeTextList(int page, Subscriber<JokeTextBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getBaiDuApi().getJokeText(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void jokePicList(int page, Subscriber<JokePicBean> subscriber) {
        RxUtils.unsubscribe();
        RxUtils.subscription = Network.getBaiDuApi().getJokePic(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
