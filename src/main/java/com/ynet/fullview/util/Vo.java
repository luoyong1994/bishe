package com.ynet.fullview.util;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 16:57
 * Description: No Description
 */
public class Vo {
    //图片路径
    private String imagePath;
    //公告
    private String notify;
    //留言
    private List messages;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public List getMessages() {
        return messages;

    }

    public void setMessages(List messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Vo{" +
                "imagePath='" + imagePath + '\'' +
                ", notify='" + notify + '\'' +
                ", messages=" + messages +
                '}';
    }
}
