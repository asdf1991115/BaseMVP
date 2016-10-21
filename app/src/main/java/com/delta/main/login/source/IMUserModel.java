package com.delta.main.login.source;

import com.delta.main.login.model.UserModel;

/**
 * Created by Zhenyu.Liu on 2016/10/21.
 */

public class IMUserModel implements IUserModel {

        @Override
        public void find(final OnListener onListener) {

            new Thread(){
                @Override
                public void run()
                {
                    try
                    {
                        Thread.sleep(2000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    UserModel user = new UserModel("小宝", "1", "杭州");
                    onListener.loginSuccess(user);

                }
            }.start();
    };
}
