package com.example.angelagao.app2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends ActionBarActivity {
//    ActionBar.Tab Tab1, Tab2, Tab3;
//    android.support.v4.app.Fragment fragmentTab1 = new FragmentTab1();
//    Fragment fragmentTab2 = new FragmentTab2();
    FragmentPagerAdapter adapterViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Songs"));
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));
        tabLayout.addTab(tabLayout.newTab().setText("Wallpapers"));
        tabLayout.addTab(tabLayout.newTab().setText("AddMe!"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
            private static int NUM_ITEMS = 5;
//        private String[] titles = {"Item 1", "Item 2", "Item 3" };

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FragmentTab1.newInstance(0, "Page # 1");
                case 1:
                    return FragmentTab2.newInstance(1, "page # 2");
                case 2:
                    return FragmentTab3.newInstance(2, "page # 3");
                case 3:
                    return FragmentTab4.newInstance(3, "page # 4");
                case 4:
                    return FragmentTab5.newInstance(4, "page # 5");
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
}
