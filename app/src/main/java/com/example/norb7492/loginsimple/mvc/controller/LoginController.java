package com.example.norb7492.loginsimple.mvc.controller;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.norb7492.loginsimple.APIUrl.APIUrl;
import com.example.norb7492.loginsimple.R;
import com.example.norb7492.loginsimple.mvc.model.UserModel;
import com.example.norb7492.loginsimple.mvc.view.LoginActivity;
import com.example.norb7492.loginsimple.service.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Norb7492 on 10/01/2017.
 */

public class LoginController {


    Context ctx;

    public LoginController(Context ctx) {
        this.ctx = ctx;
    }

    public void signInUser(EditText editTextEmail, EditText getEditTextPassword){

        UserModel userModel = new UserModel();

        userModel.setEmail(editTextEmail.getText().toString());
        userModel.setPassword(getEditTextPassword.getText().toString());
        if(TextUtils.isEmpty(userModel.getEmail()) || TextUtils.isEmpty(userModel.getPassword())){

            Toast.makeText(ctx, R.string.enter_fields, Toast.LENGTH_SHORT).show();

            return;
        }else{

            retrofitGetUser(userModel);
        }

    }


    public void retrofitGetUser(UserModel userModel){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);



        Call<UserModel> call = retrofitAPI.getUser(userModel);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                try {
                    UserModel user = response.body();
                    Log.d("RetrofitResponse", String.valueOf(user.getId()));
                    Log.d("RetrofitResponse", user.getName());
                    Log.d("RetrofitResponse", user.getEmail());
                    Log.d("RetrofitResponse", user.getPassword());
                }catch (Exception e){

                    Toast.makeText(ctx, R.string.username_password_false, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

                Log.d("RetrofitError", String.valueOf(t));
            }
        });

    }


}
