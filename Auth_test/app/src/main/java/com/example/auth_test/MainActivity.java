package com.example.auth_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "Tokens";
    public static final String APP_PREFERENCES_TOKEN1 = "token1";
    SharedPreferences mToken;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToken = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
   }
    public void onIntent(View view){
        FragmentManager manager = getSupportFragmentManager();
        DialogFragment nF = new da();
        nF.show(manager, "signin");
    }
}
