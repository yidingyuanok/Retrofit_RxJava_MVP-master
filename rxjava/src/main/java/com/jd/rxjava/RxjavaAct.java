package com.jd.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;


public class RxjavaAct extends Activity {

    public static final String TAG ="RxjavaAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = findViewById(R.id.tv);
        int minWidth = tv.getMinWidth();
        Log.d(TAG, "onCreate() called with: minWidth = [" + minWidth + "]");

//        test1();
//        test2();
        tv.post(new Runnable() {
            @Override
            public void run() {
                int minWidth = tv.getMinWidth();
                Log.d(TAG, "onCreate() called with: minWidth = [" + minWidth + "]");
                Log.d(TAG, "onCreate() called with: minWidth = [" + tv.getMeasuredWidth() + "]");


            }
        });


    }

    private void test2() {
        Log.d(TAG, "test2() called");
        final Observable<String> testCreateObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("1");
                e.onComplete();
            }
        });

        Observable<Integer> map = testCreateObservable.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s);
            }
        });

        map.subscribe(new Observer<Integer>() {
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
        }).subscribe(new Observer<String>() {
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
}
