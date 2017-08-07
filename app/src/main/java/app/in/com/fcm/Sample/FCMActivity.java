package app.in.com.fcm.Sample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import app.in.com.fcm.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shikha on 4/6/2017.
 */

public class FCMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Button button2 = (Button) findViewById(R.id.button2);
        Log.v("TAG","FCMTest");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences
                        (getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
                final String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN), "");
                FcmService fcmService = RestClient.sendFcmToken();
                final Call<ResponseBody> responseBodyCall = fcmService.fcmService(token);
                responseBodyCall.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                Log.v("TAG",response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.v("TAG","FAIL");
                        }
                        responseBodyCall.cancel();
                    }
                    @Override
                    public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                        Log.v("TAG",t.getMessage());
                    }
                });
            }
        });
    }
}
