package com.androidvideoplayer.impl.widget;

import android.content.Context;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.androidvideoplayer.core.base.BasePlayerView;
import com.androidvideoplayer.core.model.VideoInfo;
import com.androidvideoplayer.core.widget.VideoController;

import java.util.ArrayList;

/**
 * Created by wayne on 12/5/15.
 */
public class SingleVideoPlayerWidget extends BasePlayerView {

    public SingleVideoPlayerWidget(Context context){
        super(context);
    }

    public SingleVideoPlayerWidget(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void init() {

    }

    @Override
    public void setDisplay(ArrayList<VideoInfo> list) {

    }

    @Override
    public void playVideos(ArrayList<VideoInfo> path) {

    }

    @Override
    public void playVideosAsync(ArrayList<VideoInfo> path) {

    }

    @Override
    public void resumeMainContent(int position, SurfaceHolder surfaceHolder) {

    }

    @Override
    public void fixLandscapeUI() {

    }

    @Override
    public void fixPortraitUI() {

    }

    @Override
    public void onVideoChanged() {

    }

    @Override
    public void onVideoFinished() {

    }

    @Override
    protected void getVideoResolution() {

    }

    @Override
    protected void loadNextVideo() {

    }

    @Override
    protected SurfaceView setSurfaceView() {
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void release() {

    }

    @Override
    public void seekTo(int position) {

    }

    @Override
    public int getCurrentVideoPosition() {
        return 0;
    }

    @Override
    public int getCurrentVideoDuration() {
        return 0;
    }

    @Override
    public boolean isVideoPlaying() {
        return false;
    }
}
