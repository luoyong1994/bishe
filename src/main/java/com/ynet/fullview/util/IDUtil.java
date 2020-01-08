package com.ynet.fullview.util;

import java.util.UUID;

public class IDUtil {

    public static String generaryId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
