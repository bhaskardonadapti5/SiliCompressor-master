package com.iceteck.silicompressor;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by BDondapati on 24-08-2017.
 */

public class PlayCompressedVideoActivity extends AppCompatActivity {


    VideoView mVideoView;
    String fileName =null;

    String videoPath = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.video_activity);

        mVideoView =(VideoView)findViewById(R.id.videoView);

        Bundle extras = getIntent().getExtras();

        if (extras!=null);
        {
            fileName = extras.getString("VIDEO_PATH");

            Log.d("debug" , "compressedFilePath" + fileName);
        }

         videoPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getPackageName() + "/media/videos/" + fileName;

        mVideoView.setVideoURI(Uri.parse(videoPath));
        mVideoView.requestFocus();
        mVideoView.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        File n = new File(videoPath);

        if(n.exists())
            n.delete();
    }
}
