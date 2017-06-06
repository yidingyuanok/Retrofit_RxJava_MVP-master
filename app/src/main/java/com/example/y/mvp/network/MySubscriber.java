package com.example.y.mvp.network;

import com.example.y.mvp.utils.L;

import rx.Subscriber;

/**
 * by y on 2016/5/6.
 */
public class MySubscriber<T> extends Subscriber<T> {

    

    @Override
    public void onStart() {
        super.onStart();
        L.i("MySubscriber", "onStart被调用了");
    }

    @Override
    public void onCompleted() {
        L.i("MySubscriber", "onCompleted被调用了");
    }

    @Override
    public void onError(Throwable e) {
        L.i("Throwable", e.getMessage());
        L.i("MySubscriber", "onError被调用了");
    }

    @Override
    public void onNext(T t) {
        L.i("MySubscriber", "onNext被调用了");
    }
    
    
}
