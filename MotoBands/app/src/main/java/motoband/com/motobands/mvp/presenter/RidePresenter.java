package motoband.com.motobands.mvp.presenter;

import javax.inject.Inject;

import motoband.com.motobands.mvp.base.RxPresenter;
import motoband.com.motobands.mvp.presenter.Contract.TimeLineContract;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RidePresenter extends RxPresenter<TimeLineContract.View> implements TimeLineContract.Presenter {

    @Inject
    public RidePresenter() {
    }
}
