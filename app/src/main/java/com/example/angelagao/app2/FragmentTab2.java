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
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class FragmentTab2 extends Fragment {
    private String title;
    private int page;
    private Button b1,b2,b3,b4;
    MediaPlayer m = new MediaPlayer();

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
        TextView tv = (TextView) rootView.findViewById(R.id.Frag2Text);
        tv.setText("Frag2");

        b1 = (Button) rootView.findViewById(R.id.button);
        b2 = (Button) rootView.findViewById(R.id.button2);
        b3=(Button) rootView.findViewById(R.id.button3);
        b4=(Button)rootView.findViewById(R.id.button4);

        try{
            AssetFileDescriptor descriptor = getActivity().getApplicationContext().getAssets().openFd("Audio1.mp3");
            m.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(),descriptor.getLength());
            descriptor.close();
        } catch (Exception e){
            Log.e("Tag_App", Log.getStackTraceString(e));
        }

        b2.setEnabled(false);

        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
                try {
                    m.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                m.start();

                b2.setEnabled(true);
                b3.setEnabled(false);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Pausing sound",Toast.LENGTH_SHORT).show();
                m.pause();
                b2.setEnabled(false);
                b3.setEnabled(true);
            }
        });


//        try {
//            m.prepare();
//            m.start();
//            Log.e("Tag_App", "audio1 start to play....");
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return rootView;
    }
}
