package com.example.angelagao.app2;

import android.app.ProgressDialog;
import android.widget.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

/**
 * Created by angelagao on 4/5/16.
 */
public class FragmentTab3 extends Fragment{
    private String title;
    private int page;
    private VideoView mVideoView, mVideoView2;
    private ProgressDialog progressDialog;
    private MediaController mediaControlls, mediaControlls2;
    private int postion = 0;

    public static FragmentTab3 newInstance(int page, String title) {
        FragmentTab3 fragment3 = new FragmentTab3();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTile", title);
        fragment3.setArguments(args);
        return fragment3;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someString");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab3, container, false);

        //Play video - 1
        mVideoView = (VideoView) rootView.findViewById(R.id.videoView1);
        final Button buttonPlayVideo = (Button)rootView.findViewById(R.id.playvideoplayer);
        final Button buttonPauseVideo = (Button)rootView.findViewById(R.id.playvideoplayer_pause);
        String uriPath = "android.resource://" + getActivity().getPackageName() + "/"+ R.raw.video1;
        mediaControlls = new MediaController(getActivity().getApplicationContext());
        mediaControlls.setAnchorView(mVideoView);
        mediaControlls.setMediaPlayer(mVideoView);
        Uri uri = Uri.parse(uriPath);
        try {
            mVideoView.setMediaController(mediaControlls);
            mVideoView.setVideoURI(uri);
        } catch (Exception e) {
            Log.e("Tag_App", Log.getStackTraceString(e));
        }

        buttonPlayVideo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.start();
                buttonPauseVideo.setEnabled(true);
                buttonPlayVideo.setEnabled(false);
            }
        });

        buttonPauseVideo.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                mVideoView.pause();
                buttonPlayVideo.setEnabled(true);
                buttonPauseVideo.setEnabled(false);
            }
        });

        //Play video - 2
        mVideoView2 = (VideoView) rootView.findViewById(R.id.videoView2);
        final Button buttonPlayVideo2 = (Button)rootView.findViewById(R.id.playvideoplayer2);
        final Button buttonPauseVideo2 = (Button)rootView.findViewById(R.id.playvideoplayer_pause2);
        String uriPath2 = "android.resource://" + getActivity().getPackageName() + "/"+ R.raw.video2;
        mediaControlls2 = new MediaController(getActivity().getApplicationContext());
        mediaControlls2.setAnchorView(mVideoView2);
        mediaControlls2.setMediaPlayer(mVideoView2);
        Uri uri2 = Uri.parse(uriPath2);
        try {
            mVideoView2.setMediaController(mediaControlls2);
            mVideoView2.setVideoURI(uri2);
        } catch (Exception e) {
            Log.e("Tag_App", Log.getStackTraceString(e));
        }

        buttonPlayVideo2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView2.start();
                buttonPauseVideo2.setEnabled(true);
                buttonPlayVideo2.setEnabled(false);
            }
        });

        buttonPauseVideo2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                mVideoView2.pause();
                buttonPlayVideo2.setEnabled(true);
                buttonPauseVideo2.setEnabled(false);
            }
        });

        return rootView;
    }
}
