package com.icogroup.androidbaseproject.data.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.icogroup.androidbaseproject.data.connection.interfaces.MovieInterface;
import com.icogroup.androidbaseproject.data.connection.interfaces.UserInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ulises.harris on 4/27/16.
 */
public class ServiceHelper {

    public static final String BASE_URL = "http://www.omdbapi.com";

    public static Retrofit retrofit;

    public ServiceHelper() {
        this(BASE_URL);
    }

    public static MovieInterface mMovieInterface;

    public static UserInterface mUserInterface;

    public ServiceHelper(String baseUrl) {

        Gson gson = new GsonBuilder()
                .create();

        if(retrofit == null){
            HttpLoggingInterceptor interceptorLog = new HttpLoggingInterceptor();
            interceptorLog.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptorLog).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            if(mMovieInterface == null)
                mMovieInterface = retrofit.create(MovieInterface.class);

            if(mUserInterface == null)
                mUserInterface = retrofit.create(UserInterface.class);
        }

    }

    public static MovieInterface getMovieInterface(){
        if(mMovieInterface != null){
            return mMovieInterface;
        }else{
            if(retrofit != null){
                mMovieInterface = retrofit.create(MovieInterface.class);
                return mMovieInterface;
            }else{
                ServiceHelper service = new ServiceHelper();
                return  mMovieInterface;
            }
        }
    }

    public static UserInterface getUserInterface(){
        if(mUserInterface != null){
            return mUserInterface;
        }else{
            if(retrofit != null){
                mUserInterface = retrofit.create(UserInterface.class);
                return mUserInterface;
            }else{
                ServiceHelper service = new ServiceHelper();
                return mUserInterface;
            }
        }
    }

}
