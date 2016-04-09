package com.example.angelagao.app2;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class FragmentTab1 extends Fragment {
    private String title;
    private int page;

    public static FragmentTab1 newInstance(int page, String title) {
        FragmentTab1 fragmentFirst = new FragmentTab1();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTile", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someString");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab1, container, false);
        TextView tv = (TextView) rootView.findViewById(R.id.tvFragFirst);

        ImageView mImage = (ImageView)rootView.findViewById(R.id.homePhoto);

        try {
            InputStream ims = getActivity().getApplicationContext().getAssets().open("homepic.jpg");
            Drawable d = Drawable.createFromStream(ims, null);
            mImage.setImageDrawable(d);
        } catch (IOException e) {
            Log.e("Tag_App", Log.getStackTraceString(e));
        }


        return rootView;
    }


}
