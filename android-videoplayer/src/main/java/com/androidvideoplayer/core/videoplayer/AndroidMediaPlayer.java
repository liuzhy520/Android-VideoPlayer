package com.androidvideoplayer.core.videoplayer;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.androidvideoplayer.core.base.BasePlayer;
import com.androidvideoplayer.core.base.BaseVideoPlayer;
import com.androidvideoplayer.core.model.VideoInfo;
import com.androidvideoplayer.core.util.VideoLog;

import java.util.ArrayList;

/**
 * Created by wayne on 12/5/15.
 *
 * This class will return the media player of the android system with cache preload
 */
public class AndroidMediaPlayer extends BaseVideoPlayer implements BasePlayer{

    private ArrayList<VideoInfo> videoList;

    private MediaPlayer currentPlayer;

    private MediaPlayer nextPlayer;

    private int currentIndex;

    private boolean isNextPrepared;

    private SurfaceHolder surfaceHolder;

    private OnLastVideoCompleteListener onLastComplete;

    public AndroidMediaPlayer(SurfaceView surfaceView){

        if(surfaceView == null){
            logE("The SurfaceView has not set yet, please use setSurfaceView() to return the correct one");
            return;
        }
        
        videoList = new ArrayList<>();
        currentPlayer = new MediaPlayer();
        nextPlayer = new MediaPlayer();
        currentIndex = 0;
        isNextPrepared = false;
        surfaceHolder = surfaceView.getHolder();
    }

    /**
     * set the video list into the player
     * @param videoList the video list
     * @param startIndex the index of the list that start to play
     */
    public void setVideos(ArrayList<VideoInfo> videoList, int startIndex){
        this.videoList = videoList;
        currentIndex = startIndex;
    }

    /**
     * play the videos list from input
     * @param onPrepared return if the current player is prepared
     * @param onCompleted return if the current player is completed
     */
    public void playVideos(MediaPlayer.OnPreparedListener onPrepared, MediaPlayer.OnCompletionListener onCompleted){

    }

    /**
     * play the video list with async preparation
     * @param onPrepared return if the current player is prepared
     * @param onCompleted return if the current player is completed
     */
    public void playVideosAsync(MediaPlayer.OnPreparedListener onPrepared, MediaPlayer.OnCompletionListener onCompleted){

    }

    /**
     * play the next video when the current one is playing or preparing
     * @param onPrepared return if the current player is prepared
     * @param onCompleted return if the current player is completed
     */
    public void playNextVideo(MediaPlayer.OnPreparedListener onPrepared, MediaPlayer.OnCompletionListener onCompleted){
        if(currentIndex >= videoList.size() - 1){
            if(onLastComplete != null){
                onLastComplete.onLastVideoCompleted();
            }
            return;
        }

        currentPlayer = nextPlayer;
    }

    /**
     * return the index of the current video in the list
     * @return current index
     */
    public int getCurrentIndex(){
        return currentIndex;
    }

    /**
     * return the current media player
     * @return MediaPlayer
     */
    public MediaPlayer getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * return the next media player
     * @return MediaPlayer
     */
    public MediaPlayer getNextPlayer(){
        return nextPlayer;
    }

    /**
     * get the video info model of the current index of the list
     * @return VideoInfo
     */
    public VideoInfo getCurrentVideoInfo(){
        return videoList.get(currentIndex);
    }

    /**
     * the OnLastVideoCompleteListener can be set in here
     * @param listener OnLastVideoCompleteListener
     */
    public void setOnLastVideoCompleteListener(OnLastVideoCompleteListener listener){
        onLastComplete = listener;
    }

    @Override
    public void start() {

        try {
            currentPlayer.start();
            logV("start!");
        }catch (Exception e){e.getStackTrace();}
    }

    @Override
    public void pause() {

        try {
            if(currentPlayer.isPlaying()){
                currentPlayer.pause();
                logV("pause!");
            }
        }catch (Exception e){e.getStackTrace();}
    }

    @Override
    public void stop() {

        try {
            if(currentPlayer.isPlaying()){
                currentPlayer.stop();
                logV("stop!");
            }
        }catch (Exception e){e.getStackTrace();}
    }

    @Override
    public void release() {

        try {
            currentPlayer.release();
            nextPlayer.release();
        }catch (Exception e){e.printStackTrace();}

        currentPlayer = null;
        nextPlayer = null;

        logV("released!");
    }

    @Override
    public void seekTo(int position) {

        try{
            currentPlayer.seekTo(position);
            logV("seek to" + position);
        }catch (Exception e){e.getStackTrace();}

    }

    @Override
    public int getCurrentVideoPosition() {
        try{
            if(currentPlayer.isPlaying()){
                return currentPlayer.getCurrentPosition();
            }else
                return 0;
        }catch (Exception e){e.getStackTrace();}
        return 0;
    }

    @Override
    public int getCurrentVideoDuration() {

        try {
            int duration = currentPlayer.getDuration();
            logV("duration :" + duration);
            return duration;
        }catch (Exception e){e.getStackTrace();}
        return 0;
    }

    @Override
    public boolean isVideoPlaying() {
        try {
            return currentPlayer.isPlaying();
        }catch (Exception e){e.getStackTrace();}
        return false;
    }


    public interface OnLastVideoCompleteListener{
        void onLastVideoCompleted();
    }


}
