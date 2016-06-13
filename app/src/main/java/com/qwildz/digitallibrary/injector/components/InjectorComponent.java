package com.qwildz.digitallibrary.injector.components;

import com.qwildz.digitallibrary.MainActivity;
import com.qwildz.digitallibrary.fragments.BookListFragment;
import com.qwildz.digitallibrary.injector.scopes.Activity;

import dagger.Component;

/**
 * Created by resna on 2016-06-12.
 */
@Activity
@Component(dependencies = {BaseComponent.class})
public interface InjectorComponent {

    void inject(MainActivity activity);


    void inject(BookListFragment fragment);

}
