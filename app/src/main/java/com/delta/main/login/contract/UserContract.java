package com.delta.main.login.contract;

import com.delta.main.login.model.UserModel;
import com.delta.main.util.BasePresenter;
import com.delta.main.util.BaseView;

/**
 * Created by Zhenyu.Liu on 2016/10/20.
 */

//1.契约内部有2个接口，分别继承了BaseView和BasePresenter，View和Presenter中实现的方法分别是UI操作，和数据业务逻辑操作，此时是不是看的异常的清晰。
//2.多了一个契约类，契约内部包含了2个接口，一个是Presenter一个是View，就相当于之前的写法中的接口IView和普通类Presenter，
// 只不过现在都将这两个类所需要的业务和UI层的接口直接放在一起展现出来，变得很清晰。在契约接口中的Presenter是一个接口


public interface UserContract {

    interface View extends BaseView<Presenter>{

        void showLoading();//展示加载框
        void dismissLoading();//取消加载框展示
        void showUserInfo(UserModel userModel);//将网络请求得到的用户信息回调
        String loadUserId();//假设接口请求需要一个userId

    }

    interface Presenter extends BasePresenter{

        void loadUser();

    }

}
