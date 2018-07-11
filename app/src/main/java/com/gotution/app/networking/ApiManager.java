package com.gotution.app.networking;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.gotution.app.auth.Verification;
import com.gotution.app.data.DBWrapper;
import com.gotution.app.interfaces.CustomListener;
import com.gotution.app.interfaces.RetroErrorListener;
import com.gotution.app.interfaces.UserApi;
import com.gotution.app.models.NumberVerification;
import com.gotution.app.utils.Api;
import com.gotution.app.utils.CommonLib;
import com.gotution.app.utils.ListUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {
    private static final String TEMPLATE_VERSION_ONE = "1";
    private final String LOG_TAG = this.getClass ().getSimpleName ();


    private String parseResponseBody(ResponseBody responseBody) throws Exception {
        StringBuilder builder = new StringBuilder ();
        try {
            Reader reader = responseBody.charStream ();
            int data = reader.read ();
            while (data != -1) {
                builder.append ((char) data);
                data = reader.read ();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            responseBody.close ();
            return builder.toString ();
        }
    }

    public String executeSyncPlacesAutoCompleteCall(Call<ResponseBody> call) throws IOException {
        retrofit2.Response<ResponseBody> response = call.execute ();
        if (response.isSuccessful ()) {
            StringBuilder builder = new StringBuilder ();
            Reader reader = response.body ().charStream ();
            int data = reader.read ();
            while (data != -1) {
                builder.append ((char) data);
                data = reader.read ();
            }
            return builder.toString ();
        } else {
            throw new IOException ();
        }
    }


    /**
     * use this function for verifying user phone number and login
     *
     * @param requestCode
     * @param mPhoneNumber
     * @param listener
     * @param retroErrorListener
     */
    public void verifyPhone(String requestCode, String mPhoneNumber, final CustomListener listener, final RetroErrorListener retroErrorListener) {
        final HashMap<String, String> params = new HashMap<String, String> ();
        params.put (CommonLib.Headers.VERIFY_CODE, requestCode);
        params.put (CommonLib.Headers.VERIFY_PHONE, mPhoneNumber);
        params.put (Api.AccountsApi.USER_TYPE, "1");
        Call<Verification> call = CustomRetrofitBuilder.getInstance ().build (Api.getGoTutionBaseAddress ().toString ()).create (UserApi.class).verifyPhone (params);
        call.enqueue (new Callback<Verification> () {
            @Override
            public void onResponse(Call<Verification> call, retrofit2.Response<Verification> response) {
                if (response.isSuccessful ()) {
                    listener.onResponse (response.body (), null, response.raw ().request ().url ().toString ());
                } else {
                    retroErrorListener.onErrorResponse (response, response.code (), null, response.raw ().request ().url ().toString ());
                }
            }

            @Override
            public void onFailure(Call<Verification> call, Throwable t) {
                if (!call.isCanceled () && !(t != null && CommonLib.CALL_FAILURE_TEXT.equalsIgnoreCase (t.getMessage ())))
                    retroErrorListener.onErrorResponse (t);
            }
        });
    }


    public void requestVerificationCode(String phone, final CustomListener listener, final RetroErrorListener retroErrorListener) {
        Map<String, String> params = new HashMap<String, String>();
        params.put (Api.AccountsApi.USER_PHONE, phone);
        params.put (Api.AccountsApi.USER_TYPE, "1");
        Call<NumberVerification> call = CustomRetrofitBuilder.getInstance ().build (Api.getGoTutionBaseAddress ().toString ()).create (UserApi.class).requestVerificationCode (params);

        Log.d(LOG_TAG, "Call Request url" + call.request ().toString () + ": body: "+ call.request ().body ());

        call.enqueue (new Callback<NumberVerification> () {
            @Override
            public void onResponse(Call<NumberVerification> call, retrofit2.Response<NumberVerification> response) {

                Log.d(LOG_TAG, "in onResponse");
                if (response.isSuccessful ()) {
                    listener.onResponse (response.body (), null, response.raw ().request ().url ().toString ());
                } else {
                    retroErrorListener.onErrorResponse (response, response.code (), null, response.raw ().request ().url ().toString ());
                }
            }

            @Override
            public void onFailure(Call<NumberVerification> call, Throwable t) {
                Log.d(LOG_TAG, "in onFailure");
                if (!call.isCanceled () && !(t != null && CommonLib.CALL_FAILURE_TEXT.equalsIgnoreCase (t.getMessage ())))
                    retroErrorListener.onErrorResponse (t);
            }
        });
        Log.d(LOG_TAG, "Call Request url" + call.request ().toString () + ": body: "+ call.request ().body ());
    }
}

