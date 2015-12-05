package com.androidvideoplayer.core.model;

/**
 * Created by wayne on 12/5/15.
 *
 * This is the Model object of the video which contains the basic information of the video
 */
public class VideoModel {

    // the url of the video content
    public String url;

    // the length of the video
    public int duration;

    // the start position that user wish to play
    public int startPosition;

    // the end position that user wish to play
    public int endPosition;

    // the title of the video
    public String title;

    // the description of the video
    public String description;
}
