package com.example.angelagao.app2;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by angelagao on 4/5/16.
 */
public class FragmentTab3 extends Fragment{
    private String title;
    private int page;
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
        TextView tv = (TextView) rootView.findViewById(R.id.Frag3Text);
        tv.setText("Frag3");

        //Play video
        Button buttonPlayVideo = (Button)rootView.findViewById(R.id.playvideoplayer);
        VideoView mVideoView = (VideoView) rootView.findViewById(R.id.videoView);

        String uriPath = "android.resource://" + getActivity().getPackageName() + R.raw.video1;
        Uri uri = Uri.parse(uriPath);
        try {
            mVideoView.setVideoURI(uri);
            mVideoView.setMediaController(new android.widget.MediaController(getActivity()));
            mVideoView.requestFocus();
            mVideoView.start();
        } catch (Exception e) {
            Log.e("Tag_App", Log.getStackTraceString(e));
        }
//        buttonPlayVideo.setOnClickListener(new Button.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                VideoView mVideoView = (VideoView)v.findViewById(R.id.videoView);
//
//                String uriPath = "android.resource://" + getActivity().getPackageName() + R.raw.video1;
//                Uri uri = Uri.parse(uriPath);
//                mVideoView.setVideoURI(uri);
//                mVideoView.requestFocus();
//                mVideoView.start();
//            }
//        });


        return rootView;
    }
}
