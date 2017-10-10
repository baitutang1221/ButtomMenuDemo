package com.example.administrator.buttommenudemo.fragment.secondceng;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.buttommenudemo.R;
import com.example.administrator.buttommenudemo.adapter.ConstantAdapter;
import com.example.administrator.buttommenudemo.bean.ConstantMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017\10\9 0009.
 */

public class ConstantInFragment extends Fragment implements AbsListView.OnScrollListener{

    public static final String TAG = "ConstantInFragment";
    private String str;

    private int totalCount;// 数据总条数
    List<ConstantMessage> beanList = new ArrayList<>();
    private View view_more;
    private ProgressBar pb;
    private TextView tvLoad;
    private int lastVisibleIndex;
    private TextView tv_title;
    private ListView listView;
    private int start;
    private int end;
    private ConstantAdapter adapter = null;


    // 创建handler接收消息并处理消息
    private Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    // 设置adapter
                    adapter = new ConstantAdapter(beanList, getActivity());
                    listView.setAdapter(adapter);
                    // 添加底部加载布局
                    listView.addFooterView(view_more);
                    // 设置监听
                    setListeners();
                    break;
                case 1:
                    adapter.notifyDataSetChanged();
                    break;
            }
        };
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.constant_in_fragment, null);

        // 控件初始化
        initViews(view);
        // 初始化数据
        initData();

        return view;
    }

    private void initData() {
        // 模拟网络请求获取数据，一次获取15条
        new Thread() {
            public void run() {
                try {
                    totalCount = 100;// 假设数据一共有100条，将来调接口可以获取到这个值
                    for (int i = 1; i <= 20; i++) {
                        beanList.add(new ConstantMessage(R.mipmap.ic_launcher, "Title" + i, "Content" + i));
                    }
                    // 给handler发消息更新UI，子线程不可以更新UI
                    Message message = new Message();
                    message.what = 0;
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.start();
    }

    private void setListeners() {
        if (totalCount > 15) {
            // listView设置滑动简监听
            listView.setOnScrollListener(this);
        } else {
            // 假如数据总数少于等于15条，直接移除底部的加载布局，不需要再加载更多的数据
            listView.removeFooterView(view_more);
        }
    }

    private void initViews(View view) {
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        listView = (ListView)view.findViewById(R.id.constant_in_listview);
        //得到数据
        str = getArguments().getString(TAG);

        if(str != null && str.endsWith("常用分类")){
            // 构建底部加载布局
            view_more = (View) getActivity().getLayoutInflater().inflate(R.layout.constant_listview_more, null);
            // 进度条
            pb = (ProgressBar) view_more.findViewById(R.id.progressBar);
            // “正在加载...”文本控件
            tvLoad = (TextView) view_more.findViewById(R.id.tv_Load);


            tv_title.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);

        }else{
            tv_title.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            tv_title.setText(str);
            tv_title.setTextColor(Color.GREEN);
        }
    }

    /**
     * 监听listView的滑动状态的改变
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        Log.e("TAG", "lastVisibleIndex = " + lastVisibleIndex);
        Log.e("TAG", "adapter.getCount() = " + adapter.getCount());
        // 滑到底部后自动加载，判断listView已经停止滚动并且最后可视的条目等于adapter的条目
        // 注意这里在listView设置好adpter后，加了一个底部加载布局。
        // 所以判断条件为：lastVisibleIndex == adapter.getCount()
        if (scrollState == SCROLL_STATE_IDLE
                && lastVisibleIndex == adapter.getCount()) {
            /**
             * 这里也要设置为可见，是因为当你真正从网络获取数据且获取失败的时候。
             * 我在失败的方法里面，隐藏了底部的加载布局并提示用户加载失败。所以再次监听的时候需要
             * 继续显示隐藏的控件。因为我模拟的获取数据，失败的情况这里不给出。实际中简单的加上几句代码就行了。
             */
            pb.setVisibility(View.VISIBLE);
            tvLoad.setVisibility(View.VISIBLE);
            loadMoreData();// 加载更多数据
        }
    }

    private void loadMoreData() {
        // 获取此时adapter中的总条目数
        int count = adapter.getCount();
        // 一次加载15条数据，即下拉加载的执行
        if (count + 15 < totalCount) {
            start = count;
            end = start + 15;
            initData(start, end);// 模拟网络获取数据操作
        } else {// 数据不足15条直接加载到结束
            start = count;
            end = totalCount;
            initData(start, end);// 模拟网络获取数据曹祖
            // 数据全部加载完成后，移除底部的view
            listView.removeFooterView(view_more);
            Toast.makeText(getActivity(), "数据已经全部加载", Toast.LENGTH_SHORT).show();
        }
    }

    private void initData(final int start, final int end) {
        // 模拟网络请求获取数据，一次获取15条
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);// 模拟获取数据时的耗时3s
                    for (int i = start; i <= end; i++) {
                        beanList.add(new ConstantMessage(R.mipmap.ic_launcher, "Title" + i, "Content" + i));
                    }
                    // 给handler发消息更新UI，子线程不可以更新UI
                    Message message = new Message();
                    message.what = 1;
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.start();
    }

    /**
     * 监听listView的滑动
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        // 计算最后可见条目的索引
        lastVisibleIndex = firstVisibleItem + visibleItemCount - 1;
        // 当adapter中的所有条目数已经和要加载的数据总条数相等时，则移除底部的View
        if (totalItemCount == totalCount + 1) {
            // 移除底部的加载布局
            listView.removeFooterView(view_more);
        }
    }

}
