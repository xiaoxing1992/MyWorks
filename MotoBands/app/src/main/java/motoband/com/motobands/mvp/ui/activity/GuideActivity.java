package motoband.com.motobands.mvp.ui.activity;

import motoband.com.motobands.R;
import motoband.com.motobands.mvp.base.BaseMvpActivity;
import motoband.com.motobands.mvp.presenter.Contract.GuideContract;
import motoband.com.motobands.mvp.presenter.GuidePresenter;

public class GuideActivity extends BaseMvpActivity<GuidePresenter> implements GuideContract.View {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void jumpToActivity() {

    }
}
