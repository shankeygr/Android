package com.gotution.app.networking;

import android.content.Context;
import android.net.Uri;
import android.support.constraint.solver.Cache;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gotution.app.application.goTutionApp;
import com.gotution.app.data.DBWrapper;
import com.gotution.app.utils.CommonLib;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseRetrofitBuilder {

    private static String LOG_TAG = BaseRetrofitBuilder.class.getSimpleName();

    private static Dispatcher dispatcher;

    public static final String SET_COOKIE = "Set-Cookie";
    public static final String COOKIE = "Cookie";

    public static final String CACHE_DIRECTORY_NAME = "HttpCache";

    public static final long CACHE_SIZE = 1024 * 1024 * 5;
    static volatile Retrofit.Builder retrofitBuilder;

    static volatile OkHttpClient.Builder okHttpBuilder;


    public volatile static BaseRetrofitBuilder sInstance;

    private Context context;

    protected static final Gson gson =
            new Gson ();

    /**
     * creates a new instance of retrofit builder
     *
     * @return
     */
    private static final Retrofit.Builder getRetrofitBuilder() {
        if (retrofitBuilder == null) {
            synchronized (Retrofit.Builder.class) {
                retrofitBuilder = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create(gson));
            }
        }
        return retrofitBuilder;
    }

    /**
     * gets @{@link CustomRetrofitBuilder} instance and sets the provided base url
     *
     * @param baseUrl
     * @return
     */
    public Retrofit build(String baseUrl) {
        Retrofit retrofit = getRetrofitBuilder()
                .baseUrl(baseUrl + "/")
                .client(getClient(10))
                .build();
        return retrofit;
    }

    public Retrofit build() {
        Retrofit retrofit = getRetrofitBuilder()
                .client(getClient(10))
                .build();
        return retrofit;
    }

    /**
     * gets @{@link CustomRetrofitBuilder} instance and sets the provided base url with timeout in seconds
     *
     * @param baseUrl
     * @param timeoutSecs
     * @return
     */

    public Retrofit build(String baseUrl, int timeoutSecs) {
        Retrofit retrofit = getRetrofitBuilder()
                .baseUrl(baseUrl + "/")
                .client(getClient(timeoutSecs))
                .build();
        return retrofit;
    }

    /**
     * use this to get a {@link OkHttpClient}. Adds basic and auth headers along with logging in debug builds
     *
     * @return
     */
    private okhttp3.OkHttpClient getClient(int timeoutSecs) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);


        if (okHttpBuilder == null) {
            synchronized (OkHttpClient.Builder.class) {
                okHttpBuilder = new OkHttpClient.Builder();
                okHttpBuilder.addInterceptor(new Interceptor () {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        String url = chain.request().url().toString();
                        try {
                            url = Uri.parse(java.net.URLDecoder.decode(url, "UTF-8")).buildUpon().build().toString();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        builder.url(url);
                        builder.header("Content-Type", "application/json");
//                        for (Map.Entry<String, String> entry : CommonLib.getAuthenticationHeaders().entrySet()) {
//                            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
//                                if (chain.request().headers().get(entry.getKey()) == null) {
//                                    builder.header(entry.getKey(), entry.getValue());
//                                }
//                            } else
//                                Log.d(LOG_TAG, entry.getKey() + ": " + entry.getValue());
//                        }

                        Response response = chain.proceed(builder.build());

                        String cookie = response.header(SET_COOKIE);
//                        if (!TextUtils.isEmpty(cookie))
//                            DBWrapper.getInstance().save(COOKIE, cookie).close();

                        return response;
                    }
                });
                //enable this to test out cache headers
                //okHttpBuilder.addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
            }

        }

        if (timeoutSecs > 0) {
            okHttpBuilder.connectTimeout(timeoutSecs, TimeUnit.SECONDS);
            okHttpBuilder.readTimeout(timeoutSecs, TimeUnit.SECONDS);
        }
        okHttpBuilder.retryOnConnectionFailure(true);
        okhttp3.OkHttpClient client = okHttpBuilder.build();
        dispatcher = client.dispatcher();
        return client;
    }




    public static void cancelAll() {
        if (dispatcher != null) {
            dispatcher.cancelAll();
        }
    }


    public static BaseRetrofitBuilder getInstance() {
        if (sInstance == null) {
            synchronized (CustomRetrofitBuilder.class) {
                if (sInstance == null) {
                    sInstance = new CustomRetrofitBuilder();
                }
            }
        }
        return sInstance;
    }

    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder()
                    .header("Cache-Control", String.format("max-age=%d, only-if-cached, max-stale=%d", 60, 60))
                    .build();
        }
    };

}