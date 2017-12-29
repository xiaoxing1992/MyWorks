package motoband.com.motobands.mvp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import motoband.com.motobands.MainActivity;
import motoband.com.motobands.R;
import motoband.com.motobands.mvp.base.BaseMvpActivity;
import motoband.com.motobands.mvp.presenter.Contract.SplashContract;
import motoband.com.motobands.mvp.presenter.SplashPresenter;

public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements SplashContract.View {

    @BindView(R.id.img_login)
    ImageView imgLogin;
    @BindView(R.id.user_name_txt)
    TextView userNameTxt;
    @BindView(R.id.count_down_time_txt)
    TextView countDownTimeTxt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mPresenter.getSplashData();

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SplashActivity.class);
        context.startActivity(starter);
        ((Activity)context).finish();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void jumpToActivity() {
        MainActivity.start(this);
    }

    @Override
    public void setCountDown(Long time) {
        countDownTimeTxt.setText(time+"跳过");
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

}
