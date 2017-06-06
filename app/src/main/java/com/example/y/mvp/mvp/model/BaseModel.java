package com.example.y.mvp.mvp.model;

/**
 * M
 */
public interface BaseModel<T> {


    void netWork(T model);

    interface TabNewsModel extends BaseModel<DataListener.TabNewsData> {
    }

    interface TabNameModel extends BaseModel<DataListener.TabNameData> {
    }

    interface NewsListModel {
        void netWorkNewList(int id, int page, DataListener.NewsListData newsListData);
    }

    interface NewsDetailModel {
        void netWorkNewsDetail(int id, DataListener.NewsDetailData newsDetailData);
    }

    interface ImageNewModel {
        void netWorkNew(int id, int rows, DataListener.ImageNewData imageNewData);
    }

    interface ImageListModel {
        void netWorkList(int id, int page, DataListener.ImageListData imageListData);
    }

    interface ImageDetailModel {
        void netWorkDetail(int id, DataListener.ImageDetailData imageDetailData);
    }

    interface JokeTextListModel {
        void netWorkJoke(int page, DataListener.JokeTextList jokeList);
    }

    interface JokePicListModel {
        void netWorkJoke(int page, DataListener.JokePicList jokeList);
    }

}
