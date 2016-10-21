package com.delta.main.login.source;

import com.delta.main.login.model.UserModel;

/**
 * Created by Zhenyu.Liu on 2016/10/21.
 */

public interface IUserModel {


    public void find(OnListener onListener);


    interface OnListener {

        void loginSuccess(UserModel user);

        void loginFailed();

    }

}
