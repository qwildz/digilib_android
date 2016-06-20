/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.qwildz.digitallibrary.injector.components;

import android.content.SharedPreferences;

import com.qwildz.digitallibrary.MyApplication;
import com.qwildz.digitallibrary.injector.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    MyApplication app();

    SharedPreferences sharedPreferences();

//    @Named("ui_thread")
//    Scheduler uiThread();
//
//    @Named("executor_thread")
//    Scheduler executorThread();
}
