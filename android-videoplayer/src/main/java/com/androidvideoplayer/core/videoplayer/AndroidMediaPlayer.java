package com.androidvideoplayer.core.videoplayer;

import android.media.MediaPlayer;

import com.androidvideoplayer.core.model.VideoModel;

import java.util.ArrayList;

/**
 * Created by wayne on 12/5/15.
 *
 * This class will return the media player of the android system with cache preload
 */
public class AndroidMediaPlayer {

    private String[] videolistStr;

    private ArrayList<VideoModel> videoList;

    private MediaPlayer currentPlayer;

    private MediaPlayer nextPlayer;

    private int currentIndex;

    public AndroidMediaPlayer(){

    }

    public void setVideos(String[] videolistStr){

    }

    public void setVideos(ArrayList<VideoModel> videoList){
        this.videoList = videoList;
    }

    public void playVideos(){

    }

    public void playVideosAsync(){

    }

    public void playNextVideo(){

    }

    public int getCurrentIndex(){
        return currentIndex;
    }

    public MediaPlayer getCurrentPlayer(){
        return currentPlayer;
    }

    public MediaPlayer getNextPlayer(){
        return nextPlayer;
    }
}
