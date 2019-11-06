package com.example.auth_test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API_interface {
    @POST("api/tokens")
    Call<User> basicLogin();

    @POST("api/skip")
    Call<Pass> getSkip(@Body Pass skip_code);
}
