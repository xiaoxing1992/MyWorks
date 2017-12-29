package motoband.com.motobands.model.http.net;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import motoband.com.motobands.BuildConfig;
import motoband.com.motobands.mvp.Constants;
import motoband.com.motobands.utils.SystemUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2017/12/28.
 */

public class OkHttpManager {
    private static OkHttpClient okHttpClient;

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (OkHttpManager.class) {
                if (okHttpClient == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                        builder.addInterceptor(interceptor);
                    }

                    File cacheFile = new File(Constants.PATH_CACHE);
                    Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
                    Interceptor cacheInterceptor = new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            if (!SystemUtil.isNetworkConnected()) {
                                request = request.newBuilder()
                                        .cacheControl(CacheControl.FORCE_CACHE)
                                        .build();
                            }
                            Response response = chain.proceed(request);
                            if (SystemUtil.isNetworkConnected()) {
                                int maxAge = 0;
                                // 有网络时, 不缓存, 最大保存时长为0
                                response.newBuilder()
                                        .header("Cache-Control", "public, max-age=" + maxAge)
                                        .removeHeader("Pragma")
                                        .build();
                            } else {
                                // 无网络时，设置超时为4周
                                int maxStale = 60 * 60 * 24 * 28;
                                response.newBuilder()
                                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                        .removeHeader("Pragma")
                                        .build();
                            }
                            return response;
                        }
                    };

                    //设置缓存
                    builder.addNetworkInterceptor(cacheInterceptor);
                    builder.addInterceptor(cacheInterceptor);
                    builder.cache(cache);


                    //超时时间
                    builder.connectTimeout(15, TimeUnit.SECONDS);//15S连接超时
                    builder.readTimeout(20, TimeUnit.SECONDS);//20s读取超时
                    builder.writeTimeout(20, TimeUnit.SECONDS);//20s写入超时
                    //错误重连
                    builder.retryOnConnectionFailure(true);
                    okHttpClient = builder.build();

                }
            }
        }
        return okHttpClient;
    }

}
