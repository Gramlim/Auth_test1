package com.example.auth_test;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.auth_test.MainActivity.APP_PREFERENCES;
import static com.example.auth_test.MainActivity.APP_PREFERENCES_TOKEN1;

public class da extends DialogFragment {
    View view;
    EditText edUser;
    EditText edPswrd;


    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        this.view = inflater.inflate(R.layout.auth, null);
        builder.setView(view);
        this.edUser = this.view.findViewById(R.id.editText);
        this.edPswrd = this.view.findViewById(R.id.editText2);
        Button log = view.findViewById(R.id.button2);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(getActivity(), activity_1.class);
                //startActivity(intent);

                API_interface loginService =
                        ServiceGenerator.createService(API_interface.class, String.valueOf(edUser.getText()),
                                String.valueOf(edPswrd.getText()));
                Call<User> call = loginService.basicLogin();
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            SharedPreferences sharedPrefences = getContext().getSharedPreferences
                                    ("Tokens",0);
                            SharedPreferences.Editor editor = sharedPrefences.edit();
                            editor.putString("token1", response.body().getToken());
                            editor.apply();
                            Intent intent = new Intent(getActivity(), activity_1.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getContext(), String.valueOf(response.message()), Toast.LENGTH_LONG).show();

                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getContext(), String.valueOf(t.getMessage()), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        return builder.create();

    }


}
