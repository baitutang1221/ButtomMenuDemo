package com.example.administrator.buttommenudemo.fragment.firstceng;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.buttommenudemo.R;
import com.example.administrator.buttommenudemo.fragment.secondceng.WechatInFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017\10\9 0009.
 */

public class WechatFragment extends Fragment {

    public static final String[] tabTitle =
            new String[]{"综艺", "体育", "新闻", "热点", "头条", "军事", "历史", "科技", "人文", "地理"};

    private TabLayout tab;
    private ViewPager viewpager;
    private TabAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab01, container, false);

//        ViewPager vp = (ViewPager) view.findViewById(R.id.main_vp);
//
//        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.main_tab_layout);
//
//        List<String> list = new ArrayList<>();
//        for (int i = 1; i < 5; i++) {
//            list.add("第"+i+"页");
//        }
//        vp.setAdapter(new MyAdapter(getFragmentManager(),list));
//
//        tabLayout.setupWithViewPager(vp);

        initviews(view);

        return view;
    }

//    public class MyAdapter extends FragmentPagerAdapter {
//        private List<String> list;
//
//        public MyAdapter(FragmentManager fm, List<String> list) {
//            super(fm);
//            this.list = list;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return WechatInFragment.newInstance(list.get(position));
//        }
//
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return list.get(position);
//        }
//    }

    private void initviews(View view) {
        tab = (TabLayout) view.findViewById(R.id.main_tab_layout);
        viewpager = (ViewPager) view.findViewById(R.id.main_vp);

        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < tabTitle.length; i++) {
            fragments.add(WechatInFragment.newInstance(i + 1));
        }
        adapter = new TabAdapter(getFragmentManager(), fragments);
        //给ViewPager设置适配器
        viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来。
        tab.setupWithViewPager(viewpager);
        //设置可以滑动
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    public class TabAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;

        public TabAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        //设置tablayout标题
        @Override
        public CharSequence getPageTitle(int position) {
            return WechatFragment.tabTitle[position];

        }
    }
}
