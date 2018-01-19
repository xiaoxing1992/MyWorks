package motoband.com.motobands;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import butterknife.BindView;
import motoband.com.motobands.mvp.base.BaseConstant;
import motoband.com.motobands.mvp.base.BaseMvpActivity;
import motoband.com.motobands.mvp.presenter.MainPresenter;
import motoband.com.motobands.mvp.ui.fragment.ChooseCarFragment;
import motoband.com.motobands.mvp.ui.fragment.MallFragment;
import motoband.com.motobands.mvp.ui.fragment.MyselfFragment;
import motoband.com.motobands.mvp.ui.fragment.RideFragment;
import motoband.com.motobands.mvp.ui.fragment.TimeLineFragment;
import motoband.com.motobands.utils.StatusBarManager;

public class MainActivity extends BaseMvpActivity<MainPresenter> {

    @BindView(R.id.rg_main)
    RadioGroup rg_main;
    private TimeLineFragment timeLineFragment;
    private ChooseCarFragment chooseCarFragment;
    private RideFragment rideFragment;
    private MallFragment mallFragment;
    private MyselfFragment myselfFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
        ((Activity) context).finish();
    }

    @Override
    public void showError(String msg) {

    }


    @Override
    protected void initView() {
        //设置沉浸式，让状态栏透明等
        StatusBarManager.setActivityStatusBar(MainActivity.this);
        setupRg();
    }

    @Override
    protected void initEventAndData(Bundle savedStated) {
        if (savedStated != null) {
            timeLineFragment = (TimeLineFragment) getSupportFragmentManager().findFragmentByTag("timeLineFragment");
            chooseCarFragment = (ChooseCarFragment) getSupportFragmentManager().findFragmentByTag("chooseCarFragment");
            rideFragment = (RideFragment) getSupportFragmentManager().findFragmentByTag("rideFragment");
            mallFragment = (MallFragment) getSupportFragmentManager().findFragmentByTag("mallFragment");
            myselfFragment = (MyselfFragment) getSupportFragmentManager().findFragmentByTag("myselfFragment");
            switchFragment(BaseConstant.RB_RIDING);

        } else {
            timeLineFragment = TimeLineFragment.newInstance();
            chooseCarFragment = ChooseCarFragment.newInstance();
            rideFragment = RideFragment.newInstance();
            mallFragment = MallFragment.newInstance();
            myselfFragment = MyselfFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fl_container_main, timeLineFragment, "timeLineFragment")
                    .add(R.id.fl_container_main, chooseCarFragment, "chooseCarFragment")
                    .add(R.id.fl_container_main, rideFragment, "rideFragment")
                    .add(R.id.fl_container_main, mallFragment, "mallFragment")
                    .add(R.id.fl_container_main, myselfFragment, "myselfFragment")
                    .commit();
            switchFragment(BaseConstant.RB_RIDING);

        }
    }

    /**
     * RadioGroup点击监听
     */
    private void setupRg() {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        switchFragment(BaseConstant.RB_HOME);
                        break;
                    case R.id.rb_choose_car:
                        switchFragment(BaseConstant.RB_CHOOSE_CAR);
                        break;
                    case R.id.rb_riding:
                        switchFragment(BaseConstant.RB_RIDING);
                        break;
                    case R.id.rb_equipment:
                        switchFragment(BaseConstant.RB_EQUIPMENT);
                        break;

                    case R.id.rb_mine:
                        switchFragment(BaseConstant.RB_MINE);
                        break;
                }

            }
        });
    }

    /**
     * 切换Fragment
     *
     * @param index
     */
    private void switchFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (index) {
            case BaseConstant.RB_HOME:
                transaction
                        .show(timeLineFragment)
                        .hide(chooseCarFragment)
                        .hide(rideFragment)
                        .hide(mallFragment)
                        .hide(myselfFragment);
                timeLineFragment.setUserVisibleHint(true);
                chooseCarFragment.setUserVisibleHint(false);
                rideFragment.setUserVisibleHint(false);
                mallFragment.setUserVisibleHint(false);
                myselfFragment.setUserVisibleHint(false);
                break;
            case BaseConstant.RB_CHOOSE_CAR:
                transaction
                        .show(chooseCarFragment)
                        .hide(timeLineFragment)
                        .hide(rideFragment)
                        .hide(mallFragment)
                        .hide(myselfFragment);
                chooseCarFragment.setUserVisibleHint(true);
                rideFragment.setUserVisibleHint(false);
                timeLineFragment.setUserVisibleHint(false);
                mallFragment.setUserVisibleHint(false);
                myselfFragment.setUserVisibleHint(false);
                break;
            case BaseConstant.RB_RIDING:
                transaction
                        .show(rideFragment)
                        .hide(chooseCarFragment)
                        .hide(timeLineFragment)
                        .hide(mallFragment)
                        .hide(myselfFragment);
                rideFragment.setUserVisibleHint(true);
                chooseCarFragment.setUserVisibleHint(false);
                mallFragment.setUserVisibleHint(false);
                timeLineFragment.setUserVisibleHint(false);
                myselfFragment.setUserVisibleHint(false);
                break;
            case BaseConstant.RB_EQUIPMENT:
                transaction
                        .show(mallFragment)
                        .hide(rideFragment)
                        .hide(chooseCarFragment)
                        .hide(myselfFragment)
                        .hide(timeLineFragment);
                mallFragment.setUserVisibleHint(true);
                rideFragment.setUserVisibleHint(false);
                chooseCarFragment.setUserVisibleHint(false);
                myselfFragment.setUserVisibleHint(false);
                timeLineFragment.setUserVisibleHint(false);
                break;

            case BaseConstant.RB_MINE:
                transaction
                        .show(myselfFragment)
                        .hide(chooseCarFragment)
                        .hide(mallFragment)
                        .hide(rideFragment)
                        .hide(timeLineFragment);
                myselfFragment.setUserVisibleHint(true);
                chooseCarFragment.setUserVisibleHint(false);
                mallFragment.setUserVisibleHint(false);
                rideFragment.setUserVisibleHint(false);
                timeLineFragment.setUserVisibleHint(false);
                break;
        }
        transaction.commit();
    }

}
