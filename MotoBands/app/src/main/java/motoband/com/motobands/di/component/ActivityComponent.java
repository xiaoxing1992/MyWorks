package motoband.com.motobands.di.component;

import android.app.Activity;

import dagger.Component;
import motoband.com.motobands.MainActivity;
import motoband.com.motobands.di.module.ActivityModule;
import motoband.com.motobands.di.scope.ActivityScope;
import motoband.com.motobands.mvp.ui.activity.SplashActivity;
import motoband.com.motobands.mvp.ui.activity.WelcomeActivity;

/**
 * Description:
 * Creator: yxc
 * date: $date $time
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);
}
