package com.icogroup.androidbaseproject.data.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by Ulises.harris on 4/27/16.
 */
public class ServiceHelper {

    public static final String BASE_URL = "http://api.myservice.com/";

    public static Retrofit retrofit;

    public ServiceHelper() {
        this(BASE_URL);
    }

    public ServiceHelper(String baseUrl) {

        Gson gson = new GsonBuilder()
                .create();

        if(retrofit == null){
            HttpLoggingInterceptor interceptorLog = new HttpLoggingInterceptor();
            interceptorLog.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptorLog).build();

            RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(rxAdapter)
                    .client(client)
                    .build();
        }

    }

}
