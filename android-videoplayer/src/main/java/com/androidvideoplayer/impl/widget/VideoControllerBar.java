package com.androidvideoplayer.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.androidvideoplayer.R;
import com.androidvideoplayer.core.widget.VideoController;

/**
 * Created by wayne on 12/5/15.
 */
public class VideoControllerBar extends VideoController {

    private TextView playBtn;
    private boolean isPlaying;

    public VideoControllerBar(Context context){
        super(context);
    }

    public VideoControllerBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void checkPlayBtn(boolean isPlaying){
        try{
            this.isPlaying = isPlaying;
            if(isPlaying)
                playBtn.setText("Pause");
            else
                playBtn.setText("Play");
        }catch (Exception e){e.getStackTrace();}

    }

    public void updateTimer(int position){

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.video_controller_bar_layout);
        playBtn = (TextView) findViewById(R.id.video_controller_play_btn);
    }

    @Override
    protected void setViews() {
        playBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying)
                    pause();
                else
                    start();
            }
        });
    }

    @Override
    protected void updateController(int position, int duration, boolean isPlaying) {
        
    }
}
