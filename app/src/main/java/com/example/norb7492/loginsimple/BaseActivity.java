package com.example.norb7492.loginsimple;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.norb7492.loginsimple.mvc.controller.LoginController;

/**
 * Created by Norb7492 on 10/01/2017.
 */

public class BaseActivity extends AppCompatActivity {

    //Instanciate Controllers
    protected LoginController loginController;



    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


    }



}
