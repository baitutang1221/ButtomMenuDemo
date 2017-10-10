package com.example.administrator.buttommenudemo.bean;

/**
 * Created by Administrator on 2017\10\9 0009.
 */
public class ConstantMessage {

    public int ItemImageResid;
    public String ItemTitle;
    public String ItemContent;

    public ConstantMessage(int itemImageResid, String itemTitle, String itemContent) {
        ItemImageResid = itemImageResid;
        ItemTitle = itemTitle;
        ItemContent = itemContent;
    }

    public int getItemImageResid() {
        return ItemImageResid;
    }

    public void setItemImageResid(int itemImageResid) {
        ItemImageResid = itemImageResid;
    }

    public String getItemTitle() {
        return ItemTitle;
    }

    public void setItemTitle(String itemTitle) {
        ItemTitle = itemTitle;
    }

    public String getItemContent() {
        return ItemContent;
    }

    public void setItemContent(String itemContent) {
        ItemContent = itemContent;
    }
}
