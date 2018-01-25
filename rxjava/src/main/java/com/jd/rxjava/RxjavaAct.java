package com.jd.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class RxjavaAct extends Activity {

    public static final String TAG = "Msg";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
//        int minWidth = tv.getMinWidth();
//        Log.d(TAG, "onCreate() called with: minWidth = [" + minWidth + "]");

//        test1();
//        test2();
//        tv.post(new Runnable() {
//            @Override
//            public void run() {
//                int minWidth = tv.getMinWidth();
//                Log.d(TAG, "onCreate() called with: minWidth = [" + minWidth + "]");
//                Log.d(TAG, "onCreate() called with: minWidth = [" + tv.getMeasuredWidth() + "]");
//
//                tv.measure(0,0);
//                Log.d(TAG, "onCreate() called with: minWidth2 = [" + tv.getMeasuredWidth() + "]");
//
//            }
//        });


    }

    @Override
    protected void onResume() {
        super.onResume();

//        Log.d(TAG, "onResume() called");
//        Log.d(TAG, "onResume() called with: minWidth2 = [" + tv.getMeasuredWidth() + "]");
//        tv.measure(0, 0);
//        Log.d(TAG, "onResume() called with: minWidth2 = [" + tv.getMeasuredWidth() + "]");

    }

    private void test2() {
        Log.d(TAG, "test2() called");
        final Observable<String> firstCreateObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("1");
                e.onComplete();
            }
        });

        Observable<Integer> mapObservavle = firstCreateObservable.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s);
            }
        });
        mapObservavle
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe() called with: d = [" + d + "]");
                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.d(TAG, "onNext() called with: value = [" + value + "]");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError() called with: e = [" + e + "]");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete() called");
                    }
                });
    }


    private void test1() {




        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("1");
                e.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe() called with: d = [" + d + "]");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.d(TAG, "onNext() called with: value = [" + value + "]");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError() called with: e = [" + e + "]");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete() called");
                    }
                });
    }

    public void click1(View view) {

        Log.d(TAG, "click1() called with: tv.getMeasuredWidth() = [" + tv.getMeasuredWidth() + "]");
        Log.d(TAG, "click1() called with: tv.getWidth() = [" + tv.getWidth() + "]");
        tv.measure(0, 0);
        Log.d(TAG, "click1() called with: tv.getMeasuredWidth() = [" + tv.getMeasuredWidth() + "]");

    }
}
