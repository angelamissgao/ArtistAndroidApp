package com.example.angelagao.app2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by angelagao on 4/5/16.
 */
public class FragmentTab5 extends Fragment {
    private String title;
    private int page;
    public static FragmentTab5 newInstance(int page, String title) {
        FragmentTab5 fragment5 = new FragmentTab5();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTile", title);
        fragment5.setArguments(args);
        return fragment5;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someString");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab5, container, false);
        TextView tv = (TextView) rootView.findViewById(R.id.Frag5Text);
        tv.setText("Frag5");
        return rootView;
    }
}
