package com.qwildz.digitallibrary.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * https://github.com/chiuki/android-recyclerview/blob/master/app/src/main/java/com/sqisland/android/recyclerview/AutofitRecyclerView.java
 */
public class AutofitRecyclerView extends RecyclerView {
//    private GridLayoutManager manager;
//    private int columnWidth = -1;
//
//    private static final String SAVED_SUPER_STATE = "super-state";
//    private static final String SAVED_LAYOUT_MANAGER = "layout-manager-state";
//
//    private Parcelable mLayoutManagerSavedState;
//
//    public AutofitRecyclerView(Context context) {
//        super(context);
//        init(context, null);
//    }
//
//    public AutofitRecyclerView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init(context, attrs);
//    }
//
//    public AutofitRecyclerView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        init(context, attrs);
//    }
//
//    private void init(Context context, AttributeSet attrs) {
//        if (attrs != null) {
//            int[] attrsArray = {
//                    android.R.attr.columnWidth
//            };
//            TypedArray array = context.obtainStyledAttributes(attrs, attrsArray);
//            columnWidth = array.getDimensionPixelSize(0, -1);
//            array.recycle();
//        }
//
//        manager = new GridLayoutManager(getContext(), 1);
//        setLayoutManager(manager);
//    }
//
//    @Override
//    protected void onMeasure(int widthSpec, int heightSpec) {
//        super.onMeasure(widthSpec, heightSpec);
//        if (columnWidth > 0) {
//            int spanCount = Math.max(1, getMeasuredWidth() / columnWidth);
//            manager.setSpanCount(spanCount);
//        }
//    }
//
//    @Override
//    protected Parcelable onSaveInstanceState() {
//        Bundle bundle = new Bundle();
//        bundle.putParcelable(SAVED_SUPER_STATE, super.onSaveInstanceState());
//        bundle.putParcelable(SAVED_LAYOUT_MANAGER, this.getLayoutManager().onSaveInstanceState());
//        return bundle;
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Parcelable state) {
//        if (state instanceof Bundle) {
//            Bundle bundle = (Bundle) state;
//            mLayoutManagerSavedState = bundle.getParcelable(SAVED_LAYOUT_MANAGER);
//            state = bundle.getParcelable(SAVED_SUPER_STATE);
//        }
//        super.onRestoreInstanceState(state);
//    }
//
//    /**
//     * Restores scroll position after configuration change.
//     * <p>
//     * <b>NOTE:</b> Must be called after adapter has been set.
//     */
//    private void restorePosition() {
//        if (mLayoutManagerSavedState != null) {
//            this.getLayoutManager().onRestoreInstanceState(mLayoutManagerSavedState);
//            mLayoutManagerSavedState = null;
//        }
//    }
//
//    @Override
//    public void setAdapter(Adapter adapter) {
//        super.setAdapter(adapter);
//        restorePosition();
//    }

    private GridLayoutManager manager;
    private int columnWidth = -1;

    private static final String SAVED_SUPER_STATE = "super-state";
    private static final String SAVED_LAYOUT_MANAGER = "layout-manager-state";

    private Parcelable mLayoutManagerSavedState;

        public AutofitRecyclerView(Context context) {
        super(context);
        init(context, null);
    }

    public AutofitRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutofitRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] attrsArray = {
                    android.R.attr.columnWidth
            };
            TypedArray array = context.obtainStyledAttributes(attrs, attrsArray);
            columnWidth = array.getDimensionPixelSize(0, -1);
            array.recycle();
        }

        manager = new GridLayoutManager(getContext(), 1);
        setLayoutManager(manager);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (columnWidth > 0) {
            int spanCount = Math.max(1, getMeasuredWidth() / columnWidth);
            manager.setSpanCount(spanCount);
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SAVED_SUPER_STATE, super.onSaveInstanceState());
        bundle.putParcelable(SAVED_LAYOUT_MANAGER, this.getLayoutManager().onSaveInstanceState());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            mLayoutManagerSavedState = bundle.getParcelable(SAVED_LAYOUT_MANAGER);
            state = bundle.getParcelable(SAVED_SUPER_STATE);
        }
        super.onRestoreInstanceState(state);
    }

    /**
     * Restores scroll position after configuration change.
     * <p>
     * <b>NOTE:</b> Must be called after adapter has been set.
     */
    private void restorePosition() {
        if (mLayoutManagerSavedState != null) {
            this.getLayoutManager().onRestoreInstanceState(mLayoutManagerSavedState);
            mLayoutManagerSavedState = null;
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        restorePosition();
    }
}
