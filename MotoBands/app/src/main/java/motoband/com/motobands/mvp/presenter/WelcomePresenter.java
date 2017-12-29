package motoband.com.motobands.mvp.presenter;


import android.app.AlertDialog;
import android.util.Log;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import motoband.com.motobands.mvp.base.RxPresenter;
import motoband.com.motobands.mvp.presenter.Contract.WelcomeContract;
import motoband.com.motobands.mvp.ui.activity.WelcomeActivity;
import motoband.com.motobands.utils.RxUtil;


/**
 * Description: WelcomePresenter
 * Creator: yxc
 * date: 2016/9/22 13:17
 */
public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {
    private static final String TAG = "RxPermissionTest";

    private static final int COUNT_DOWN_TIME = 1000;

    private boolean denied;

    @Inject
    public WelcomePresenter() {

    }


    @Override
    public void getWelcomeData() {

    }

    @Override
    public void setRequestPermissions() {
        RxPermissions rxPermission = new RxPermissions((WelcomeActivity) mView);
        rxPermission
                .requestEach(android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        //  android.Manifest.permission.READ_CALENDAR,
                        // android.Manifest.permission.READ_CALL_LOG,
                        //   android.Manifest.permission.READ_CONTACTS,
                        //    android.Manifest.permission.READ_SMS,
                        //    android.Manifest.permission.RECORD_AUDIO,
                        //    android.Manifest.permission.CAMERA,
                        //    android.Manifest.permission.CALL_PHONE,
                        //   android.Manifest.permission.SEND_SMS
                        android.Manifest.permission.READ_PHONE_STATE
                )
                .subscribe(new Observer<Permission>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Permission permission) {
                        if (permission.granted) {
                            // 用户已经同意该权限
                            Log.d(TAG, permission.name + " is granted.");
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            Log.d(TAG, permission.name + " is denied. More info should be provided.");
                            denied = true;
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                            Log.d(TAG, permission.name + " is denied.");
                            denied = true;

                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete is denied.");

                        if (!denied) {
                            startCountDown();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder((WelcomeActivity) mView);
                            builder.setMessage("缺少权限");
                            builder.setPositiveButton("知道了", null);
                            builder.setCancelable(true);
                            builder.show();
                        }
                    }
                });
    }

    private void startCountDown() {
        Observable<Long> longObservable = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper());
        longObservable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                addSubscribe(d);
            }

            @Override
            public void onNext(@NonNull Long aLong) {
                mView.jumpToActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
