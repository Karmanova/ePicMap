package ru.nsu.ccfit.karmanova.epicmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKSdkListener;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Анастасия on 24.04.2015.
 */
public class MainActivity extends Activity {
    private String appId = "4890954";
    private static String sTokenKey = "VK_ACCESS_TOKEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        VKUIHelper.onResume(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VKUIHelper.onDestroy(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VKUIHelper.onActivityResult(requestCode, resultCode, data);
    }

    private void test() {
        VKSdkListener listener = new VKSdkListener() {
            @Override
            public void onCaptchaError(VKError vkError) {

            }

            @Override
            public void onTokenExpired(VKAccessToken vkAccessToken) {

            }

            @Override
            public void onAccessDenied(VKError vkError) {

            }
        };

        VKSdk.initialize(listener, appId, VKAccessToken.tokenFromSharedPreferences(this, sTokenKey));
        Map map = new HashMap();
        map.put("user_id", 95191267);
        VKRequest vkRequest = VKApi.friends().get(new VKParameters(map));
        Log.i("qwe", "тут");
    }

}
