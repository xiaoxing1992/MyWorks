package motoband.com.motobands.mvp.presenter;

import javax.inject.Inject;

import motoband.com.motobands.mvp.base.RxPresenter;
import motoband.com.motobands.mvp.presenter.Contract.MainContract;

/**
 * Created by Administrator on 2017/12/29.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{

    @Inject
    public MainPresenter() {
    }
}
