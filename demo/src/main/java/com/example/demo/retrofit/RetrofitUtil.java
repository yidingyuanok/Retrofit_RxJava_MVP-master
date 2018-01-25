package com.example.demo.retrofit;

import com.example.demo.bean.TabNameBean;
import com.example.demo.bean.Token;
import com.example.demo.bean.User;
import com.example.demo.okhttp.L;
import com.example.demo.okhttp.OkUtil;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Turing on 2017/5/3.
 */

public class RetrofitUtil {



    public static void getTabNewsByRetrofit() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        Request request = new Request.Builder().url(APIService.TAB_NAMES_URL).build();
        APIService apiService = retrofit.create(APIService.class);
        Call<TabNameBean> tabNames = apiService.getTabNames();
        tabNames.enqueue(new Callback<TabNameBean>() {
            @Override
            public void onResponse(Call<TabNameBean> call, Response<TabNameBean> response) {
                String s = response.body().toString();
                TabNameBean tabNewsBean = response.body();
                tabNewsBean.getTngou().size();
                L.i("getTabNewsByRetrofit tabNewsBean.getTngou().size() : " + tabNewsBean.getTngou().size());

            }

            @Override
            public void onFailure(Call<TabNameBean> call, Throwable t) {

                L.e("getTabNewsByRetrofit error : "  + t.toString());
            }
        });

        Response<TabNameBean> reponse = tabNames.execute();

    }


//              .add("client_id", "9359825")
//                .add("client_secret", "4547c71e5151e664b01fc607e90af34d")
//                .add("email", "yidingyuanok@163.com")
//                .add("account", "yidingyuanok@163.com")
//                .add("name", "yidingyuanok@163.com")
//                .add("password", "zjz123")

    public static void login(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        Request request = new Request.Builder().url(APIService.TAB_NAMES_URL).build();
        APIService apiService = retrofit.create(APIService.class);
        Call<Token> tokenCall = apiService.login("9359825","4547c71e5151e664b01fc607e90af34d", "yidingyuanok@163.com","zjz123");

        tokenCall.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Token token = response.body();
                L.i("login json : " + token.toString());
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {

                L.e("login error : " + t.toString());
            }
        });


    }

    public static void login2(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        Request request = new Request.Builder().url(APIService.TAB_NAMES_URL).build();
        APIService apiService = retrofit.create(APIService.class);

        HashMap<String, String> filedMap = new HashMap<>();
        filedMap.put("client_id","9359825");
        filedMap.put("client_secret","4547c71e5151e664b01fc607e90af34d");
        filedMap.put("name","yidingyuanok@163.com");
        filedMap.put("password","zjz123");

        Call<Token> tokenCall = apiService.loginByFiledMap(filedMap);

        tokenCall.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Token token = response.body();
                L.i("login json : " + token.toString());
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {

                L.e("login error : " + t.toString());
            }
        });


    }


    public static void getUserInfo(){

        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient().newBuilder().addInterceptor(new OkUtil.LogInterceptor()).build())
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        Request request = new Request.Builder().url(APIService.TAB_NAMES_URL).build();
        APIService apiService = retrofit.create(APIService.class);
        Call<User> userCall = apiService.getUserInfo("ea2e0e2432903abddde0e39574fd9l41");

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                L.i("lgetUserInfo : " + response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                L.e("lgetUserInfo error : " + t.toString());
            }
        });



    }
}
