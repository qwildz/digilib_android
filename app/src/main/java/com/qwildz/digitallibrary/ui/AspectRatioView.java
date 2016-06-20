package com.qwildz.digitallibrary.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.qwildz.digitallibrary.R;

/**
 * Created by resna on 2016-06-13.
 */
public interface AspectRatioView {
    // NOTE: These must be kept in sync with the AspectRatioImageView attributes in attrs.xml.
    int MEASUREMENT_WIDTH = 0;
    int MEASUREMENT_HEIGHT = 1;

    float DEFAULT_ASPECT_RATIO = 1f;
    boolean DEFAULT_ASPECT_RATIO_ENABLED = false;
    int DEFAULT_DOMINANT_MEASUREMENT = MEASUREMENT_WIDTH;

    /**
     * Get the aspect ratio for this image view.
     */
    float getAspectRatio();

    /**
     * Set the aspect ratio for this image view. This will update the view instantly.
     */
    void setAspectRatio(float aspectRatio);

    /**
     * Get whether or not forcing the aspect ratio is enabled.
     */
    boolean getAspectRatioEnabled();

    /**
     * set whether or not forcing the aspect ratio is enabled. This will re-layout the view.
     */
    void setAspectRatioEnabled(boolean aspectRatioEnabled);

    /**
     * Get the dominant measurement for the aspect ratio.
     */
    int getDominantMeasurement();

    /**
     * Set the dominant measurement for the aspect ratio.
     *
     * @see #MEASUREMENT_WIDTH
     * @see #MEASUREMENT_HEIGHT
     */
    void setDominantMeasurement(int dominantMeasurement);
}
