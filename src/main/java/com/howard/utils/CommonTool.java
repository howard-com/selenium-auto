package com.howard.utils;

import java.util.Calendar;

public class CommonTool {
    public static int getCurrentTime(){
        Calendar cal = Calendar.getInstance();
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int mi = cal.get(Calendar.MINUTE);
        //System.out.println(h + ":" + mi);
        int cur = mi + h*100;
        //System.out.println(cur);
        return cur;
    }
}
