package com.androidvideoplayer.core.base;

import com.androidvideoplayer.core.util.VideoLog;

/**
 * Created by wayne on 12/6/15.
 */
public class BaseVideoPlayer {
    /**
     * log message
     * @param msg message
     */
    protected void logV(String msg){
        VideoLog.logV(this.getClass(), msg);
    }

    /**
     * log error
     * @param msg message
     */
    protected void logE(String msg){
        VideoLog.logE(this.getClass(), msg);
    }
}
