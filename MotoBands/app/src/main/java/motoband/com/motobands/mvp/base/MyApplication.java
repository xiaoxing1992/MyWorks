package motoband.com.motobands.mvp.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;
import motoband.com.motobands.di.component.AppComponent;
import motoband.com.motobands.di.component.DaggerAppComponent;
import motoband.com.motobands.di.module.AppModule;
import motoband.com.motobands.di.module.HttpModule;
import motoband.com.motobands.model.db.RealmHelper;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/2/13
 */

public class MyApplication extends Application {

    private static MyApplication mInstance;
    private static Context context;
    private Set<Activity> allActivities;

    public MyApplication() {
        mInstance = this;
    }

    public static MyApplication getInstance() {
        if (mInstance != null) {
            return mInstance;
        } else {
            mInstance = new MyApplication();
            mInstance.onCreate();
            return mInstance;
        }
    }

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        context = getApplicationContext();
        //蒲公英crash上报
//        PgyCrashManager.register(this);
        //初始化内存泄漏检测
//        LeakCanary.install(this);
        //初始化过度绘制检测
//        BlockCanary.install(this, new AppBlockCanaryContext()).start();
//        初始化realm
        initRealm();
        Realm.init(getApplicationContext());
    }
    public void registerActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    public void unregisterActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (act != null && !act.isFinishing())
                        act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(RealmHelper.DB_NAME)
                .schemaVersion(1)
                .rxFactory(new RealmObservableFactory())
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static Context getContext() {
        return context;
    }

    public static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(mInstance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }
}
