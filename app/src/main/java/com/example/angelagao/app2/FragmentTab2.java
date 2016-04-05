package com.example.angelagao.app2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class FragmentTab2 extends Fragment {
    private String title;
    private int page;

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
        return rootView;
    }
}
