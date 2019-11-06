package com.example.auth_test;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    public static <S> S createService(Class<S> serviceClass, String username, String password) {
        Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("http://intelligent-system.online/")
                        .addConverterFactory(GsonConverterFactory.create());

        String authToken = Credentials.basic(username, password);

        AuthenticationInterceptor interceptor =
                new AuthenticationInterceptor(authToken);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        builder.client(httpClient.build());

        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, String authToken){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://intelligent-system.online/")
                .addConverterFactory(GsonConverterFactory.create());
        String str = "yA5Q6V6ceZijfHAm1aEY0u9rXWIb5h05";

        AuthenticationInterceptor interceptor = new AuthenticationInterceptor("Bearer " + authToken);

        Log.d("request", interceptor.toString());
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        builder.client(httpClient.build());
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }
}
