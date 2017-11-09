package com.lserj.bigserj;


import android.app.Application;

import com.lserj.bigserj.di.AppComponent;
import com.lserj.bigserj.di.AppModule;
import com.lserj.bigserj.di.DaggerAppComponent;

public class TestApplication extends Application{

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }
}
