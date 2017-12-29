package motoband.com.motobands.model.http.api;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/12/28.
 * 用户开屏api
 */

public interface ClientUpdateService {

    @POST("getupdateconf")
    Observable<ResponseBody> getClientUpdateConfig(@Body RequestBody requestBody);
}
