package com.example.angelagao.app2;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;


public class FragmentTab2 extends Fragment {
    private String title;
    private int page;
    private Button pauseBtn_1, playBtn_1, pauseBtn_2, playBtn_2;
    MediaPlayer mediaplayer_1 = new MediaPlayer();
    MediaPlayer mediaplayer_2 = new MediaPlayer();

    public static FragmentTab2 newInstance(int page, String title) {
        FragmentTab2 fragment2 = new FragmentTab2();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTile", title);
        fragment2.setArguments(args);
        return fragment2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someString");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab2, container, false);
//        TextView tv = (TextView) rootView.findViewById(R.id.Frag2Text);
//        tv.setText("Frag2");

        //Audio 1 Play
        pauseBtn_1 = (Button) rootView.findViewById(R.id.pause_1);
        playBtn_1 =(Button) rootView.findViewById(R.id.play_1);
        try{
            AssetFileDescriptor descriptor = getActivity().getApplicationContext().getAssets().openFd("Audio1.mp3");
            mediaplayer_1.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();
        } catch (Exception e){
            Log.e("Tag_App", Log.getStackTraceString(e));
        }
        pauseBtn_1.setEnabled(false);

        playBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
                try {
                    mediaplayer_1.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaplayer_1.start();

                pauseBtn_1.setEnabled(true);
                playBtn_1.setEnabled(false);
            }
        });

        pauseBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
                mediaplayer_1.pause();
                pauseBtn_1.setEnabled(false);
                playBtn_1.setEnabled(true);
            }
        });


        //Audio 2 play
        pauseBtn_2 = (Button) rootView.findViewById(R.id.pause_2);
        playBtn_2 =(Button) rootView.findViewById(R.id.play_2);
        try{
            AssetFileDescriptor descriptor = getActivity().getApplicationContext().getAssets().openFd("Audio2.mp3");
            mediaplayer_2.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();
        } catch (Exception e){
            Log.e("Tag_App", Log.getStackTraceString(e));
        }

        pauseBtn_2.setEnabled(false);

        playBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Playing sound 2", Toast.LENGTH_SHORT).show();
                try {
                    mediaplayer_2.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaplayer_2.start();

                pauseBtn_2.setEnabled(true);
                playBtn_2.setEnabled(false);
            }
        });

        pauseBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
                mediaplayer_2.pause();
                pauseBtn_2.setEnabled(false);
                playBtn_2.setEnabled(true);
            }
        });

        return rootView;
    }
}
