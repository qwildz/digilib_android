/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.qwildz.digitallibrary.injector.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.qwildz.digitallibrary.MyApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class AppModule {
    private final MyApplication application;
    private String PREF_NAME = "prefs";

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext() {
        return application;
    }

    @Singleton
    @Provides
    public SharedPreferences getAppPreferences() {
        return application.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
}
