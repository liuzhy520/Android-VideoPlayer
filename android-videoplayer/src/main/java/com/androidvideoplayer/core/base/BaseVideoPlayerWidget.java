package com.androidvideoplayer.core.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by wayne on 12/5/15.
 */
public abstract  class BaseVideoPlayerWidget extends RelativeLayout implements BasePlayer{

    public BaseVideoPlayerWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
