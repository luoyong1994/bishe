package com.ynet.fullview.util;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 18:38
 * Description: No Description
 */
public class ID {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
