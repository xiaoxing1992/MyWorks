package motoband.com.motobands.mvp.presenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import motoband.com.motobands.mvp.base.RxPresenter;
import motoband.com.motobands.mvp.presenter.Contract.SplashContract;

/**
 * Created by Administrator on 2017/12/22.
 */

public class SplashPresenter extends RxPresenter<SplashContract.View> implements SplashContract.Presenter {
    private static final int COUNT_DOWN_TIME = 4;

    @Override
    public void getSplashData() {

        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(COUNT_DOWN_TIME + 1)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return COUNT_DOWN_TIME - aLong;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//ui线程中进行控件更新
               .subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long num) {

              mView.setCountDown(num);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                //回复原来初始状态
                mView.jumpToActivity();
            }
        });



       /* Observable<Long> longObservable = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper());
        longObservable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                addSubscribe(d);
            }

            @Override
            public void onNext(@NonNull Long aLong) {
                mView.setCountDown(aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                mView.jumpToActivity();
            }
        });*/
    }

    @Inject
    public SplashPresenter() {
    }
}
