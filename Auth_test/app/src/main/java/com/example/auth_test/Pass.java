package com.example.auth_test;

import com.google.gson.annotations.SerializedName;

public class Pass {
    @SerializedName("delete")
    private String delete;
    @SerializedName("id")
    private String id;
    @SerializedName("skip_code")
    private String skip_code;

    public  Pass(String pass){
        skip_code = pass;
    }
    public String getDelete(){
        return delete;
    }
    public String getId(){
        return id;
    }
    public String getSkip_code(){
        return skip_code;
    }
}

