package com.androidvideoplayer.core.util;

import android.util.Log;

/**
 * Created by wayne on 12/5/15.
 */
public class VideoLog {

    /**
     * this will print the verbose message in the logcat
     * @param cls the class
     * @param message log message
     */
    public static void logV(Class cls, String message){

        if(cls != null)
            Log.v(cls.getSimpleName(), ">>>>>>" + message);
        else
            Log.v("AndroidVideoPlayer", ">>>>>>" + message);

    }

    /**
     * this will print the error in the logcat
     * @param cls the class
     * @param message log message
     */
    public static void logE(Class cls, String message){

        if(cls != null)
            Log.e(cls.getSimpleName(), ">>>>>>" + message);
        else
            Log.e("AndroidVideoPlayer", ">>>>>>" + message);

    }
}
