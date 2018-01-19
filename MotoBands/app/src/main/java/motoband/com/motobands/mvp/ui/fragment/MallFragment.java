package motoband.com.motobands.mvp.ui.fragment;

import motoband.com.motobands.R;
import motoband.com.motobands.mvp.base.BaseMVPFragment;
import motoband.com.motobands.mvp.presenter.Contract.TimeLineContract;
import motoband.com.motobands.mvp.presenter.TimeLinePresenter;

/**
 * Created by Administrator on 2017/12/29.
 */

public class MallFragment extends BaseMVPFragment<TimeLinePresenter> implements TimeLineContract.View {

    public static MallFragment newInstance() {
        return new MallFragment();
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

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
