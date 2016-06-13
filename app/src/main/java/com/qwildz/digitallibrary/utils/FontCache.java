package com.qwildz.digitallibrary.utils;

import android.graphics.Typeface;

import com.qwildz.digitallibrary.MyApplication;

import java.util.Hashtable;

import javax.inject.Inject;

/**
 * http://stackoverflow.com/a/16902532/743891
 */
public class FontCache {

    private MyApplication context;
    private static Hashtable<String, Typeface> fontCache = new Hashtable<>();

    @Inject
    public FontCache(MyApplication context) {
        this.context = context;
    }

    public Typeface get(String name) {
        Typeface tf = fontCache.get(name);
        if(tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            }
            catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}