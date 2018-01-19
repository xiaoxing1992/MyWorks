package motoband.com.motobands.mvp.presenter.Contract;


import motoband.com.motobands.mvp.base.BasePresenter;
import motoband.com.motobands.mvp.base.BaseView;

/**
 * Description: WelcomeContract
 * Creator: yxc
 * date: 2016/9/22 13:16
 */
public interface GuideContract {

    interface View extends BaseView {
        void jumpToActivity();
    }

    interface Presenter extends BasePresenter<View> {

    }
}
