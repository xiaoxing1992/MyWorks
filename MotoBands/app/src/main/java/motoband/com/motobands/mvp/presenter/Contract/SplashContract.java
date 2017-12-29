package motoband.com.motobands.mvp.presenter.Contract;

import motoband.com.motobands.mvp.base.BasePresenter;
import motoband.com.motobands.mvp.base.BaseView;

/**
 * Created by Administrator on 2017/12/22.
 */

public interface SplashContract {
    interface View extends BaseView {
        void jumpToActivity();
        void setCountDown(Long time);
    }

    interface Presenter extends BasePresenter<SplashContract.View> {
        void getSplashData();
    }
}
