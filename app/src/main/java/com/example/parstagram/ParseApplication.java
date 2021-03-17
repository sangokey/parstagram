package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("RlMlE58blpULbAkb6qtXEk7n2HODYzsTbVrxXxwq")
                .clientKey("DrJAlF5MJiNufKCu7BndrVW1W9YAF92xaIndwT1y")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
