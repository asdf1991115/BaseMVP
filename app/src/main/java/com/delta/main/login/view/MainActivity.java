package com.delta.main.login.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.delta.main.R;
import com.delta.main.login.contract.UserContract;
import com.delta.main.login.model.UserModel;
import com.delta.main.login.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity implements UserContract.View{

    private TextView u_name;
    private TextView u_age;
    private TextView u_address;

    private UserContract.Presenter u_presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        u_name = (TextView) findViewById(R.id.u_name);
        u_age = (TextView) findViewById(R.id.u_age);
        u_address = (TextView) findViewById(R.id.u_address);

        u_presenter = new UserPresenter(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        u_presenter.start();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "正在加载", Toast.LENGTH_LONG).show();
    }

    @Override
    public void dismissLoading() {
        Toast.makeText(this, "加载完成", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserInfo(UserModel userModel) {
        if(userModel!=null){
            u_name.setText(userModel.getName());
            u_age.setText(userModel.getAge());
            u_address.setText(userModel.getAddress());
        }
    }

    @Override
    public String loadUserId() {
        return "100";
    }

    @Override
    public void setPresenter(UserContract.Presenter presenter) {
        this.u_presenter = presenter;
    }
}
