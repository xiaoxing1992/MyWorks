package motoband.com.motobands.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import motoband.com.motobands.model.db.DBHelper;
import motoband.com.motobands.model.db.RealmHelper;
import motoband.com.motobands.mvp.base.MyApplication;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext() {
        return application;
    }



    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

}
