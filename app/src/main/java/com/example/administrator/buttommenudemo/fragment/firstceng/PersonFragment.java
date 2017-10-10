package com.example.administrator.buttommenudemo.fragment.firstceng;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.buttommenudemo.R;


/**
 * Created by Administrator on 2017\10\9 0009.
 */

public class PersonFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab04, container, false);

        return view;
    }
}
