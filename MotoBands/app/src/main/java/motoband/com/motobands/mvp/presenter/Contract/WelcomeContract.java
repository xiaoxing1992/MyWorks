package motoband.com.motobands.mvp.presenter.Contract;


import motoband.com.motobands.model.bean.AdvertisingModel;
import motoband.com.motobands.mvp.base.BasePresenter;
import motoband.com.motobands.mvp.base.BaseView;

/**
 * Description: WelcomeContract
 * Creator: yxc
 * date: 2016/9/22 13:16
 */
public interface WelcomeContract {

    interface View extends BaseView {
        void jumpToActivity();

        void jumpToActivity(boolean flag, AdvertisingModel t);

        void jumpToActivity(AdvertisingModel t);
    }


    interface Presenter extends BasePresenter<View> {
        void getWelcomeData();

        void setRequestPermissions();
    }
}
