package motoband.com.motobands.di.component;

import android.app.Activity;

import dagger.Component;
import motoband.com.motobands.di.module.FragmentModule;
import motoband.com.motobands.di.scope.FragmentScope;
import motoband.com.motobands.mvp.ui.fragment.ChooseCarFragment;
import motoband.com.motobands.mvp.ui.fragment.MallFragment;
import motoband.com.motobands.mvp.ui.fragment.MyselfFragment;
import motoband.com.motobands.mvp.ui.fragment.RideFragment;
import motoband.com.motobands.mvp.ui.fragment.TimeLineFragment;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();


   void inject(TimeLineFragment timeLineFragment);
    void inject(ChooseCarFragment chooseCarFragment);
    void inject(RideFragment rideFragment);
    void inject(MallFragment mallFragment);
    void inject(MyselfFragment myselfFragment);


}
