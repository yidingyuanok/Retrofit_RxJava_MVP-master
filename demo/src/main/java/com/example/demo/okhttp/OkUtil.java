package com.example.demo.okhttp;

import com.example.demo.bean.TabNameBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by Turing on 2017/5/3.
 */

public class OkUtil {

    //    http://www.tngou.net/api/top/classify

    public static final String GET_TABNAME_URL = "http://www.tngou.net/api/top/classify";
    public static final String REGISTER_URL = "http://www.tngou.net/api/oauth2/reg";
    public static final String LOGIN_URL = "http://www.tngou.net/api/oauth2/login";


    public static void getTabNamesByOkhttp(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .build();

        Request request = new Request.Builder()
                .url(GET_TABNAME_URL)
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                L.e("getTabNamesByOkhttp error : "+e.toString());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                L.i("getTabNamesByOkhttp json : " + s);

                Gson gson = new Gson();
                TabNameBean tabNewsBean = gson.fromJson(s, TabNameBean.class);
                L.i("tabNewsBean.getTngou().size() : " + tabNewsBean.getTngou().size());


            }
        });


    }

    //    9359825	client id
//    4547c71e5151e664b01fc607e90af34d   client_secret

    /**
     * 登录或注册
     * @param url
     */
    public static void register(String url){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .build();


        FormBody formBody = new FormBody.Builder()
                .add("client_id", "9359825")
                .add("client_secret", "4547c71e5151e664b01fc607e90af34d")
                .add("email", "yidingyuanok@163.com")
                .add("account", "yidingyuanok@163.com")
                .add("name", "yidingyuanok@163.com")
                .add("password", "zjz123")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                L.e("register error : "+e.toString());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                L.i("register json : " + s);
//                {"msg":"邮箱地址已经注册过，请换一个，或者直接登录该邮件 ","status":false}

//                {"access_token":"ea2e0e2432903abddde0e39574fd9l41","id":9359,"refresh_token":"22a4b316d8e044926155aa2d4386l7397115f0d6c1d726ed7297a170","status":true}



            }
        });


    }


    public static class LogInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            L.i("request:" + request.toString());
            okhttp3.Response response = chain.proceed(chain.request());
            okhttp3.MediaType mediaType = response.body().contentType();
            L.i("mediaType : " +  mediaType);
            String content = response.body().string();
            L.printLongLog("response body:" + content);
            if (response.body() != null) {
                ResponseBody body = ResponseBody.create(mediaType, content);
                return response.newBuilder().body(body).build();
            } else {
                return response;
            }
        }
    }


   public static class LoggingInterceptor implements Interceptor {
        @Override public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            L.i(String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            L.i(String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }

}
