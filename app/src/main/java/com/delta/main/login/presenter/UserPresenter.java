package com.delta.main.login.presenter;

import android.os.Handler;

import com.delta.main.login.contract.UserContract;
import com.delta.main.login.source.IMUserModel;
import com.delta.main.login.source.IUserModel;
import com.delta.main.login.model.UserModel;

/**
 * Created by Zhenyu.Liu on 2016/10/20.
 */

//1：UserInfoPresenter 构造函数中传入UserInfoContract.View，并且调用view的setPresenter()方法；
//2：将所有的初始化操作都放在start()方法中（这里demo只有一个：网络请求获取用户信息），
// 这样只要进入界面的时候调用start()方法就可以执行一系列初始化的操作，这就相当于一种约定好的开发。


public class UserPresenter implements UserContract.Presenter {

    private UserContract.View userView;
    private IUserModel iusermodel;

    private Handler hander = new Handler();


    public UserPresenter(UserContract.View userView) {
        this.userView = userView;
        this.iusermodel = new IMUserModel();
        userView.setPresenter(this);
    }

    @Override
    public void loadUser() {

        String id = userView.loadUserId();
        userView.showLoading();

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //模拟接口返回的json，并转换为javaBean
                UserModel user = new UserModel("小宝", "1", "杭州");
                userView.showUserInfo(user);
                userView.dismissLoading();
            }
        }, 3000);*/

        iusermodel.find(new IUserModel.OnListener() {
            @Override
            public void loginSuccess(final UserModel user) {
                hander.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.showUserInfo(user);
                        userView.dismissLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {

                userView.dismissLoading();
            }
        });



    }

    @Override
    public void start() {
        //将所有的初始化操作都放在start()方法中（这里demo只有一个：网络请求获取用户信息
        loadUser();
    }
}
