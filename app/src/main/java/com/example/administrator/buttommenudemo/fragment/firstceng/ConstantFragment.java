package com.example.administrator.buttommenudemo.fragment.firstceng;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.buttommenudemo.R;
import com.example.administrator.buttommenudemo.fragment.secondceng.ConstantInFragment;


/**
 * Created by Administrator on 2017\10\9 0009.
 */

public class ConstantFragment extends Fragment implements AdapterView.OnItemClickListener{

    private String[] strs = { "常用分类", "服饰内衣", "鞋靴", "手机", "家用电器", "数码", "电脑办公",
            "个护化妆", "图书" ,"aaaa","bbbb","vvvv","rrrr"};

    private ListView listView;
    private MyAdapter adapter;
    private ConstantInFragment myFragment;
    public static int mPosition;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab02, container, false);

        initView(view);

        return view;
    }

    /**
     * 初始化view
     */
    private void initView(View view) {
        // TODO Auto-generated method stub
        listView = (ListView) view.findViewById(R.id.listview);

        adapter = new MyAdapter(getActivity(), strs);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        //创建MyFragment对象
        myFragment = new ConstantInFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, myFragment);
        //通过bundle传值给MyFragment
        Bundle bundle = new Bundle();
        bundle.putString(ConstantInFragment.TAG, strs[mPosition]);
        myFragment.setArguments(bundle);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        //拿到当前位置
        mPosition = position;
        //即使刷新adapter
        adapter.notifyDataSetChanged();
        for (int i = 0; i < strs.length; i++) {
            myFragment = new ConstantInFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, myFragment);
            Bundle bundle = new Bundle();
            bundle.putString(ConstantInFragment.TAG, strs[position]);
            myFragment.setArguments(bundle);
            fragmentTransaction.commit();
        }
    }

    public class MyAdapter extends BaseAdapter {

        private Context context;
        private String[] strings;
        public int mPosition;

        public MyAdapter(Context context, String[] strings){
            this.context =context;
            this.strings = strings;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return strings.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return strings[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            convertView = LayoutInflater.from(context).inflate(R.layout.constant_listview_item, null);
            TextView tv = (TextView) convertView.findViewById(R.id.tv);
            mPosition = position;
            tv.setText(strings[position]);
            tv.setTextColor(Color.BLACK);
            if (position == ConstantFragment.mPosition) {
                convertView.setBackgroundResource(R.drawable.tongcheng_all_bg01);
            } else {
                convertView.setBackgroundColor(Color.parseColor("#f4f4f4"));
            }
            return convertView;
        }
    }

}
