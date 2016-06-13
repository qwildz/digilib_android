package com.qwildz.digitallibrary;

import android.app.Application;

import com.qwildz.digitallibrary.injector.components.AppComponent;
import com.qwildz.digitallibrary.injector.components.BaseComponent;
import com.qwildz.digitallibrary.injector.components.DaggerAppComponent;
import com.qwildz.digitallibrary.injector.components.DaggerBaseComponent;
import com.qwildz.digitallibrary.injector.modules.AppModule;
import com.qwildz.digitallibrary.injector.modules.NetworkModule;
import com.qwildz.digitallibrary.models.Repository;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * Created by resna on 2016-06-06.
 */
public class MyApplication extends Application {

    private BaseComponent mBaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            LeakCanary.install(this);
        }


        AppComponent applicationComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();

        mBaseComponent = DaggerBaseComponent.builder()
                .appComponent(applicationComponent)
                .networkModule(new NetworkModule(Repository.END_POINT))
                .build();
    }

    public BaseComponent getBaseComponent() {
        return mBaseComponent;
    }

}
