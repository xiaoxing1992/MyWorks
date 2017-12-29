package motoband.com.motobands.mvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import motoband.com.motobands.di.component.DaggerFragmentComponent;
import motoband.com.motobands.di.component.FragmentComponent;
import motoband.com.motobands.di.module.FragmentModule;

/**
 * BaseFragment，拥有懒加载方法
 */

public abstract class BaseMVPFragment<T extends BasePresenter> extends Fragment implements BaseView {

    @Inject
    protected T mPresenter;

    protected Activity mContext;
    private boolean isInit;
    private boolean isLoad;
    protected View rootView;
    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        mContext = (Activity) context;
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        isInit = true;
        mUnbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEventAndData();
        initEventAndData(savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        loadData();
    }

    private void loadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyLoadEveryTime();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    /**
     * 懒加载实现该方法，里面的方法在Fragment每次的重现中会再次调用，
     * 如果只需加载一次，需自行增加判断
     */
    protected void lazyLoadEveryTime() {

    }

    /**
     * 取消懒加载
     */
    protected void stopLoad() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
    }


    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    protected abstract int getLayoutId();


    protected void initEventAndData(Bundle saveData) {
    }

    protected abstract void initEventAndData();

    protected abstract void initInject();
}
