package app.in.com.fcm.Sample;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by shikha on 4/7/2017.
 */

public interface FcmService {

    @FormUrlEncoded
    @POST("fcm_insert.php")
    Call<ResponseBody> fcmService(@Field("fcm_token") String timestamp);
}
