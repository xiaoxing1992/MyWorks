package motoband.com.motobands.mvp.presenter;


import javax.inject.Inject;

import motoband.com.motobands.mvp.base.RxPresenter;
import motoband.com.motobands.mvp.presenter.Contract.GuideContract;


/**
 * Description: WelcomePresenter
 * Creator: yxc
 * date: 2016/9/22 13:17
 */
public class GuidePresenter extends RxPresenter<GuideContract.View> implements GuideContract.Presenter {
    private static final String TAG = "RxPermissionTest";

    private static final int COUNT_DOWN_TIME = 1000;

    private boolean denied;

    @Inject
    public GuidePresenter() {

    }


}
