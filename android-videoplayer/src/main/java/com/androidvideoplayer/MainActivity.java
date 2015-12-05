package com.androidvideoplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidvideoplayer.impl.activity.ExampleMPActivity;

/**
 * This is the launcher activity of the project
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, ExampleMPActivity.class);
        startActivity(intent);
    }
}
