package com.ynet.fullview.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static synchronized String getNowTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
