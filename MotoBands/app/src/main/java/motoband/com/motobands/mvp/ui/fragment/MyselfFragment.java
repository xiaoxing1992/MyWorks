package motoband.com.motobands.mvp.ui.fragment;

import motoband.com.motobands.R;
import motoband.com.motobands.mvp.base.BaseMVPFragment;
import motoband.com.motobands.mvp.presenter.Contract.TimeLineContract;
import motoband.com.motobands.mvp.presenter.TimeLinePresenter;
import motoband.com.motobands.utils.StatusBarManager;

/**
 * Created by Administrator on 2017/12/29.
 */

public class MyselfFragment extends BaseMVPFragment<TimeLinePresenter> implements TimeLineContract.View {

    public static MyselfFragment newInstance() {
        return new MyselfFragment();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_myself;
    }

    @Override
    protected void initEventAndData() {
        StatusBarManager.setStatusBar(getActivity(), rootView, R.id.ll_bar, R.color.title_bar);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
