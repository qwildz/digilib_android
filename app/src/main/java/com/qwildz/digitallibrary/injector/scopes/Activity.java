package com.qwildz.digitallibrary.injector.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by resna on 2016-06-11.
 */
@Scope
@Retention(RUNTIME)
public @interface Activity {}
