package app.in.com.fcm.Sample;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


/**
 * Created by mayankweb on 12/2/2016.
 */

public class RestClient {

    private final static String  URL_MAIN = "http://xx.xx.xx/fcm/";

    public static FcmService sendFcmToken() {
        Retrofit client = new Retrofit.Builder()
                .baseUrl(URL_MAIN)
                .client(new OkHttpClient())
                .build();

        return client.create(FcmService.class);
    }

}