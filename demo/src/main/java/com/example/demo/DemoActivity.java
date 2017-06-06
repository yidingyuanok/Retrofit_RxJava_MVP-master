package com.example.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.demo.bean.User;
import com.example.demo.okhttp.L;
import com.example.demo.okhttp.OkUtil;
import com.example.demo.retrofit.RetrofitUtil;
import com.example.demo.rxjava.RxjavaUtil;

import rx.Subscriber;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv1).setOnClickListener(this);
        findViewById(R.id.tv2).setOnClickListener(this);
        findViewById(R.id.tv3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
//                OkUtil.getTabNamesByOkhttp();
//                OkUtil.register(OkUtil.REGISTER_URL);
                OkUtil.register(OkUtil.LOGIN_URL);
                break;
            case R.id.tv2:
//                RetrofitUtil.getTabNewsByRetrofit();
//                RetrofitUtil.login();
                RetrofitUtil.login2();
//                RetrofitUtil.getUserInfo();

                break;

            case R.id.tv3:

//                RxjavaUtil.getTabNamesByRxjava(new Subscriber<TabNameBean>() {
//                    @Override
//                    public void onCompleted() {
//                        L.i("DemoActivity.onCompleted");
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        L.i("DemoActivity.onError : " + e.toString());
//                    }
//                    @Override
//                    public void onNext(TabNameBean tabNewsBean) {
//                        L.i("onNext , tabNewsBean.getTngou().size() : " + tabNewsBean.getTngou().size());
//                    }
//                });

//                RxjavaUtil.getTabNamesByRxjava2(new Subscriber<TabNameBean.TngouBean>() {
//                    @Override
//                    public void onCompleted() {
//                        L.i("DemoActivity.onCompleted");
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        L.i("DemoActivity.onError : " + e.toString());
//                    }
//                    @Override
//                    public void onNext(TabNameBean.TngouBean tngouBean) {
//                        L.i("onNext , tngouBean.getName() : " + tngouBean.getName());
//                        Toast.makeText(DemoActivity.this,tngouBean.getName(),Toast.LENGTH_SHORT).show();
//                    }
//                });

                RxjavaUtil.getUserInfo(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {
                        L.i("getUserInfo onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                        L.e("getUserInfo error : " + e.toString());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(User user) {

                        L.i("getUserInfo : " + user.toString());
                        Toast.makeText(DemoActivity.this, user.getEmail() ,Toast.LENGTH_SHORT).show();
                    }
                });

                break;

        }
    }
}
