package com.example.y.mvp.mvp.presenter;

/**
 * by y on 2016/5/27.
 */
@SuppressWarnings("ALL")
public class Base4ViewPresenterImpl<T> {

    T mView;

    public Base4ViewPresenterImpl(T view) {
        this.mView = view;
    }

}
