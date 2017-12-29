package motoband.com.motobands.mvp.presenter.Contract;

import motoband.com.motobands.mvp.base.BasePresenter;
import motoband.com.motobands.mvp.base.BaseView;

/**
 * Created by Administrator on 2017/12/29.
 */

public interface MainContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<MainContract.View> {

    }
}
