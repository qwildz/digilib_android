package com.qwildz.digitallibrary.injector.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by resna on 2016-06-12.
 */
@Module
public class ThreadingModule {
    @Named("ui_thread")
    @Provides
    public Scheduler providesMainThread(){
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.newThread();
    }
}
