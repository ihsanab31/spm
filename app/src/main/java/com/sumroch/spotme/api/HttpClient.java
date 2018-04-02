package com.sumroch.spotme.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.sumroch.spotme.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class HttpClient {
    private static final String BASE_API_URL = "http://api.sumroch.com/api/";
    //    private static final String BASE_FILE_URL = "http://api.sumroch.com/file/promotion_picture?path=";
    private static final String STAGING_BASE_URL = "http://spotapi.lebakhosting.com/";
    private static HttpClient instance;
    private Retrofit client;
    private Endpoint endpoint;

    private HttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(2, TimeUnit.MINUTES);
        builder.readTimeout(2, TimeUnit.MINUTES);
        if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug")) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        builder.addNetworkInterceptor(new StethoInterceptor());
        OkHttpClient okHttpClient = builder.build();
        client = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private HttpClient(String tag) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(2, TimeUnit.MINUTES);
        builder.readTimeout(2, TimeUnit.MINUTES);
        if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug")) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        builder.addNetworkInterceptor(new StethoInterceptor());
        OkHttpClient okHttpClient = builder.build();
        client = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * @return single instance of {@link HttpClient}
     */
    public static HttpClient getInstance() {
        if (instance == null)
            instance = new HttpClient();
        return instance;
    }

    public static HttpClient getInstance(String tag) {
        if (instance == null)
            instance = new HttpClient(tag);
        return instance;
    }

    public Endpoint getApi() {
        if (endpoint == null) {
            endpoint = client.create(Endpoint.class);
        }
        return endpoint;
    }
}
