package motoband.com.motobands.model.http.net;

import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/28.
 */

public class RetrofitHelper {

    private static RetrofitHelper mInstance;
    private static Retrofit retrofit;
    private static String mBaseUrl;


    public RetrofitHelper(OkHttpClient okHttpClient, String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient != null ? okHttpClient : new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitHelper initRetrofitClient(OkHttpClient okHttpClient, @NonNull String baseUrl) {
        mBaseUrl = baseUrl;
        if (mInstance == null) {
            synchronized (RetrofitHelper.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitHelper(okHttpClient, baseUrl);
                }
            }
        }
        return mInstance;
    }

    public static RetrofitHelper getInstance() {
        if (mBaseUrl == null) {
            throw new RuntimeException("Please initialize Your \"BaseUrl\" in Application before use");
        }
        if (mInstance == null) {
            throw new RuntimeException("Please initialize Your \"RetrofitCoreClient\" in Application before use");
        }
        return mInstance;
    }

    public <T> T create(Class<T> clz) {
        return retrofit.create(clz);
    }

}
