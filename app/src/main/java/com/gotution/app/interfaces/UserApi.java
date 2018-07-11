package com.gotution.app.interfaces;

import com.gotution.app.auth.Verification;
import com.gotution.app.models.NumberVerification;
import com.gotution.app.utils.Api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApi {


    @GET("auth/access_token/")
    Call<Verification> verifyUser(@Query(Api.AccountsApi.USER_PHONE)String phone);

    @POST("auth/otp/")
    Call<Verification> verifyPhone(@FieldMap Map<String, String> params);

    @GET("accounts/user")
    Call<Verification> getAccountInfo();

    @POST("auth/otp")
    Call<NumberVerification> requestVerificationCode(@Body Map<String, String> params);

    @GET("auth_key/")
    Call<ResponseBody> requestAuth(@HeaderMap Map<String, String> headerMap);
}
