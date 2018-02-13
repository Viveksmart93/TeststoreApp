package com.teststoreapp;

import android.content.Context;
import android.util.AttributeSet;

import com.daimajia.slider.library.SliderLayout;

/**
 * Created by HP on 1/24/2018.
 */

public class SquareSlider extends SliderLayout {
    public SquareSlider(Context context) {
        super(context);
    }

    public SquareSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareSlider(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, (int)((widthMeasureSpec*3f)/4f));
    }
}
