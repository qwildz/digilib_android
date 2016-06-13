package com.qwildz.digitallibrary.injector.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by resna on 2016-06-12.
 */

@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface Application {
}