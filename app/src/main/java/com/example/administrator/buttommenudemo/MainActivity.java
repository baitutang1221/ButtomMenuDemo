package com.example.administrator.buttommenudemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.buttommenudemo.fragment.firstceng.ConstantFragment;
import com.example.administrator.buttommenudemo.fragment.firstceng.DiscoveryFragment;
import com.example.administrator.buttommenudemo.fragment.firstceng.PersonFragment;
import com.example.administrator.buttommenudemo.fragment.firstceng.WechatFragment;

public class MainActivity extends FragmentActivity{

    // 四个按钮
    private ImageButton id_tab_weixin_img;
    private ImageButton id_tab_address_img;
    private ImageButton id_tab_frd_img;
    private ImageButton id_tab_settings_img;

    //四个文字
    private TextView id_tab_weixin_tv;
    private TextView id_tab_address_tv;
    private TextView id_tab_frd_tv;
    private TextView id_tab_settings_tv;


    // 布局管理器
    private FragmentManager fManager;

    private WechatFragment wechatFragment;
    private ConstantFragment constantFragment;
    private DiscoveryFragment discoveryFragment;
    private PersonFragment personFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();

        //默认
        clickMenu(findViewById(R.id.id_tab_weixin));
    }


    /**
     * 初始化设置
     */
    private void initView() {
        fManager = getSupportFragmentManager();

        id_tab_weixin_img = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        id_tab_address_img = (ImageButton) findViewById(R.id.id_tab_address_img);
        id_tab_frd_img = (ImageButton) findViewById(R.id.id_tab_frd_img);
        id_tab_settings_img = (ImageButton) findViewById(R.id.id_tab_settings_img);

        id_tab_weixin_tv = (TextView) findViewById(R.id.id_tab_weixin_tv);
        id_tab_address_tv = (TextView) findViewById(R.id.id_tab_address_tv);
        id_tab_frd_tv = (TextView) findViewById(R.id.id_tab_frd_tv);
        id_tab_settings_tv = (TextView) findViewById(R.id.id_tab_settings_tv);
    }


    /**
     * 点击底部菜单事件
     * @param v
     */
    public void clickMenu(View v){
        FragmentTransaction trans = fManager.beginTransaction();
        int vID = v.getId();

        // 设置menu样式
        setMenuStyle(vID);

        // 隐藏所有的fragment
        hideFrament(trans);

        // 设置Fragment
        setFragment(vID,trans);
        trans.commit();
    }


    /**
     * 隐藏所有的fragment(编程初始化状态)
     * @param trans
     */
    private void hideFrament(FragmentTransaction trans) {
        if(wechatFragment!=null){
            trans.hide(wechatFragment);
        }
        if(discoveryFragment!=null){
            trans.hide(discoveryFragment);
        }
        if(constantFragment!=null){
            trans.hide(constantFragment);
        }
        if(personFragment!=null){
            trans.hide(personFragment);
        }
    }

    /**
     * 设置menu样式
     * @param vID
     */
    private void setMenuStyle(int vID) {
        // 首页
        if(vID==R.id.id_tab_weixin){
            id_tab_weixin_img.setImageDrawable(getResources().getDrawable(R.drawable.tab_weixin_pressed));
            id_tab_weixin_tv.setTextColor(getResources().getColor(R.color.menu_click));
        }else {
            id_tab_weixin_img.setImageDrawable(getResources().getDrawable(R.drawable.tab_weixin_normal));
            id_tab_weixin_tv.setTextColor(getResources().getColor(R.color.menu_nomarl));
        }
        // 通讯录
        if(vID==R.id.id_tab_address){
            id_tab_address_img.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_pressed));
            id_tab_address_tv.setTextColor(getResources().getColor(R.color.menu_click));
        }else {
            id_tab_address_img.setImageDrawable(getResources().getDrawable(R.drawable.tab_address_normal));
            id_tab_address_tv.setTextColor(getResources().getColor(R.color.menu_nomarl));
        }
        // 发现
        if(vID==R.id.id_tab_frd){
            id_tab_frd_img.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_pressed));
            id_tab_frd_tv.setTextColor(getResources().getColor(R.color.menu_click));
        }else {
            id_tab_frd_img.setImageDrawable(getResources().getDrawable(R.drawable.tab_find_frd_normal));
            id_tab_frd_tv.setTextColor(getResources().getColor(R.color.menu_nomarl));
        }
        // 我的
        if(vID==R.id.id_tab_settings){
            id_tab_settings_img.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_pressed));
            id_tab_settings_tv.setTextColor(getResources().getColor(R.color.menu_click));
        }else {
            id_tab_settings_img.setImageDrawable(getResources().getDrawable(R.drawable.tab_settings_normal));
            id_tab_settings_tv.setTextColor(getResources().getColor(R.color.menu_nomarl));
        }
    }

    /**
     * 设置Fragment
     * @param vID
     * @param trans
     */
    private void setFragment(int vID,FragmentTransaction trans) {
        switch (vID) {
            case R.id.id_tab_weixin:
                if(wechatFragment==null){
                    wechatFragment = new WechatFragment();
                    trans.add(R.id.id_viewpage, wechatFragment);
                }else{
                    trans.show(wechatFragment);
                }
                break;
            case R.id.id_tab_address:
                if(constantFragment==null){
                    constantFragment = new ConstantFragment();
                    trans.add(R.id.id_viewpage, constantFragment);
                }else{
                    trans.show(constantFragment);
                }
                break;
            case R.id.id_tab_frd:
                if(discoveryFragment==null){
                    discoveryFragment = new DiscoveryFragment();
                    trans.add(R.id.id_viewpage, discoveryFragment);
                }else{
                    trans.show(discoveryFragment);
                }
                break;
            case R.id.id_tab_settings:
                if(personFragment==null){
                    personFragment = new PersonFragment();
                    trans.add(R.id.id_viewpage, personFragment);
                }else{
                    trans.show(personFragment);
                }
                break;
            default:
                break;
        }
    }

}

