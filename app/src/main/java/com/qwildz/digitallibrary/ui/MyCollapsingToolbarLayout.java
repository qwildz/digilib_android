package com.qwildz.digitallibrary.ui;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;
import android.view.ViewParent;

/**
 * Created by resna on 2016-06-14.
 */
public class MyCollapsingToolbarLayout extends CollapsingToolbarLayout {

    private boolean forced = false;

    public MyCollapsingToolbarLayout(Context context) {
        super(context);
    }

    public MyCollapsingToolbarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public void setScrimsShown(boolean show) {
        if(forced)
            super.setScrimsShown(show);
    }

    @Override
    public void setScrimsShown(boolean show, boolean animate) {
        if(forced)
            super.setScrimsShown(show, animate);
    }

    public synchronized void setForceScrimsShown(boolean show) {
        forced = true;
        setScrimsShown(show);
        forced = false;
    }

    public synchronized void setForceScrimsShown(boolean show, boolean animate) {
        forced = true;
        setScrimsShown(show, animate);
        forced = false;
    }
}
