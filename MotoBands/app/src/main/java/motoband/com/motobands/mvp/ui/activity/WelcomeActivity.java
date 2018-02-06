package motoband.com.motobands.mvp.ui.activity;

import android.content.Intent;

import motoband.com.motobands.R;
import motoband.com.motobands.model.bean.AdvertisingModel;
import motoband.com.motobands.mvp.base.BaseMvpActivity;
import motoband.com.motobands.mvp.presenter.Contract.WelcomeContract;
import motoband.com.motobands.mvp.presenter.WelcomePresenter;
import motoband.com.motobands.utils.EventUtil;

/**
 * Description: 开屏页
 * Creator: rzw
 * date: 2017/11/1 14:57
 */
public class WelcomeActivity extends BaseMvpActivity<WelcomePresenter> implements WelcomeContract.View  {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {

        mPresenter.setRequestPermissions();
        mPresenter.getWelcomeData();
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext, msg);
    }



    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void jumpToActivity() {
        Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void jumpToActivity(boolean flag, AdvertisingModel advertisingModel) {
        Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
        intent.putExtra("isShowMotoBandGuide", true);
        if (advertisingModel != null) {
            intent.putExtra("advertisingModel", advertisingModel);
        }
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void jumpToActivity(AdvertisingModel advertisingModel) {
        SplashActivity.start(this);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}