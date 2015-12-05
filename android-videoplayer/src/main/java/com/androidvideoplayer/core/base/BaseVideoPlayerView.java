package com.androidvideoplayer.core.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.androidvideoplayer.core.model.VideoInfo;
import com.androidvideoplayer.core.util.VideoLog;

import java.util.ArrayList;

/**
 * Created by wayne on 12/5/15.
 *
 */
public abstract class BaseVideoPlayerView extends RelativeLayout implements BasePlayer{

    protected Context context;

    // widgets
    protected RelativeLayout parentView;
    protected SurfaceView surfaceView;
    protected SurfaceHolder surfaceHolder;

    // values
    protected int videoWidth;
    protected int videoHeight;
    protected boolean isScreenLocked = false;
    protected boolean isLandscape = false;
    protected boolean isFullScreenClick = false;

    // data
    protected VideoInfo currentVideoInfo;


    public BaseVideoPlayerView(Context context){
        super(context);
    }

    public BaseVideoPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /** get is landscape **/
    public boolean getIsLandscapeStatus(){ return isLandscape;}

    /** set Screen Lock **/
    public void setScreenLock(boolean isLocked){
        this.isScreenLocked = isLocked;
    }

    public boolean getIsScreenLocked(){ return this.isScreenLocked;}


    /** get the information of the current video **/
    public VideoInfo getVideoInfo(){
        return currentVideoInfo;
    }

    /** this is a method for full screen button **/
    public void setFullScreenSwitcher(){

        if(!isScreenLocked){
            if(isLandscape){
                ((Activity)context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                isLandscape = false;
                fixPLViews();
            }else {
                ((Activity)context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                isFullScreenClick = true;
                isLandscape = true;
                fixPLViews();
            }

        }



        /** 重力感应 **/
//        if(isLandscape){
//            ((Activity)context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//
//        }else {
//            ((Activity)context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//            isFullScreenClick = true;
//        }
    }

    public boolean isLandscape() {
        return isLandscape;
    }

    /** fix screen size in P/L position **/
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        fixPLViews();
    }

    public void fixPLViews(){
        surfaceView = setSurfaceView();
        if(surfaceView == null){
            logE("The SurfaceView has not set yet, please use setSurfaceView() to return the correct one");
            return;
        }
        surfaceHolder = surfaceView.getHolder();
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenH = dm.heightPixels;
        int screenW = dm.widthPixels;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.surfaceView.getLayoutParams();
        LinearLayout.LayoutParams parentParam = (LinearLayout.LayoutParams) this.parentView.getLayoutParams();
//        if(isLoaded){
        getVideoResolution();
        if(screenH > screenW){  // portrait
            try {
                /** video view **/
                if(this.videoWidth !=0){
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.height = screenW * this.videoHeight / this.videoWidth;
                    this.surfaceView.setLayoutParams(params);
                }
                /** back to normal screen **/
                ((Activity)context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                ((Activity)context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

            logV("portrait");
            }catch (Exception e){e.printStackTrace();}
            fixPortraitUI();

        }else if(screenH < screenW){  // landscape
            try{
                /** video view **/
                if(this.videoHeight != 0){
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    params.width = screenH * this.videoWidth / this.videoHeight;
                    params.alignWithParent = true;
                    this.surfaceView.setLayoutParams(params);
                }
                /** full screen with correct video definition **/
                ((Activity)context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                ((Activity)context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

            logV("landscape");
            }catch (Exception e){e.printStackTrace();}
            fixLandscapeUI();

        }
        try {
            this.surfaceHolder.setFixedSize(this.videoWidth, this.videoHeight);
        }catch (Exception e) {e.printStackTrace();}
//        }


    }

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

    /**
     * initialize the views
     */
    protected abstract void init();


    /**
     * display the video
     * @param list the video list
     */
    public abstract void setDisplay(final ArrayList<VideoInfo> list);


    /** two different modes in playing videos **/
    public abstract void playVideos(final ArrayList<VideoInfo> path);

    public abstract void playVideosAsync(final ArrayList<VideoInfo> path);

    /**
     * resume main content
     * @param position the position on pause
     * @param surfaceHolder SurfaceHolder
     */
    public abstract void resumeMainContent(int position, SurfaceHolder surfaceHolder);

    /** fix UI here **/
    public abstract void fixLandscapeUI();

    public abstract void fixPortraitUI();

    /** do something in here when the video changed **/
    public abstract void onVideoChanged();

    /** do something in here when the video is finished **/
    public abstract void onVideoFinished();

    /** get the screen height & screen width from the player display **/
    protected abstract void getVideoResolution();

    /** to load the next video **/
    protected abstract void loadNextVideo();

    /**
     * set the SurfaceView in here
     * @return SurfaceView
     */
    protected abstract SurfaceView setSurfaceView();
}
