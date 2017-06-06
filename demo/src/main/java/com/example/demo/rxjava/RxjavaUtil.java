package com.example.demo.rxjava;

import com.example.demo.bean.TabNameBean;
import com.example.demo.bean.Token;
import com.example.demo.bean.User;
import com.example.demo.okhttp.OkUtil;
import com.example.demo.retrofit.APIService;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Turing on 2017/5/3.
 */

public class RxjavaUtil {

    public static void getTabNamesByRxjava(Subscriber<TabNameBean> subscriber) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .client(new OkHttpClient().newBuilder().addInterceptor(new OkUtil.LoggingInterceptor()).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        Observable<TabNameBean> observable = apiService.getTabNamesByRxjava();
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    public static void getTabNamesByRxjava2(Subscriber<TabNameBean.TngouBean> subscriber) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .client(new OkHttpClient().newBuilder().addInterceptor(new OkUtil.LoggingInterceptor()).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        final Observable<TabNameBean> observable = apiService.getTabNamesByRxjava();
        observable
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<TabNameBean, Observable<TabNameBean.TngouBean>>() {
                    @Override
                    public Observable<TabNameBean.TngouBean> call(TabNameBean tabNewsBean) {
                        return Observable.from(tabNewsBean.getTngou());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }


    public static void getUserInfo(Subscriber<User> subscriber) {

        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient().newBuilder().addInterceptor(new OkUtil.LogInterceptor()).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(APIService.BASE_URL)
                .build();
        final APIService apiService = retrofit.create(APIService.class);

        HashMap<String, String> filedMap = new HashMap<>();
        filedMap.put("client_id", "9359825");
        filedMap.put("client_secret", "4547c71e5151e664b01fc607e90af34d");
        filedMap.put("name", "yidingyuanok@163.com");
        filedMap.put("password", "zjz123");

        Observable<Token> tokenObservable = apiService.loginByRxjava(filedMap);

//        tokenObservable
//                .flatMap(new Func1<Token, Observable<User>>() {
//                    @Override
//                    public Observable<User> call(Token token) {
//                        return apiService.getUserInfoByRxjava(token.getAccess_token());
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);

        tokenObservable
                .map(new Func1<Token, String>() {
                    @Override
                    public String call(Token token) {
                        return token.getAccess_token();
                    }
                })
                .flatMap(new Func1<String, Observable<User>>() {
                    @Override
                    public Observable<User> call(String s) {
                        return apiService.getUserInfoByRxjava(s);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);


    }


}
