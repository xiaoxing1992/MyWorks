package motoband.com.motobands.mvp.ui.fragment;

import motoband.com.motobands.R;
import motoband.com.motobands.mvp.base.BaseMVPFragment;
import motoband.com.motobands.mvp.presenter.Contract.RideContract;
import motoband.com.motobands.mvp.presenter.RidePresenter;
import motoband.com.motobands.utils.StatusBarManager;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RideFragment extends BaseMVPFragment<RidePresenter> implements RideContract.View {

    public static RideFragment newInstance() {
        return new RideFragment();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ride;
    }

    @Override
    protected void initEventAndData() {
        StatusBarManager.setStatusBarView(getActivity(), rootView, R.id.view_status_bar, R.color.main_foreground_black);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
