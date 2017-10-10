package com.example.administrator.buttommenudemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.buttommenudemo.R;
import com.example.administrator.buttommenudemo.bean.ConstantMessage;

import java.util.List;

/**
 * Created by Administrator on 2017\10\9 0009.
 */

public class ConstantAdapter extends BaseAdapter {

    private List<ConstantMessage> list = null;

    private Context context = null;

    private LayoutInflater inflater = null;

    public ConstantAdapter(List<ConstantMessage> list, Context context) {
        this.list = list;
        this.context = context;
        // 布局装载器对象
        if(context != null){
            inflater = LayoutInflater.from(context);
        }
    }

    // 适配器中数据集中数据的个数
    @Override
    public int getCount() {
        return list.size();
    }

    // 获取数据集中与指定索引对应的数据项
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    // 获取指定行对应的ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 获取每一个Item显示的内容
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.constant_listview_item2, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.id_iv);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.id_tvTitle);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.id_tvContent);
            convertView.setTag(viewHolder);// 通过setTag将ViewHolder和convertView绑定
        }  else {
            viewHolder = (ViewHolder) convertView.getTag(); // 获取，通过ViewHolder找到相应的控件
        }
        ConstantMessage itemBean = list.get(position);
        viewHolder.imageView.setImageResource(itemBean.ItemImageResid);
        viewHolder.tvTitle.setText(itemBean.ItemTitle);
        viewHolder.tvContent.setText(itemBean.ItemContent);
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvContent;
    }
}
