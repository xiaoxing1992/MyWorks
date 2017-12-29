package motoband.com.motobands.di.component;


import javax.inject.Singleton;

import dagger.Component;
import motoband.com.motobands.di.module.AppModule;
import motoband.com.motobands.di.module.HttpModule;
import motoband.com.motobands.model.db.RealmHelper;
import motoband.com.motobands.mvp.base.MyApplication;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    MyApplication getContext();  // 提供App的Context

    RealmHelper realmHelper();    //提供数据库帮助类

}
