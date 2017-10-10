package com.example.administrator.buttommenudemo.fragment.firstceng;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.buttommenudemo.R;
import com.example.administrator.buttommenudemo.adapter.CommonTabFragmentAdapter;
import com.example.administrator.buttommenudemo.fragment.secondceng.DiscoveryInFragment1;
import com.example.administrator.buttommenudemo.fragment.secondceng.DiscoveryInFragment2;


/**
 * Created by Administrator on 2017\10\9 0009.
 */

public class DiscoveryFragment extends Fragment {

    private ViewPager tab03_viewPager;
    private TabLayout discovery_top_tabs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab03, container, false);

        initViews(view);

        return view;
    }

    public void initViews(View view){

        tab03_viewPager = (ViewPager) view.findViewById(R.id.tab03_viewPager);
        discovery_top_tabs = (TabLayout) view.findViewById(R.id.discovery_top_tabs);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        CommonTabFragmentAdapter homePagerAdapter = new CommonTabFragmentAdapter(fm);
        homePagerAdapter.addTab(DiscoveryInFragment1.newInstance(), "消息");
        homePagerAdapter.addTab(DiscoveryInFragment2.newInstance(), "消息");
        tab03_viewPager.setAdapter(homePagerAdapter);
        tab03_viewPager.setOffscreenPageLimit(2);
        discovery_top_tabs.setupWithViewPager(tab03_viewPager);

    }
}
