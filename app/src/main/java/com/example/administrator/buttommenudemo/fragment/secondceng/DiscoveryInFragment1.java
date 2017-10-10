package com.example.administrator.buttommenudemo.fragment.secondceng;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.administrator.buttommenudemo.R;


/**
 * Created by Administrator on 2017\10\9 0009.
 */

public class DiscoveryInFragment1 extends Fragment {

    private DiscoveryInFragment1 fragment;

    public static DiscoveryInFragment1 newInstance() {
        DiscoveryInFragment1 fragment = new DiscoveryInFragment1();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discovery_in_fragment1, container, false);

//        initView(view);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void initView(View view){
//        for (int i = 0, j = list.size(); i < j; i++) {
////    ......
//            View functionView = new View(getContext());
//            functionView.setBackgroundResource(iconResId);
////    ......
//            //使用Spec定义子控件的位置和比重
//            GridLayout.Spec rowSpec = GridLayout.spec(i / 3, 1f);
//            GridLayout.Spec columnSpec = GridLayout.spec(i % 3, 1f);
//            //将Spec传入GridLayout.LayoutParams并设置宽高为0，必须设置宽高，否则视图异常
//            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, columnSpec);
//            layoutParams.height = 0;
//            layoutParams.width = 0;
//            //还可以根据位置动态定义子控件直接的边距，下面的意思是
//            //第一行的子控件都有2dp的bottomMargin，中间位置的子控件都有2dp的leftMargin和rightMargin
//            if (i / 3 == 0)
//                layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.dp_2);
//            if (i % 3 == 1) {
//                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.dp_2);
//                layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_2);
//            }
//            functionGrid.addView(functionView, layoutParams);
//        }
    }
}
