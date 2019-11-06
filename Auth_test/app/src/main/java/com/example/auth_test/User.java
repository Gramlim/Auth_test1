package com.example.auth_test;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("token")
    private String token;

    public String getToken(){
        return token;
    }
}
