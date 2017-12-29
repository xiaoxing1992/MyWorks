package motoband.com.motobands.mvp.ui.activity;

import motoband.com.motobands.R;
import motoband.com.motobands.mvp.base.BaseMvpActivity;
import motoband.com.motobands.mvp.presenter.Contract.WelcomeContract;
import motoband.com.motobands.mvp.presenter.WelcomePresenter;
import motoband.com.motobands.utils.EventUtil;

/**
 * Description: 开屏页
 * Creator: rzw
 * date: 2017/11/1 14:57
 */
public class WelcomeActivity extends BaseMvpActivity<WelcomePresenter> implements WelcomeContract.View {

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
    public void jumpToActivity() {
        SplashActivity.start(this);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
}