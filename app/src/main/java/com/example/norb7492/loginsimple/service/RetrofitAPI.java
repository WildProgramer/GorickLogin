package com.example.norb7492.loginsimple.service;

import com.example.norb7492.loginsimple.mvc.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by Norb7492 on 10/01/2017.
 */

public interface RetrofitAPI {


    @Headers( "Content-Type: application/json" )
    @POST("users-api/")
    Call<UserModel> getUser(@Body UserModel userModel);
}
