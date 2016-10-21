package com.delta.main.util;

/**
 * Created by Zhenyu.Liu on 2016/10/19.
 */

public interface BasePresenter {

    //1.只有一个start方法。将在view界面初始化后调用（onResume方法中）
    //2.这里的start()方法就相当于约定了所有的Presenter的初始化操作都放在start()方法中；
    void start ();

}
