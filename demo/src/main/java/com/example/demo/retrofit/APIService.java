package com.example.demo.retrofit;

import com.example.demo.bean.TabNameBean;
import com.example.demo.bean.Token;
import com.example.demo.bean.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Turing on 2017/5/3.
 */

public interface APIService {

    //    http://www.tngou.net/api/top/classify



//    http://www.tngou.net/api/user?access_token=a4fe0465b9464ae8fbl54da04bfd6e2f   eg.  返回用户信息

    public static final String BASE_URL = "http://www.tngou.net/";
    public static final String TAB_NAMES_URL = "api/top/classify";
    public static final String LOGIN_URL = "api/oauth2/login";

    @GET (TAB_NAMES_URL)
//    Call<String> getTabNames();
        //        java.lang.IllegalArgumentException: Unable to create converter for class java.lang.String for method ApiService.getTabNames2
    Call<TabNameBean> getTabNames();


    @GET (TAB_NAMES_URL)
    Observable<TabNameBean> getTabNamesByRxjava();

//    client_id	    是	string	OAuth2客户ID
//    client_secret	是	string	安全密文
//    name	        是	string	邮件/账号 也就是email与account的一个
//    password	    是	string	密码
    @FormUrlEncoded
    @POST(LOGIN_URL)
    Call<Token> login(@Field("client_id")String clientID,
                      @Field("client_secret")String client_secret ,
                      @Field("name")String name,
                      @Field("password") String password);

//    http://www.tngou.net/api/user?access_token=${access_token}
//    ea2e0e2432903abddde0e39574fd9l41
//    http://www.tngou.net/api/user?access_token=ea2e0e2432903abddde0e39574fd9l41

    @GET("api/user")
    Call<User> getUserInfo(@Query("access_token")String token);


    @FormUrlEncoded
    @POST(LOGIN_URL)
    Call<Token> loginByFiledMap(@FieldMap Map<String,String> map);

    /**
     * 登录获token,再通过token得到用户信息
     * @param map
     * @return
     */

    @FormUrlEncoded
    @POST(LOGIN_URL)
    Observable<Token> loginByRxjava(@FieldMap Map<String,String> map);

    @GET("api/user")
    Observable<User> getUserInfoByRxjava(@Query("access_token")String token);

}
