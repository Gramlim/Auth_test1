package com.example.auth_test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_xml);

        SharedPreferences sharedPrefences = getSharedPreferences("Tokens",0);
        String token = sharedPrefences.getString("token1", "fail");

        //Toast.makeText(this,token,Toast.LENGTH_LONG).show();
        API_interface loginService =
                ServiceGenerator.createService(API_interface.class, token);
        Call<Pass> call = loginService.getSkip( new Pass("95"));
        call.enqueue(new Callback<Pass>() {
            @Override
            public void onResponse(Call<Pass> call, Response<Pass> response) {
             OK(String.valueOf(response.message()));
            }

            @Override
            public void onFailure(Call<Pass> call, Throwable t) {

            }
        });
    }
    void OK(String str){
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }

}
