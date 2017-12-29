package motoband.com.motobands.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import motoband.com.motobands.model.http.api.Constants;
import motoband.com.motobands.model.http.net.OkHttpManager;
import motoband.com.motobands.model.http.net.RetrofitHelper;
import okhttp3.OkHttpClient;

/**
 * Created by codeest on 2017/2/26.
 */

@Module
public class HttpModule {

    @Singleton
    @Provides
    RetrofitHelper provideRetrofitBuilder() {
        return RetrofitHelper.getInstance();
    }


    @Singleton
    @Provides
    OkHttpClient provideClient() {
        return OkHttpManager.getInstance();
    }

    private RetrofitHelper createRetrofit() {
        return RetrofitHelper.initRetrofitClient(OkHttpManager.getInstance(), Constants.MOTOBAND_SERVICE_URL);
    }


//    @Singleton
//    @Provides
//    @GankUrl
//    Retrofit provideGankRetrofit(Retrofit.Builder builder, OkHttpClient client) {
//        Log.i("TAG", "--provideGankRetrofit");
//        return createRetrofit(builder, client, GankApis.HOST);//GankApis
//    }

//
//    @Singleton
//    @Provides
//    GankApis provideGankService(@GankUrl Retrofit retrofit) {
//        return retrofit.create(GankApis.class);
//    }
}
